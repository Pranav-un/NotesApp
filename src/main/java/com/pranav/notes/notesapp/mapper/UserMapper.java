package com.pranav.notes.notesapp.mapper;

import com.pranav.notes.notesapp.dto.UserDTO;
import com.pranav.notes.notesapp.model.User;

public class UserMapper {

    public static User toEntity(UserDTO dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .roles("ROLE_USER")
                .build();
    }
}
