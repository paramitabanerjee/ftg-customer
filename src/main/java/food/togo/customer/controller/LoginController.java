package food.togo.customer.controller;

import food.togo.customer.controller.request.LoginRequest;
import food.togo.customer.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createCustomer(@RequestBody LoginRequest loginRequest) {

        try {
            boolean isAuthenticatedUser = authenticationService.authenticate(loginRequest);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
