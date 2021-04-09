package guru.bootstrap.encrypt.jasypt;

/**
 * @author tangcheng
 */
public class JasyptProperties {
    /**
     * jasypt password
     */
    private String password;
    /**
     * algorithm to use
     */
    private String algorithm;

    private Integer poolSize;

    /**
     * base64 or hex
     */
    private String stringOutputType;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public String getStringOutputType() {
        return stringOutputType;
    }

    public void setStringOutputType(String stringOutputType) {
        this.stringOutputType = stringOutputType;
    }
}
// 2020/9/9 22:14
