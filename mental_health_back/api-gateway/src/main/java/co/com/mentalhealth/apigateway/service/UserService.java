package co.com.mentalhealth.apigateway.service;


import co.com.mentalhealth.apigateway.model.Role;
import co.com.mentalhealth.apigateway.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);

    void changePass(String pass, String username);
}
