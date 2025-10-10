//package com.Firstspring.product.security;
//
//
//import com.sun.jdi.request.StepRequest;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.security.SecureRandom;
//import java.text.DecimalFormat;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//import java.util.function.Function;
//
//@Component
//
//public class JwtUtil {
//private static  String secretKey;
//JwtUtil(){
//    SecureRandom random=new SecureRandom();
//    byte[]key =new byte[32]; //256 bits
//    random.nextBytes(key);
//    secretKey= Base64.getEncoder().encodeToString(key);
//}
//
//    public static String generateToken(String username, List<String> roles){
//        return Jwts.builder()
//                .setSubject(username)
//                .claim("roles", roles) // ✅ fixed to match extractRole
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
//                .signWith(getSigneKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//
//    private static Key getSigneKey(){
//    byte[] keyBytes= Decoders.BASE64.decode(secretKey);
//    return Keys.hmacShaKeyFor(keyBytes);
//
//    }
//    public  Boolean validToken (String token, String username){
//    return (extractUsername(token).equals(username) &&  !isTokenExpired(token));
//    }
//    public String extractUsername(String token){
//    return  extractClaim(token,Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token){
//        return  extractClaim(token,Claims::getExpiration);
//    }
//    public  Boolean isTokenExpired(String token ){
//    return extractExpiration(token).before(new Date());
//    }
//    public List<String > extractRole(String token){
//        return  extractClaim(token,claims->claims.get("roles",List.class));
//    }
//
//
//
//    public  <T> T extractClaim(String token, Function<Claims,T>claimsResolver){
//    final Claims claims=Jwts.parserBuilder()
//            .setSigningKey(getSigneKey())
//            .build()
//            .parseClaimsJws(token)
//            .getBody() ;
//                return claimsResolver.apply(claims);
//
//}
//
//
//}
//
//
//
//
