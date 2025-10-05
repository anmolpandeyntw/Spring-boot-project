package com.Firstspring.product.repository;

import com.Firstspring.product.entity.User; // <<<--- THIS MUST IMPORT YOUR JPA ENTITY USER
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // This 'User' must be YOUR JPA ENTITY
    Optional<User> findByUsername(String username);
}