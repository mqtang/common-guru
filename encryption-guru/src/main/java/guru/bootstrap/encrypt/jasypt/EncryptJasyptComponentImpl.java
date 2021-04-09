package guru.bootstrap.encrypt.jasypt;

import guru.bootstrap.encrypt.EncryptComponent;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;

/**
 * @author tangcheng
 */
public class EncryptJasyptComponentImpl implements EncryptComponent {

    private final PooledPBEStringEncryptor encryptor;

    public EncryptJasyptComponentImpl(JasyptProperties properties) {
        assert properties != null;
        this.encryptor = new PooledPBEStringEncryptor();
        this.encryptor.setPassword(properties.getPassword());
        this.encryptor.setPoolSize(properties.getPoolSize());
        this.encryptor.setAlgorithm(properties.getAlgorithm());
        this.encryptor.setStringOutputType(properties.getStringOutputType());
    }

    @Override
    public String encode(Long id) {
        try {
            return encryptor.encrypt(String.valueOf(id));
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Long decode(String encodedId) {
        try {
            return Long.valueOf(encryptor.decrypt(encodedId));
        } catch (Exception ex) {
            return null;
        }
    }

}
// 2020/9/9 22:13
