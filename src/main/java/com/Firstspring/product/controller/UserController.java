//package com.Firstspring.product.controller; // Assuming this is your controller's package
//
//// Remove the incorrect import if it exists:
//// import org.springframework.security.core.userdetails.User;
//
//// Add the correct import for YOUR User entity:
//import com.Firstspring.product.dto.UserDTO;
//import com.Firstspring.product.entity.User; // <<<--- THIS IS THE FIX
//
//import com.Firstspring.product.security.JwtUtil;
//import com.Firstspring.product.service.MyUserDetailsService; // Your service
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//// Removed unnecessary imports like javax.print.DocFlavor if not used
//// import javax.print.DocFlavor;
//
//@RestController
//@RequestMapping("/user") // Ensure this mapping is correct for your routes
//public class UserController {
//
//    @Autowired
//
//private AuthenticationManager authenticationManager;
//    @Autowired
//    private MyUserDetailsService userDetailsService;
//@Autowired
////private JwtUtil jwtUtil;
////    @Autowired
//    private MyUserDetailsService service; // Correct service injection
//
//    @PostMapping("/register")
//    // The 'User' in the parameter and return type must refer to YOUR JPA Entity User
//    public User register(@RequestBody User user){ // This 'User' should now be com.Firstspring.product.entity.User
//        return service.createUser(user);
//    }
//
//    // Add other controller methods here as needed
//@PostMapping("/login")
//    public String login(@RequestBody UserDTO  user ){
// Authentication authentication=  authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//    List<String> roles= authentication.getAuthorities().stream()
//            .map(GrantedAuthority::getAuthority)
//            .toList();
//
// UserDetails userDetails= userDetailsService.loadUserByUsername(user.getUsername());
//   return JwtUtil.generateToken(userDetails.getUsername(),roles);//generateToken ko static banaya hu error aRH thA
//
//    }
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
