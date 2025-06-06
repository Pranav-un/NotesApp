package com.noteapp.noteapp.repository;

import com.noteapp.noteapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    Optional<User> findByEmailAndActiveTrue(String email);
}
