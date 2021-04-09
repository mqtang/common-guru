package guru.bootstrap.encrypt;

public interface PasswordEncryptor {
    String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
