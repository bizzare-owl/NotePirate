package org.notepirate.usecases;

import lombok.RequiredArgsConstructor;
import org.notepirate.domain.Note;
import org.notepirate.usecases.persistence.NotePersister;

@RequiredArgsConstructor
public class SaveNoteUseCase {

    private final NotePersister notePersister;

    public void save(Note note) {
        notePersister.save(note);
    }

}
