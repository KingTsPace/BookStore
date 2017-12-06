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
@WebServlet(name="RegistServlet",urlPatterns = {"/client/RegistServlet"})
public class RegistServlet extends HttpServlet {

    UserService service= new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");

        User user=new User(null,name,password, email );
        boolean login=service.sign(user);
        if (login){
            response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.html");
        }else{
            request.getRequestDispatcher("/pages/user/regist.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
