package dev.poou.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.poou.pos.model.Note;

/**
 * Created by JPoou.
 */

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
