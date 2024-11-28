package E_Doctor.internship_Project.Controller;



import E_Doctor.internship_Project.Advices.ApiError;
import E_Doctor.internship_Project.DTO.RegisterUserDTo;
import E_Doctor.internship_Project.Entity.User;
import E_Doctor.internship_Project.DTO.LoginRequest;
import E_Doctor.internship_Project.Service.UserService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/loadAdmins")
      public String loadAdmins() {
         userService.loadUsers();
        return  "Admins Loaded Successfully";
    }

    @PostMapping("/register")
    public ResponseEntity<ApiError> registerUser(@RequestBody @Valid RegisterUserDTo userDto) {
        return userService.registerNewUser(userDto);
    }



    @PostMapping("/login")
    public ResponseEntity<ApiError> login(@RequestBody LoginRequest loginRequest) {
        ApiError apiError = userService.authenticateUser(loginRequest);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }







}

