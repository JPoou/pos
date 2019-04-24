package dev.poou.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.poou.pos.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
