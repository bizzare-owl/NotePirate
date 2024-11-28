package org.notepirate.configuration;

import org.notepirate.controllers.NoteController;
import org.notepirate.controllers.SignUpController;
import org.notepirate.usecases.GetNoteUseCase;
import org.notepirate.usecases.SaveNoteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class ControllersConfiguration {

    @Bean
    public NoteController noteController(GetNoteUseCase getNoteUseCase, SaveNoteUseCase saveNoteUseCase) {
        return new NoteController(getNoteUseCase, saveNoteUseCase);
    }

    @Bean
    public SignUpController signUpController(UserDetailsManager userDetailsService, PasswordEncoder passwordEncoder) {
        return new SignUpController(userDetailsService, passwordEncoder);
    }

}
