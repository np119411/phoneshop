package com.phoneshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.PhoneDTO;
import com.phoneshop.shopping.Cart;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR = "/404.html";
    private static final String SUCCESS = "/checkout.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String url = "/checkout.jsp";
        
        try {
        	HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            
            
            PhoneDAO dao = new PhoneDAO();
            List<PhoneDTO> productList = dao.getAllPhone();
            
            session.setAttribute("CART", cart);
            if (!productList.isEmpty()) {             
                request.setAttribute("ACTIVE_PRODUCT_LIST", productList);
                }
            url = SUCCESS;
		} 
        catch (Exception e) {
        	
        }
        finally {
        	request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
