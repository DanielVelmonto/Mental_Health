package co.com.mentalhealth.apigateway.service;


import co.com.mentalhealth.apigateway.model.User;

public interface AuthenticationService {
    User singInAndReturnJWT(User singInRequest);
}
