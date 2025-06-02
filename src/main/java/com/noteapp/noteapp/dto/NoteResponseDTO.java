package com.noteapp.noteapp.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NoteResponseDTO {
    private Long id;
    private String title;
    private String content;
    private boolean archived;
    private UserResponseDTO user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
