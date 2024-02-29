package co.com.mentalhealth.apigateway.service;


import co.com.mentalhealth.apigateway.model.LoginResponseDTO;
import co.com.mentalhealth.apigateway.model.UserModel;
import co.com.mentalhealth.apigateway.security.UserPrincipal;

public interface AuthenticationService {
    LoginResponseDTO singInAndReturnJWT(UserModel singInRequest);

    LoginResponseDTO checkToken(UserModel userModel);
}
