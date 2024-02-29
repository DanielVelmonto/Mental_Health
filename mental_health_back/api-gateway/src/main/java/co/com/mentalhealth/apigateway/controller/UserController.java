package co.com.mentalhealth.apigateway.controller;

import co.com.mentalhealth.apigateway.model.Role;
import co.com.mentalhealth.apigateway.security.UserPrincipal;
import co.com.mentalhealth.apigateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/userModel")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){
        userService.changeRole(role, userPrincipal.getUsername());

        return ResponseEntity.ok(true);
    }

    @PutMapping("changePass/{pass}")
    public ResponseEntity<?> changePass(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable String pass){
        userService.changePass(pass, userPrincipal.getUsername());

        return ResponseEntity.ok(true);
    }
}
