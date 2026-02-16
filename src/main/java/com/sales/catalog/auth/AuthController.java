package com.sales.catalog.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwt;

    public AuthController(JwtService jwt) {
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest body) {

        String username = (body.getUsername() == null) ? "" : body.getUsername().trim();
        String password = (body.getPassword() == null) ? "" : body.getPassword().trim();

        // ✅ por enquanto: usuários fixos (igual ao Basic)
        if (username.equals("admin") && password.equals("123")) {
            String token = jwt.generateToken("admin", "ADMIN");
            return ResponseEntity.ok(new LoginResponse(token));
        }

        if (username.equals("user") && password.equals("123")) {
            String token = jwt.generateToken("user", "USER");
            return ResponseEntity.ok(new LoginResponse(token));
        }

        // login inválido
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(null));
    }
}
