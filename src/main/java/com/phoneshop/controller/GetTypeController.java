
package com.phoneshop.controller;
import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.PhoneDTO;
import com.phoneshop.phones.Type;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetTypeController", urlPatterns = {"/GetTypeController"})
public class GetTypeController extends HttpServlet {
    private static final String ERROR = "category.jsp";
    private static final String SUCCESS = "filter-book.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            
            PhoneDAO dao = new PhoneDAO();
            List<PhoneDTO> productList = dao.getPhoneWithType(ID);
            List<Type> typeList = dao.getType();

            
            if (!productList.isEmpty()) {
                request.setAttribute("PHONE_LIST", productList);
                request.setAttribute("TYPE_LIST", typeList);
                url = SUCCESS;
            }
        } 
        catch (Exception e) {
            log("Error at GetTypeController: " + e.toString());
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
