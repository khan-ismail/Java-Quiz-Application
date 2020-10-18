package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	
	PrintWriter out = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		out = response.getWriter();
		response.setContentType("text/html");
		
		String questionNo = request.getParameter("questionNo");
	
		if(questionNo != null) {
		
			Connection con = null;
			Statement pstmt = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				String sql = "DELETE FROM quiz WHERE id = "+questionNo;
				pstmt = con.createStatement();
				pstmt.execute(sql);
				sql = "ALTER TABLE quiz AUTO_INCREMENT = "+questionNo;
				pstmt.execute(sql);
				RequestDispatcher rd = request.getRequestDispatcher("/QuestionAnswerServlet");
				rd.forward(request, response);
				
			}catch(Exception ex) {
				out.println(ex);
			}
		}
		else {
			out.println("<h1>Something Went wrong</h1>");
		}
	}
}
