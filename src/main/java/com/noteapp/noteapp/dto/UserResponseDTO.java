package com.noteapp.noteapp.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private Long id;
    private String email;
    private String fullName;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}