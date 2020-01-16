package com.project.workshopmanagment.security;

import com.project.workshopmanagment.entity.*;
import com.project.workshopmanagment.entity.role.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authorit = new SimpleGrantedAuthority("ROLE_"+ JWTAuthorizationFilter.loginPrincipal.getId());
        authorities.add(authorit);
//        this.user.getPermisionsLists().forEach(p ->{
//                GrantedAuthority authority = new SimpleGrantedAuthority(p);
//                authorities.add(authority);
//        });

        for (Role i : this.user.getRoles()){

            if (i instanceof Grader){
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_GRADER");
                authorities.add(authority);
            }else if (i instanceof SysAdmin){
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_SYSADMIN");
                authorities.add(authority);
            }else if (i instanceof Organizer){
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ORGANIZER");
                authorities.add(authority);
            }else if(i instanceof Participant){
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_PARTICIPANT");
                authorities.add(authority);
            }else if(i instanceof FinancialManager){
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_FINANCIALMANAGER");
                authorities.add(authority);
            }
        }


        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getHashedPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
