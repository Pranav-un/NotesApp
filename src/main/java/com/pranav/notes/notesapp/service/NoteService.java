package com.pranav.notes.notesapp.service;


import com.pranav.notes.notesapp.exception.NoteNotFoundException;
import com.pranav.notes.notesapp.model.Note;
import com.pranav.notes.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public Note createNote(Note note) {

        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {

        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(Long id, Note upadtedNote) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(upadtedNote.getTitle());
                    note.setContent(upadtedNote.getContent());
                    return noteRepository.save(note);
                })
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
