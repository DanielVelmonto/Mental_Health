package co.com.mentalhealth.apigateway.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String name;

    private Role role;
}
