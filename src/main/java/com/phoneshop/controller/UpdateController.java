package com.phoneshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import com.phoneshop.phones.PhoneDAO;
import com.phoneshop.phones.PhoneDTO;
import com.phoneshop.shopping.Cart;
import com.phoneshop.shopping.LineItem;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR = "/404.html";
	private static final String SUCCESS = "/cart.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/cart.jsp";
		try {
			String action = request.getParameter("action");
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("CART");
			PhoneDAO dao = new PhoneDAO();
			List<PhoneDTO> productList = dao.getAllPhone();
			if (!productList.isEmpty()) {
				request.setAttribute("ACTIVE_PRODUCT_LIST", productList);
			}

			if (action.equalsIgnoreCase("update")) {
				if (cart != null) {
					List<LineItem> lineItemList = new ArrayList(cart.getLineItems());
					String[] quantity = request.getParameterValues("quantity");
					for (int i = 0; i < lineItemList.size(); i++) {
							lineItemList.get(i).setQuantity(Integer.parseInt(quantity[i]));
							lineItemList.get(i).calculateSubPrice();
					}
					Set<LineItem> lineItemSet = new HashSet<LineItem>(lineItemList);
					cart = new Cart(lineItemSet);
					session.setAttribute("CART", cart);
				}
			}
		} catch (Exception e) {

		} finally {
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}

	}

}
