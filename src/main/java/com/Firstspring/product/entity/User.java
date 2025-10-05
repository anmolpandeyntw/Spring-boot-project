package com.Firstspring.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Add this import for @Table annotation
import lombok.Data; // Already there
import lombok.NoArgsConstructor; // Good practice for entities
import lombok.AllArgsConstructor; // Good practice for entities

@Entity
@Data
@Table(name = "users") // Explicitly define the table name
@NoArgsConstructor // Lombok annotation for no-argument constructor (required by JPA)
@AllArgsConstructor // Lombok annotation for all-argument constructor (convenience)
public class User { // This is YOUR custom JPA Entity User

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) // Ensures usernames are unique and not null
    private String username;

    @Column(nullable = false) // Ensures password is not null
    private String password;

    @Column(nullable = false) // Add this for storing roles (e.g., "ROLE_ADMIN,ROLE_SELLER")
    private String roles;
}