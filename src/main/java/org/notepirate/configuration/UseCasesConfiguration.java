package org.notepirate.configuration;

import org.notepirate.usecases.GetNoteUseCase;
import org.notepirate.usecases.SaveNoteUseCase;
import org.notepirate.usecases.persistence.NotePersister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public GetNoteUseCase getNoteUseCase(NotePersister notePersister) {
        return new GetNoteUseCase(notePersister);
    }

    @Bean
    public SaveNoteUseCase saveNoteUseCase(NotePersister notePersister) {
        return new SaveNoteUseCase(notePersister);
    }

}
