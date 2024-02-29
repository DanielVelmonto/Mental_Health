package co.com.mentalhealth.apigateway.controller;


import co.com.mentalhealth.apigateway.model.UserModel;
import co.com.mentalhealth.apigateway.service.AuthenticationService;
import co.com.mentalhealth.apigateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
