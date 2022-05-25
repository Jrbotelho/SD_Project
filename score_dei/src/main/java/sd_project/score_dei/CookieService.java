package sd_project.score_dei;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

public class CookieService {
    public static void setCookie(HttpServletResponse response, String key, String value, int seconds){
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(seconds);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String key){
        return Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> key.equals(cookie.getName()))
                        .findAny()
        ).map(Cookie::getValue).orElse(null);
    }
}
