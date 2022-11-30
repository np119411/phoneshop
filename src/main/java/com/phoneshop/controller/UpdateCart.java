
package com.phoneshop.controller;

import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.PhoneDTO;
import com.phoneshop.shopping.Cart;
import com.phoneshop.shopping.CartProduct;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "UpdateCart", urlPatterns = {"/UpdateCart"})
public class UpdateCart extends HttpServlet {
    private static final String ERROR = "/404.html";
    private static final String SUCCESS = "/cart.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String ID = request.getParameter("ID");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            PhoneDAO dao = new PhoneDAO();
            PhoneDTO productDTO = dao.getProductForCart(ID);
            
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            CartProduct product = new CartProduct();
            
            for (CartProduct item : cart.getCart2().values()) {
                if (item.getID().equals(ID)) {
                    String productName = item.getName();
                    String productImage = item.getImage();
                    int price = item.getPrice();
                    
                    if (quantity <= productDTO.getQuantity()) {
                        product = new CartProduct(ID, productName, price, productImage, quantity);
                    }
                    else {
                        product = new CartProduct(ID, productName, price, productImage, productDTO.getQuantity());
                        session.setAttribute("ERROR_CART", "Quantity of product " + product.getName()+ " is still : " + productDTO.getQuantity());
                    }
                    break;
                }
            }
            
            if (cart != null) {
                cart.updateCart(ID, product);
                session.setAttribute("CART", cart);
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
