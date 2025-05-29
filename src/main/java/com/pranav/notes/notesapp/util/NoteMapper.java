package com.pranav.notes.notesapp.util;

import com.pranav.notes.notesapp.dto.NoteDTO;
import com.pranav.notes.notesapp.model.Note;

import java.time.format.DateTimeFormatter;

public class NoteMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static NoteDTO toDTO(Note note){
        NoteDTO dto = new NoteDTO();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCreatedAt(note.getCreatedAt().format(formatter));
        dto.setUpdatedAt(note.getUpdatedAt().format(formatter));
        return dto;
    }

    public static Note toEntity(NoteDTO dto){
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return note;
    }
}
