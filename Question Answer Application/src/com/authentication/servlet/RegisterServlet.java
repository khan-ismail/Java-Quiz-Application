package com.authentication.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	PrintWriter out = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		out = response.getWriter();
		response.setContentType("text/html");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cach");
		response.setHeader("Expires", "0");
		
		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		String userName = request.getParameter("txtUserName");
		String password = request.getParameter("txtPassword");
		
		HttpSession session = request.getSession(false);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			String sql = "INSERT INTO quizuserregister (firstName, lastName, UserName, password) values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, userName);
			pstmt.setString(4, password);
			
			pstmt.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("/new-user-registration.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception ex) {
			out.println(ex);
		}
	}

}
