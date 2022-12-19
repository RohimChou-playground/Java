package com.rohim.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharsetFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) 
        throws IOException, ServletException {

        if (req.getCharacterEncoding() == null) {
            req.setCharacterEncoding("UTF-8");
        }

        if (resp.getCharacterEncoding() == null) {
            resp.setCharacterEncoding("UTF-8");
        }

        chain.doFilter(req, resp);
    }

    public void destroy() {
        // TODO Auto-generated method stub
        
    }
}
