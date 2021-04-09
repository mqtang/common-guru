package guru.bootstrap.cookie;

/**
 * @author tangcheng
 */
public enum SameSiteEnum {
    /**
     *
     */
    NONE("None"),
    /**
     *
     */
    LAX("Lax"),
    /**
     *
     */
    STRICT("Strict");
    private String sameSite;

    SameSiteEnum(String sameSite) {
        this.sameSite = sameSite;
    }

    public String getSameSite() {
        return sameSite;
    }
}
// created at 2021/3/25 22:19

