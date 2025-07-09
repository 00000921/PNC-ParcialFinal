package com.uca.parcialfinalncapas.config;

import com.uca.parcialfinalncapas.entities.User;
import com.uca.parcialfinalncapas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Crear usuarios de prueba si no existen
        if (userRepository.count() == 0) {
            User user = User.builder()
                    .nombre("Usuario Prueba")
                    .correo("user@test.com")
                    .password(passwordEncoder.encode("user123"))
                    .nombreRol("USER")
                    .build();
            userRepository.save(user);

            User tech = User.builder()
                    .nombre("Técnico Prueba")
                    .correo("tech@test.com")
                    .password(passwordEncoder.encode("tech123"))
                    .nombreRol("TECH")
                    .build();
            userRepository.save(tech);

            System.out.println("✅ Usuarios de prueba creados:");
            System.out.println("   - user@test.com / user123");
            System.out.println("   - tech@test.com / tech123");
        }
    }
}