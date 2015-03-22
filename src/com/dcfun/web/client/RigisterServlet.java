package com.dcfun.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcfun.domain.User;
import com.dcfun.service.impl.BusinessServiceImpl;
import com.dcfun.utils.WebUtils;

public class RigisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setAddress(address);
		user.setEmail(email);
		user.setId(WebUtils.makeID());
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		service.registerUser(user);
		request.setAttribute("message", "×¢²á³É¹¦");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "×¢²áÊ§°Ü");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}