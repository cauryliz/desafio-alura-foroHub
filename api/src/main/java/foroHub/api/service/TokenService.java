package foroHub.api.service;

import foroHub.api.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import java.util.Date;

import static java.security.KeyRep.Type.SECRET;

@Service
public class TokenService {
    private static final String SECRET = "mi-clave-secreta-segura-12345678901234567890";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getLogin())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String getSubject(String token) {
        if (token == null) throw new RuntimeException("Token nulo");
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
