
package com.phoneshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phoneshop.users.UserDAO;
import com.phoneshop.users.UserDTO;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private static final String ERROR = "login.html";
    private static final String USER = "category.jsp";
    private static final String ADMIN = "admin-product.jsp";
    private static final String CHECKOUT = "checkout.jsp";
    private static final int AD = 1;
    private static final int US = 2;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "login.html";
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            
            UserDAO dao = new UserDAO();
            UserDTO loginUser = dao.checkLogin(userID, password);
            
            HttpSession session = request.getSession();
            session.setAttribute("LOGIN_USER", loginUser);
            
            if (loginUser != null) {
                    session.setAttribute("MESSAGE_ERROR", "Something wrong...");
            }
            else {
                session.setAttribute("MESSAGE_ERROR", "Incorrect user ID or password!");
            }
        } 
        catch (Exception e) {
        }
        finally {
            response.sendRedirect(url);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
