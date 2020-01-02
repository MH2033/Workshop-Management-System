//package com.project.workshopmanagment;
//
//import com.project.workshopmanagment.entity.User;
//import com.project.workshopmanagment.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserPrincipalDetailsService implements UserDetailsService {
//    private UserRepository userRepositor;
//
//    public UserPrincipalDetailsService(UserRepository userRepositor) {
//        this.userRepositor = userRepositor;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = this.userRepositor.findByEmail(s);
//
//        UserPrincipal userPrincipal = new UserPrincipal(user);
//        return userPrincipal;
//    }
//}
