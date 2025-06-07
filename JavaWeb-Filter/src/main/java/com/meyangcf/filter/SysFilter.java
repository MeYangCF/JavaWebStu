package com.meyangcf.filter;


import com.meyangcf.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        // ServletRequest    HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getSession().getAttribute(Constant.USER_SESSION)==null){
            response.sendRedirect("/error.jsp");
        }

        chain.doFilter(request,response);
    }


         /*
            if (req.getSession().setAttribute(Constant.USER_SESSION).level==VIP1){
                response.sendRedirect("/vip1/index.jsp");
            }
            if (req.getSession().setAttribute(Constant.USER_SESSION).level==VIP2){
                response.sendRedirect("/vip2/index.jsp");
            }
            if (req.getSession().setAttribute(Constant.USER_SESSION).level==VIP3){
                response.sendRedirect("/vip2/index.jsp");
            }
         */


    public void destroy() {

    }
}
