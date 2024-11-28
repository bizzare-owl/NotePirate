package org.notepirate.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.notepirate.controllers.dto.SignUpUserDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/signup")
@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public void signUp(@RequestBody SignUpUserDto signUpUserDto, HttpServletResponse httpServletResponse) {
        if (userDetailsManager.userExists(signUpUserDto.getUsername())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        userDetailsManager.createUser(User.builder()
                .username(signUpUserDto.getUsername())
                .password(passwordEncoder.encode(signUpUserDto.getPassword()))
                .roles("USER")
                .build()
        );
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }

}
