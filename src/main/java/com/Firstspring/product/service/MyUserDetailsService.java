package com.Firstspring.product.service;

import com.Firstspring.product.entity.User; // <<<--- THIS IS NOW YOUR JPA ENTITY
import com.Firstspring.product.repository.UserRepository;
import com.Firstspring.product.security.UserPrincipal; // Assumes this uses your entity.User
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // The 'User' in the parameter and return type here refers to YOUR JPA Entity User
    public User createUser(User user){ // No red line here if your entity.User is correctly imported
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists: " + user.getUsername());
        }
       user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch YOUR JPA Entity User from the database
        Optional<User> userEntityOptional = userRepository.findByUsername(username); // Changed variable name for clarity - this is modif

        if(userEntityOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found anmol!");
        }

        // Pass YOUR JPA Entity User to UserPrincipal
        return new UserPrincipal(userEntityOptional.get());
    }
}