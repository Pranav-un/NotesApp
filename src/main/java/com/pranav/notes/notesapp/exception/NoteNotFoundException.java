package com.pranav.notes.notesapp.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long id) {
        super("Note not found with id: " + id);
    }

}
