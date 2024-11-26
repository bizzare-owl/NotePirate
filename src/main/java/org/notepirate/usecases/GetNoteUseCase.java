package org.notepirate.usecases;

import lombok.RequiredArgsConstructor;
import org.notepirate.domain.Note;
import org.notepirate.usecases.persistence.NotePersister;

@RequiredArgsConstructor
public class GetNoteUseCase {

    private final NotePersister notePersister;

    public Note get(String noteId) {
        return notePersister.get(noteId);
    }

}
