package sd_project.score_dei.authentication;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import sd_project.score_dei.CookieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object Handler) throws Exception{
        if (CookieService.getCookie(request, "userId") != null)
        {
            return true;
        }
        response.sendRedirect("/");
        return false;
    }

}
