
package com.phoneshop.controller;
import com.phoneshop.phones.PhoneAdmin;
import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.Type;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetProductController", urlPatterns = {"/GetProductController"})
public class GetProductController extends HttpServlet {

    private static final String ERROR = "admin-product.jsp";
    private static final String SUCCESS = "admin-product.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try {
            PhoneDAO dao = new PhoneDAO();
            List<PhoneAdmin> productList = dao.getAllProduct();
            List<Type> typeList = dao.getType();
            
            if (!productList.isEmpty()) {
                request.setAttribute("ALL_PRODUCT_LIST", productList);
                request.setAttribute("TYPE_LIST", typeList);
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
