package com.realdolmen.travel.filter;

import com.realdolmen.travel.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@WebFilter("/restricted/*")
public class AuthenticationFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final User user = (User) httpRequest.getSession().getAttribute("user");
        final String path = httpRequest.getRequestURL().toString().toLowerCase();
        boolean isAuthed = false;
        if (user != null){
            System.out.println(user.getUserType());
        }
        else {
            System.out.println("user is null");
        }

    /*    if (role != null) {
            if (path.contains("/restricted/") && role.equals(Role.USER)) {
                isAuthed = false;
            }
            if (path.contains("/restricted/client/") && !role.equals(Role.CLIENT)) {
                isAuthed = false;
            }
            if (path.contains("/restricted/repairer/") && !role.equals(Role.REPAIRER)) {
                isAuthed = false;
            }
        } else {
            isAuthed = false;
        }*/

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
