package co.com.mentalhealth.apigateway.model;

import lombok.Data;

@Data
public class LoginResponseDTO {

    private User user;
    private String token;
}
