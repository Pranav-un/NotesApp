package com.noteapp.noteapp.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NoteUpdateDTO {

    @Size(min = 1, max = 200, message = "Title must be between 1 and 200 characters")
    private String title;

    @Size(min = 1, message = "Content cannot be empty")
    private String content;

    private Boolean archived;
}
