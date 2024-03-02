package co.com.mentalhealth.apigateway.security;


import co.com.mentalhealth.apigateway.model.UserModel;
import co.com.mentalhealth.apigateway.service.UserService;
import co.com.mentalhealth.apigateway.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userService.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("El usuario no fue encontrado: "+username));
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(userModel.getRole().name()));
        return UserPrincipal.builder()
                .userModel(userModel)
                .id(userModel.getId())
                .username(username)
                .password(userModel.getPassword())
                .authorities(authorities)
                .build();
    }
}
