//package org.example.springboottest2.SS13.Security;
//
//
//import org.example.springboottest2.SS13.model.User;
//import org.example.springboottest2.SS13.repository.UserRepository;
//import org.example.springboottest2.SS13.service.UserPrincipal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserDetailServiceCustom implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found: " + username));
//
//        List<SimpleGrantedAuthority> authorities =
//                List.of(new SimpleGrantedAuthority(user.getRole()));
//
//        return new UserPrincipal(user, authorities);
//    }
//}
