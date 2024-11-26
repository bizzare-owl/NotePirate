package org.notepirate.usecases.persistence;

import org.notepirate.domain.Note;

public interface NotePersister {

    void save(Note note);

    Note get(String id);

}
