package guru.bootstrap.encrypt;

/**
 * @author tangcheng
 */
public interface EncryptComponent {
    String encode(Long id);

    Long decode(String encodedId);
}
// 2020/9/9 21:54
