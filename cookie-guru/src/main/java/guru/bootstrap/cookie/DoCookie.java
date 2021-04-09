package guru.bootstrap.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author tangcheng
 */
public class DoCookie {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final Cookie[] rawCookies;

    public DoCookie(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.rawCookies = request.getCookies();
    }

    // ------------------------------------ add cookie ------------------------------------ //

    /**
     * 设置会话Cookie
     *
     * @param name  cookie名
     * @param value cookie值
     */
    public void addSessionCookie(String name, String value) {
        addCookie(name, value, -1);
    }

    /**
     * 添加Cookie
     */
    public void addCookie(String name, String value, int age) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(age);
        cookie.setPath("/");
        this.response.addCookie(cookie);
    }

    public void addCookie(String name, String value, String domain, String path, int age) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        cookie.setMaxAge(age);
        cookie.setDomain(domain);
        response.addCookie(cookie);
    }

    public void addCookie(Cookie cookie) {
        this.response.addCookie(cookie);
    }

    // ------------------------------------ delete cookie ------------------------------------ //

    /**
     * 根据名称删除Cookie
     *
     * @param cookieName cookie名
     */
    public void deleteCookie(String cookieName) {
        Cookie cookie = getCookie(cookieName);
        cookie.setMaxAge(0);
        addCookie(cookie);
    }

    // ------------------------------------ read cookie ------------------------------------- //

    /**
     * 根据名称获取Cookie原始值
     *
     * @param cookieName cookie名
     * @return 未解密的cookie值
     */
    public String getCookieRawValue(String cookieName) {
        Cookie cookie = getCookie(cookieName);
        if (cookie == null) {
            return null;
        }
        return cookie.getValue();
    }

    /**
     * 根据名称获取Cookie
     *
     * @param cookieName cookie名
     * @return Cookie
     */
    private Cookie getCookie(String cookieName) {
        if (cookieName == null
                || cookieName.trim().length() == 0) {
            return null;
        }
        if (this.rawCookies == null
                || this.rawCookies.length == 0) {
            return null;
        }
        for (Cookie cookie : this.rawCookies) {
            if (cookie == null) {
                continue;
            }
            if (cookieName.equalsIgnoreCase(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    // --------------------------------------- Base64 --------------------------------------- //

    /**
     * base64 编码
     *
     * @param rawValue 编码文本
     * @return 编码后的文本
     */
    private String base46Encode(String rawValue) {
        return Base64.getEncoder().encodeToString(rawValue.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * base64解码
     *
     * @param encodedValue
     * @return
     */
    private String base46Decode(String encodedValue) {
        byte[] data = Base64.getDecoder().decode(encodedValue.getBytes(StandardCharsets.UTF_8));
        return new String(data);
    }

    // ------------------------------------ public getters ------------------------------------- //

    /**
     * 获取请求中所有Cookie
     */
    public Cookie[] getRawCookies() {
        return rawCookies;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}
// 2020/9/9 16:26
