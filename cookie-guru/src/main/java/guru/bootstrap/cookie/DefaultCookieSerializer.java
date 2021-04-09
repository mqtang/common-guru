package guru.bootstrap.cookie;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * https://web.dev/samesite-cookies-explained
 * https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Set-Cookie
 *
 * @author tangcheng
 */
public class DefaultCookieSerializer implements ICookieSerializer {

    private static final String DEFAULT_DOMAIN = "bootstrap.guru";
    private static final String DEFAULT_SAME_SITE = SameSiteEnum.LAX.getSameSite();
    private static final String DEFAULT_COOKIE_PATH = "/";

    private String domain = DEFAULT_DOMAIN;
    private String path = DEFAULT_COOKIE_PATH;
    private Boolean httpOnly = true;
    /**
     * Cookies with {@code SameSite=None} must also specify the {@code Secure} attribute
     */
    private String sameSite = DEFAULT_SAME_SITE;

    @Override
    public void writeCookie(HttpCookie cookie) {
        StringBuilder builder = new StringBuilder();
        builder.append(cookie.getName()).append("=").append(cookie.getValue());
        builder.append("; Domain=").append(this.domain)
                .append("; Path=").append(this.path);
        int age = cookie.getAge();
        if (age > -1) {
            ZonedDateTime expires = ZonedDateTime.now(Clock.systemUTC()).plusSeconds(age);
            builder.append("; Max-Age=").append(age)
                    .append("; Expires=")
                    .append(expires.format(DateTimeFormatter.RFC_1123_DATE_TIME));
        }
        if (cookie.getRequest().isSecure()) {
            builder.append("; Secure");
        }
        if (this.httpOnly) {
            builder.append("; HttpOnly");
        }
        builder.append("; SameSite=").append(this.sameSite);
        cookie.getResponse().addHeader("Set-Cookie", builder.toString());
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getHttpOnly() {
        return httpOnly;
    }

    public void setHttpOnly(Boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public String getSameSite() {
        return sameSite;
    }

    public void setSameSite(String sameSite) {
        this.sameSite = sameSite;
    }
}
// created at 2021/3/20 16:33
