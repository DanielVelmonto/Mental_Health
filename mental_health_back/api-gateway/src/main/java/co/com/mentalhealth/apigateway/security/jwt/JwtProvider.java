package co.com.mentalhealth.apigateway.security.jwt;


import co.com.mentalhealth.apigateway.model.User;
import co.com.mentalhealth.apigateway.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    String generateToken(User user);

    Authentication getAuthentication(HttpServletRequest request);

    Boolean isTokenValid(HttpServletRequest request);
}
