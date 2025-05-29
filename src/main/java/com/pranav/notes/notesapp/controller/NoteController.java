package com.pranav.notes.notesapp.controller;


import com.pranav.notes.notesapp.dto.NoteDTO;
import com.pranav.notes.notesapp.model.Note;
import com.pranav.notes.notesapp.service.NoteService;
import com.pranav.notes.notesapp.util.NoteMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Create a new note
    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody NoteDTO noteDTO) {
        Note createdNote = noteService.createNote(NoteMapper.toEntity(noteDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(NoteMapper.toDTO(createdNote));
    }

    // Get all notes
    @GetMapping
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        List<NoteDTO> notes = noteService.getAllNotes().stream()
                .map(NoteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(notes);
    }

    // Get note by ID
    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(note -> ResponseEntity.ok(NoteMapper.toDTO(note)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    // Update a note
    @PutMapping("/{id}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @Valid @RequestBody NoteDTO updatedDTO) {
        Note updatedNote = noteService.updateNote(id, NoteMapper.toEntity(updatedDTO));
        return ResponseEntity.ok(NoteMapper.toDTO(updatedNote));
    }

    // Delete a note
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}