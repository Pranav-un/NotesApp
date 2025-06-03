package com.noteapp.noteapp.repository;

import com.noteapp.noteapp.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Page<Note> findByUserIdAndArchivedFalse(Long userId, Pageable pageable);

    Page<Note> findByUserIdAndArchivedTrue(Long userId, Pageable pageable);

    Optional<Note> findByIdAndUserId(Long id, Long userId);


//    @Query("SELECT n FROM Note n WHERE n.user.id = :userId " +
//            "AND n.archived = false " +
//            "AND (LOWER(n.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
//            "OR LOWER(n.content) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")

    Page<Note> searchNotes(@Param("userId") Long userId,
                           @Param("searchTerm") String searchTerm,
                           Pageable pageable);


    long countByUserIdAndArchivedFalse(Long userId);
}
