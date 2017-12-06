package com.pinker.servlet.client;

import com.pinker.entity.User;
import com.pinker.service.UserService;
import com.pinker.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "LoginServlet",urlPatterns = {"/client/LoginServlet"})
public class LoginServlet extends HttpServlet {

    UserService service=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User(null,name,password,null);
        User loginUser=service.login(user);
        if(loginUser!=null){
            response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
        }else{
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
