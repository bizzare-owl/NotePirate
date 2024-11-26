package org.notepirate.controllers;

import lombok.RequiredArgsConstructor;
import org.notepirate.domain.Note;
import org.notepirate.usecases.GetNoteUseCase;
import org.notepirate.usecases.SaveNoteUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final GetNoteUseCase getNoteUseCase;
    private final SaveNoteUseCase saveNoteUseCase;

    @GetMapping("/{noteId}")
    public Note getNote(@PathVariable("noteId") String noteId) {
        return getNoteUseCase.get(noteId);
    }

    @PostMapping
    public void saveNote(@RequestBody Note note) {
        saveNoteUseCase.save(note);
    }

}
