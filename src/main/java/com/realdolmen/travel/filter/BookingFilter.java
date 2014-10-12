package com.realdolmen.travel.filter;

import com.realdolmen.travel.controller.UserController;
import com.realdolmen.travel.domain.*;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@WebFilter("/restricted/customer/confirmbooking.xhtml")
public class BookingFilter implements Filter {
    @Inject
    private UserController userController;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final String path = httpRequest.getRequestURL().toString().toLowerCase();


        if (userController.getSelectedTrip() == null) {
            final HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/index.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
