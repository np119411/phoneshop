
package com.phoneshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.PhoneDTO;


@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
public class AddProductController extends HttpServlet {

    private static final String ERROR = "admin-product.jsp";
    private static final String SUCCESS = "admin-product.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            UUID uuid = UUID.randomUUID();
            String ID = uuid.toString();
            String name = request.getParameter("name");
            String image = request.getParameter("img");
            String description = request.getParameter("des");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int price = Integer.parseInt(request.getParameter("price"));
            int priceDel = Integer.parseInt(request.getParameter("priceDel"));
            int typeID = Integer.parseInt(request.getParameter("typeID"));
            String createDate = request.getParameter("ngayNhap");
            String brand = request.getParameter("brand");
            
            PhoneDTO product = new PhoneDTO(ID, name, description, brand, price, priceDel, createDate, image, typeID, quantity);
            PhoneDAO dao = new PhoneDAO();
            
            boolean check = dao.insertProduct(product);
            
            if (check) {
                url = SUCCESS;
            }
        } 
        catch (Exception e) {
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
