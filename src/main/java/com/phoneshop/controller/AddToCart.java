package com.phoneshop.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phoneshop.phonecase.PhonecaseDAO;
import com.phoneshop.phonecase.PhonecaseDTO;
import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.PhoneDTO;
import com.phoneshop.shopping.Cart;
import com.phoneshop.shopping.LineItem;

/**
 * Servlet implementation class AddToCart2
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ERROR = "/404.html";
    private static final String SUCCESS = "/cart.jsp";
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        String url = "/cart.jsp";
        try {
            String ID = request.getParameter("ID");
            PhoneDAO dao = new PhoneDAO();
            PhoneDTO phone = dao.getProductForCart(ID);
            List<PhoneDTO> productList = dao.getAllPhone();
            if (!productList.isEmpty()) {             
                request.setAttribute("ACTIVE_PRODUCT_LIST", productList);
                }
            
            
            if (!ID.equals("0")) {
            	int quantity = 1;
                LineItem lineItem = new LineItem(phone, quantity);
                
                HttpSession session = request.getSession();
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart == null) {
                	cart = new Cart();
                }
      
                cart.addItem(lineItem);
                
                PhonecaseDAO pcdao = new PhonecaseDAO();
                List<PhonecaseDTO> phonecaseList = pcdao.getAllPhonecase(ID);
                for (PhonecaseDTO phonecaseDTO: phonecaseList){
                    System.out.println(phonecaseDTO.getImage());
                }
                
                request.setAttribute("PHONECASE_ACTIVE_PRODUCT_LIST", phonecaseList);
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

}
