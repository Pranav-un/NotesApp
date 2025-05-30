package com.pranav.notes.notesapp.service;


import com.pranav.notes.notesapp.dto.AuthResponseDTO;
import com.pranav.notes.notesapp.dto.UserDTO;
import com.pranav.notes.notesapp.mapper.UserMapper;
import com.pranav.notes.notesapp.model.User;
import com.pranav.notes.notesapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void register(UserDTO userDTO) {
        Optional<User>existingUser = userRepository.findByUsername(userDTO.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        User user = UserMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public AuthResponseDTO login(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        boolean passwordMatch = passwordEncoder.matches(userDTO.getPassword(), user.getPassword());

        if (!passwordMatch) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponseDTO(token);

    }
}
