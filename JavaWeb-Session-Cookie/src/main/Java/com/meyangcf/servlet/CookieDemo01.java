package com.meyangcf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 服务器告诉你你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了
        // 解决中文乱码
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        // Cookie，服务器从客户端获取
        Cookie[] cookies = req.getCookies(); // 获得Cookie 可能存在多个Cookie
        // 判断Cookie是否存在
        if (cookies!=null){
            // 如果存在Cookie怎么办
            out.write("您上一次访问的时间是：");
            for (Cookie cookie : cookies) {
                // 获取Cookie的信息
                if (cookie.getName().equals("lastLoginTime")){
                    long lastLongTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLongTime);
                    out.write(date.toLocaleString());
                }
            }
        }else {
            out.write("这是您第一次访问本网站");
        }
        // 服务给客户端响应一个Cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + ""); //新建一个Cookie
        cookie.setMaxAge(1 * 1 * 30); // 设置Cookie的有效期为秒
        resp.addCookie(cookie); // 响应给客户端一个Cookie
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
