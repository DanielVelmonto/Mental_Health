package co.com.mentalhealth.apigateway.service;


import co.com.mentalhealth.apigateway.model.Role;
import co.com.mentalhealth.apigateway.model.UserModel;

import java.util.Optional;

public interface UserService {
    UserModel save(UserModel userModel);

    Optional<UserModel> findByUsername(String username);

    void changeRole(Role newRole, String username);

    void changePass(String pass, String username);
}
