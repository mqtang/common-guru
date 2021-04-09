package guru.bootstrap.encrypt.bcrypt;

import guru.bootstrap.encrypt.PasswordEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author tangcheng
 */
public class PasswordEncryptorImpl implements PasswordEncryptor {
    private PasswordEncoder passwordEncoder;

    public PasswordEncryptorImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
// 2020/9/16 14:40
