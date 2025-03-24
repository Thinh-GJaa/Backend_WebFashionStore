package api.webfashionstore.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "mySecretKeymySecretKeymySecretKeymySecretKey"; // Ít nhất 32 bytes

    // 🔹 Lấy khóa ký từ SECRET_KEY
    private Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(); // ⚠ Không cần BASE64 decode
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 🔹 Tạo token với username và quyền duy nhất
    public String generateToken(String username, String role) {
        return "Bearer "+ Jwts.builder()
                .setSubject(username)
                .claim("role", role) // Chỉ lưu 1 quyền duy nhất
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Hết hạn sau 1 giờ
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔹 Lấy username từ token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // 🔹 Lấy quyền từ token
    public String extractRole(String token) {
        System.out.println("Thinh; "+ extractClaims(token).get("role", String.class));
        return extractClaims(token).get("role", String.class);

    }

    // 🔹 Trích xuất claims từ token
    private Claims extractClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            throw new RuntimeException("Token không hợp lệ hoặc đã hết hạn!");
        }
    }
}
