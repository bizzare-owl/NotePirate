package org.notepirate.configuration;

import org.notepirate.controllers.NoteController;
import org.notepirate.usecases.GetNoteUseCase;
import org.notepirate.usecases.SaveNoteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllersConfiguration {

    @Bean
    public NoteController noteController(GetNoteUseCase getNoteUseCase, SaveNoteUseCase saveNoteUseCase) {
        return new NoteController(getNoteUseCase, saveNoteUseCase);
    }

}
