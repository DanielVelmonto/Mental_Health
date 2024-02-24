package co.com.mentalhealth.apigateway.service;


import co.com.mentalhealth.apigateway.model.User;
import co.com.mentalhealth.apigateway.security.UserPrincipal;
import co.com.mentalhealth.apigateway.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User singInAndReturnJWT(User singInRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(singInRequest.getUsername(), singInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        String jwt = jwtProvider.generateToken(userPrincipal);

        User singInUser = userPrincipal.getUser();

        singInUser.setToken(jwt);

        return singInUser;
    }

}
