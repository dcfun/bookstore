package com.dcfun.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcfun.domain.Cart;
import com.dcfun.domain.CartItem;
import com.dcfun.domain.User;
import com.dcfun.service.impl.BusinessServiceImpl;

public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			User user = (User) request.getSession().getAttribute("user");
			if (user==null) {
				request.setAttribute("message", "�Բ������ȵ�¼");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;
			}
			
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			BusinessServiceImpl service = new BusinessServiceImpl();
			service.createOrder(cart, user);
			request.setAttribute("message", "�������ɳɹ���");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "��������ʧ��...");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}