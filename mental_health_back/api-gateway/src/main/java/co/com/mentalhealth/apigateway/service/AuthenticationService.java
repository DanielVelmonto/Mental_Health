package co.com.mentalhealth.apigateway.service;


import co.com.mentalhealth.apigateway.model.LoginResponseDTO;
import co.com.mentalhealth.apigateway.model.UserModel;

public interface AuthenticationService {
    LoginResponseDTO singInAndReturnJWT(UserModel singInRequest);
}
