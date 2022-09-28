package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final HttpSession session = req.getSession();
        System.out.println("In filter");

        if (nonNull(session.getAttribute("username")) &&
                nonNull(session.getAttribute("password"))
                && nonNull(session.getAttribute("role"))) {
            moveToHomePage(req, res);
        } else {
            res.sendRedirect("signin.jsp");
        }
    }

    private void moveToHomePage(final HttpServletRequest req,
                                final HttpServletResponse res)
            throws IOException {
        res.sendRedirect("/home.jsp");
    }
}