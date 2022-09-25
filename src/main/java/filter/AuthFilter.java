package filter;

import model.UserRole;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

/**
 * Acidification filter.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session.getAttribute("username")) &&
                nonNull(session.getAttribute("password"))
        && nonNull(session.getAttribute("role"))) {
            moveToWelcomePage(req, res);
        } else {
            //req.getRequestDispatcher("signin.jsp").forward(req, res);
              res.sendRedirect("signin.jsp");
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToWelcomePage(final HttpServletRequest req,
                                   final HttpServletResponse res)
            throws ServletException, IOException {
        //req.getRequestDispatcher("welcome.jsp").forward(req, res);
        res.sendRedirect("welcome.jsp");
    }


    @Override
    public void destroy() {
    }

}