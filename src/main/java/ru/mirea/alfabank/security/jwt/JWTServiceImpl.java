package ru.mirea.alfabank.security.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.alfabank.modeldata.ClientModel;
import ru.mirea.alfabank.properties.TokenProperties;

import java.security.Key;
import java.util.Date;
@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService{

    private final TokenProperties tokenProperties;

    @Override
    public String generateToken(ClientModel clientModel) {
        return Jwts.builder()
                .setSubject(clientModel.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date((System.currentTimeMillis() * 100) + tokenProperties.getTtl()))
                .signWith(generateKey())
                .compact();
    }

    @Override
    public ClientModel parseToke(String jwt) {
        JwtParser jwtParser=Jwts.parserBuilder()
                .setSigningKey(generateKey())
                .build();
        Claims claims = jwtParser.parseClaimsJws(jwt).getBody();
        String email = claims.getSubject();

        return ClientModel.builder().email(email).build();
    }

    private Key generateKey(){
        byte[] keyBytes= tokenProperties.getKey().getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
