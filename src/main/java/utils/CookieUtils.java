package utils;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class CookieUtils {
    private CookieUtils() {
    }

    public static String getCookieValueByName(Cookie[] cookies, String search) {
        return Arrays.stream(cookies)
                .filter(c -> c.getName()
                        .equals(search))
                .map(Cookie::getValue)
                .collect(Collectors.joining());
    }
}
