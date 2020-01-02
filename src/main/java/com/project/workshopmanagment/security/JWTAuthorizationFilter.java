package com.project.workshopmanagment.security;

import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.project.workshopmanagment.security.SecurityConstants.*;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private UserRepository userRepository;

    public JWTAuthorizationFilter(AuthenticationManager authManager, UserRepository userRepository) {
        super(authManager);

        this.userRepository = userRepository;
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
                JWTAuthorizationFilter.loginPrincipal = principal;
                User u = this.userRepository.findByEmail(principal.getEmail());
                UserPrincipal userPrincipal = new UserPrincipal(u);
                return new UsernamePasswordAuthenticationToken(principal, null, userPrincipal.getAuthorities());
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