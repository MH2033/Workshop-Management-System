package com.project.workshopmanagment.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.project.workshopmanagment.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    public static LoginPrincipal loginPrincipal;
    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken lastauthentication = getAuthentication(req);
        JWTAuthorizationFilter.loginPrincipal = (LoginPrincipal) lastauthentication.getPrincipal();
        System.out.println(JWTAuthorizationFilter.loginPrincipal.getId());
        SecurityContextHolder.getContext().setAuthentication(lastauthentication); // set the user here
        chain.doFilter(req, res);
    }


    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            try {
                Map<String, Object> claims = Jwts.parser()
                        .setSigningKey(SECRET_KEY.getBytes())
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();
                LoginPrincipal principal = new LoginPrincipal(claims.get("principal"));
                return new UsernamePasswordAuthenticationToken(principal, null, new ArrayList<>());
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                System.err.println("Jwt is expired");
            }catch (MalformedJwtException e){
                System.err.println("Jwt is wrong");
            }
        }
        System.err.println("Access Denied");
        return null;
    }

}