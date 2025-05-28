package com.pranav.notes.notesapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must not be blank")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Title must not be blank")
    @Column(columnDefinition = "TEXT")
    private String content;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void OnCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void OnUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
