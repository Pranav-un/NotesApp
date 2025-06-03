package com.noteapp.noteapp.mapper;

import com.noteapp.noteapp.dto.NoteCreateDTO;
import com.noteapp.noteapp.dto.NoteResponseDTO;
import com.noteapp.noteapp.dto.NoteUpdateDTO;
import com.noteapp.noteapp.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface NoteMapper {

    @Mapping(target = "user", source = "user")
    NoteResponseDTO toNoteResponseDTO(Note note);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "archived", constant = "false")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Note toEntity(NoteCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(NoteUpdateDTO dto, @MappingTarget Note note);
}
