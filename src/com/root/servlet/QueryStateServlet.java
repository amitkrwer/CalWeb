package com.root.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.cal.SQLDataRetrival;

@WebServlet("/QueryStateServlet")
public class QueryStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryStateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String userName = request.getParameter("pincode_input");
		String res = "";
		SQLDataRetrival sql = new SQLDataRetrival();
		try {
			res = sql.queryForState(userName);
		} catch (Exception e) {

		}
		response.getWriter().append(res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			// TODO Auto-generated method stub
		doGet(request, response);
	}

}
