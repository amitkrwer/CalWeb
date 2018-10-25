package com.root.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.hibernate.HibernateMain;
import com.root.model.UserModel;

@WebServlet("/GetUserDataSevlet")
public class GetUserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetUserDataServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		String email = " ";
		String mobileNumber = " ";
		String pincode = " ";
		String areaName = " ";
		String stateName = " ";
		String name = " ";

		if (request.getParameter("name_input") != null) {
			name = request.getParameter("name_input");
		}
		if (request.getParameter("mobile_input") != null) {
			mobileNumber = request.getParameter("mobile_input");
		}
		if (request.getParameter("pincode_input") != null) {
			pincode = request.getParameter("pincode_input");
		}
		if (request.getParameter("select_tag_area") != null) {
			areaName = request.getParameter("select_tag_area");
		}
		if (request.getParameter("email_input") != null) {
			email = request.getParameter("email_input");
		}
		if (request.getParameter("select_tag_state") != null) {
			stateName = request.getParameter("select_tag_state");
		}
		HibernateMain hMain = new HibernateMain();
		String res = hMain.insertInDatabase(new UserModel(name, email, mobileNumber, pincode, areaName, stateName));

		response.getWriter().append(res);
		// request.getRequestDispatcher("/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
