package co.com.mentalhealth.apigateway.service;


import co.com.mentalhealth.apigateway.model.Role;
import co.com.mentalhealth.apigateway.model.UserModel;
import co.com.mentalhealth.apigateway.repository.UserRepository;
import co.com.mentalhealth.apigateway.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public UserModel save(UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setRole(Role.USER);
        userModel.setCreated_at(LocalDateTime.now());
        UserModel userModelCreated = userRepository.save(userModel);
        String jwt = jwtProvider.generateToken(userModelCreated);
        userModelCreated.setToken(jwt);

        return userModelCreated;
    }

    @Override
    public Optional<UserModel> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }

    @Transactional
    @Override
    public void changePass(String pass, String username){
        userRepository.updateUserPass(username, passwordEncoder.encode(pass));
    }
}
