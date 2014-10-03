package com.realdolmen.travel.filter;

import com.realdolmen.travel.controller.UserController;
import com.realdolmen.travel.domain.User;
import com.realdolmen.travel.domain.UserType;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@WebFilter("/restricted/*")
public class AuthenticationFilter implements Filter {
    @Inject
    private UserController userController;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final String path = httpRequest.getRequestURL().toString().toLowerCase();
        boolean isAuthed = true;

        if (userController.getUser() != null) {
            UserType userType = userController.getUser().getUserType();
            if (path.contains("/restricted/customer/") && !userType.equals(UserType.CUSTOMER)) {
                isAuthed = false;
            }
            if (path.contains("/restricted/employee/") && !userType.equals(UserType.EMPLOYEE)) {
                isAuthed = false;
            }
            if (path.contains("/restricted/partner/") && !userType.equals(UserType.PARTNER)) {
                isAuthed = false;
            }
        } else {
            isAuthed = false;
        }

        if (!isAuthed) {
            final HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }


}
