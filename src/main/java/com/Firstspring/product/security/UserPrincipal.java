//package com.Firstspring.product.security;
//
//import com.Firstspring.product.entity.User; // <<<--- THIS MUST BE YOUR JPA ENTITY USER
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails; // <<<--- IMPORTANT: This is the interface to implement
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections; // this is modif: for empty list
//import java.util.List;
//import java.util.stream.Collectors;
//
//// UserPrincipal MUST implement UserDetails (not extend User)
//public class UserPrincipal implements UserDetails { // this is modif: implements UserDetails
//
//    private final User user; // This 'user' field must hold YOUR JPA Entity User
//
//    // Constructor to take your JPA Entity User
//    public UserPrincipal(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        if (user == null || user.getRoles() == null || user.getRoles().isEmpty()) { // this is modif: Handle null user/roles
//            return Collections.emptyList(); // this is modif: Return an empty list for no roles
//        }
//        return Arrays.stream(user.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        //return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    // --- Essential UserDetails methods ---
//    @Override
//    public boolean isAccountNonExpired() {
//        return true; // Implement actual logic if you have account expiration in User entity
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true; // Implement actual logic for account locking
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true; // Implement actual logic for credential expiration
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; // Implement actual logic for user active status
//    }
//
//    // Optional: Getter for your underlying User entity
//    public User getUser() { // this is modif: Added getter for the wrapped entity
//        return user;
//    }
//}