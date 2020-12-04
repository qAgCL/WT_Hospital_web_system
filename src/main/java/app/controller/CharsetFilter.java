package app.controller;

import app.constants.ConstantNameFromJsp;

import javax.servlet.*;
import java.io.IOException;


public class CharsetFilter implements Filter {
    private String encoding;

    public CharsetFilter() {
        super();
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter(ConstantNameFromJsp.CHARACTER_ENCODING_ATTR);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
