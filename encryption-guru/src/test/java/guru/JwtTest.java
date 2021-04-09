package guru;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author tangcheng
 */
public class JwtTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        Map<String, Object> map = new HashMap<>();
//        map.put("uid", 122343543546L);
//        map.put("uname", "tangcheng");
//        String jwt =
//                Jwts.builder()
//                        .setClaims(map)
//                        .signWith(key)
//                        .compact();
//        System.out.println(Base64.getEncoder().encodeToString(jwt.getBytes("UTF-8")));
        StandardPBEStringEncryptor pbeStringEncryptor = new StandardPBEStringEncryptor();
        pbeStringEncryptor.setPassword("root1995");
        String s = pbeStringEncryptor.encrypt("9293939041309123");
        System.out.println(Base64.getEncoder().encodeToString(s.getBytes()));
    }
}
// 2020/9/9 21:18
