
package com.phoneshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "404.html";
    private static final String LOGIN = "LoginController";
    private static final String GET_LIST_PHONE = "GetPhone";
    private static final String GET_SHOP_PAGE = "GetShopPage";
    private static final String GET_DETAIL = "GetDetail";
    private static final String GET_TYPE = "GetTypeController";
    private static final String ADD_TO_CART = "AddToCart";
    private static final String ADD_PHONECASE = "AddPhonecase";
    private static final String UPDATE_CART = "UpdateCart";
    private static final String DELETE_CART = "Remove";
    private static final String DELETE_PHONECASE = "RemovePhonecase";
    private static final String LOG_OUT = "LogoutController";
    private static final String GET_PRODUCT = "GetProductController";
    private static final String ADD_PRODUCT = "AddProductController";
    private static final String UPDATE_PRODUCT = "UpdateProductController";
    private static final String DELETE_PRODUCT = "DeleteProductController";
    private static final String CHECKOUT = "Checkout";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)) {
                url = LOGIN;
            }
            else if ("GetPhone".equals(action)) {
                url = GET_LIST_PHONE;
            }    
            else if ("GetShopPage".equals(action)) {
                url = GET_SHOP_PAGE;
            }    
            else if ("GetDetail".equals(action)) {
                url = GET_DETAIL;
            }    
            else if ("GetType".equals(action)) {
                url = GET_TYPE;
            }    
            else if ("AddToCart".equals(action)) {
                url = ADD_TO_CART;
            }    
            else if ("AddPhonecase".equals(action)) {
                url = ADD_PHONECASE;
            }   
            else if ("Checkout".equals(action)) {
                url = CHECKOUT;
            }
            else if ("UpdateCart".equals(action)) {
                url = UPDATE_CART;
            }    
            else if ("Remove".equals(action)) {
                url = DELETE_CART;
            }
            else if ("RemovePhonecase".equals(action)) {
                url = DELETE_PHONECASE;
            }    
            else if ("Logout".equals(action)) {
                url = LOG_OUT;
            }    
            else if ("GetAllProduct".equals(action)) {
                url = GET_PRODUCT;
            }    
            else if ("AddProduct".equals(action)) {
                url = ADD_PRODUCT;
            }    
            else if ("EditProduct".equals(action)) {
                url = UPDATE_PRODUCT;
            }    
            else if ("DeleteProduct".equals(action)) {
                url = DELETE_PRODUCT;
            }    
            else {
                HttpSession session = request.getSession();
                session.setAttribute("CONTROLLER_ERROR_MESSAGE", "This function is not supported!");
            }
        } 
        catch (Exception e) {
            log("Error at MainController: " + e.toString());
        }
        finally {
            request.getRequestDispatcher(url).forward(request, response);
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
