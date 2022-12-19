package com.rohim.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println(" ================= requesting " + req.getRequestURL() + " =================");
        
        HttpSession session = req.getSession(false);
        if (session != null) {
            String userName = (String)session.getAttribute("username");
            if (userName != null) {
                System.out.println(" ================= User logged in already =================");
            } else {
                System.out.println(" ================= User still not logged in =================");
            }
        }

        chain.doFilter(req, resp);
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }
}