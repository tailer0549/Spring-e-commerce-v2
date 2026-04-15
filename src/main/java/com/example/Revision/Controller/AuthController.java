package com.example.Revision.Controller;

import com.example.Revision.Service.JWTService;
import com.example.Revision.DTO.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {

        // Validar no banco depois
        if ("admin@email.com".equals(dto.getEmail()) && "123".equals(dto.getPassword())) {
    return jwtService.generateToken(dto.getEmail());
        }

        throw new RuntimeException("Credenciais inválidas");
    }
}


