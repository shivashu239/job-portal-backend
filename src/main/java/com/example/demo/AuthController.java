package com.example.demo;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(
            UserService userService,
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // REGISTER
    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new org.springframework.security.authentication
                        .UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
        );

        User user = userService.findByEmail(request.getEmail());

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(
                new LoginResponse(
                        "Login successful",
                        token,
                        user.getEmail(),
                        user.getRole()
                )
        );
    }

    // Login request
    public static class LoginRequest {

        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Login response
    public static class LoginResponse {

        private String message;
        private String token;
        private String email;
        private String role;

        public LoginResponse(
                String message,
                String token,
                String email,
                String role) {

            this.message = message;
            this.token = token;
            this.email = email;
            this.role = role;
        }

        public String getMessage() {
            return message;
        }

        public String getToken() {
            return token;
        }

        public String getEmail() {
            return email;
        }

        public String getRole() {
            return role;
        }
    }
}