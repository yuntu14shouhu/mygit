package com.ylt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qianjiajia on 2016/11/22.
 */

@WebServlet(
        urlPatterns = {"/Login.do"},
        loadOnStartup = 0,
        name = "Login",
        displayName = "demo",
        initParams = {
                @WebInitParam(name = "success",value = "success.jsp")
        }
)

public class Login extends HttpServlet {
    Map<String ,String > users;

    public Login(){
        users = new HashMap<String, String>();
        users.put("zhangsan","123456");
        users.put("lisi","123456");
        users.put("wangwu","123456");
        users.put("zhaoliu","123456");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        if (users.containsKey(userId)&&users.get(userId).equals(password)){
            request.getSession().setAttribute("user",userId);
            request.getSession().setAttribute("count",MyHttpSessionListener.getCount());
        }
        String success = getInitParameter("success");
        response.sendRedirect(success);
    }


}
