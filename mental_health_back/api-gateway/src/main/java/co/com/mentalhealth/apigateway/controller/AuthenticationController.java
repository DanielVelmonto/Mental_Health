package co.com.mentalhealth.apigateway.controller;


import co.com.mentalhealth.apigateway.model.UserModel;
import co.com.mentalhealth.apigateway.security.UserPrincipal;
import co.com.mentalhealth.apigateway.service.AuthenticationService;
import co.com.mentalhealth.apigateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("sing-up")
    public ResponseEntity<?> singUp(@RequestBody UserModel userModel){
        if (userService.findByUsername(userModel.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.save(userModel), HttpStatus.CREATED);
    }

    @PostMapping("sing-in")
    public ResponseEntity<?> singIn(@RequestBody UserModel userModel){

        return new ResponseEntity<>(authenticationService.singInAndReturnJWT(userModel), HttpStatus.OK);
    }

    @GetMapping("check-token")
    public ResponseEntity<?> checkToken(@AuthenticationPrincipal UserPrincipal userPrincipal){
        Optional<UserModel> userModel = userService.findByUsername(userPrincipal.getUsername());
        if (userModel.isEmpty()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        UserModel prueba = new UserModel();
        prueba.setId(userModel.get().getId());
        prueba.setRole(userModel.get().getRole());
        prueba.setName(userModel.get().getName());
        prueba.setUsername(userModel.get().getUsername());
        prueba.setPassword(userModel.get().getPassword());
        prueba.setCreated_at(userModel.get().getCreated_at());
        return new ResponseEntity<>(authenticationService.checkToken(prueba), HttpStatus.OK);
    }
}
