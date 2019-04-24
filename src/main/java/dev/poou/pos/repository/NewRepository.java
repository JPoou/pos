package dev.poou.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.poou.pos.model.New;

@Repository
public interface NewRepository extends JpaRepository<New, Long> {

}
