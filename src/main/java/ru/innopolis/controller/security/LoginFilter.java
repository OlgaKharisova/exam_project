package ru.innopolis.controller.security;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {

    private final List<String> excludedUrls;

    private final Logger logger = LogManager.getLogger(LoginFilter.class);

    public LoginFilter() {
        excludedUrls = new ArrayList<>();
        excludedUrls.add("/");
        excludedUrls.add("/login");
        excludedUrls.add("/static/css/bootstrap.css");
        excludedUrls.add("/static/css/bootstrap-grid.css");
        excludedUrls.add("/static/css/bootstrap-reboot.css");
        excludedUrls.add("/static/images/favicon.ico");
        excludedUrls.add("/favicon.ico");
    }

    @Override
    public void init(FilterConfig filterConfig)  {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // проверяем есть ли в сесии информация о авторизации
        Boolean isAuth = (Boolean) request.getSession().getAttribute("isAuth");
        if (isAuth != null && isAuth || excludedUrls.contains(request.getRequestURI()))
        {
            logger.debug("Попытка доступа на URI \"" + request.getRequestURI() + "\". Пропускаю...");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            logger.warn("Попытка доступа на URI \"" + request.getRequestURI() + "\". Отправляю на страницу логина");
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
    }
}