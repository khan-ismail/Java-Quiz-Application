package com.servlet;

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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	PrintWriter out = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><head>");
		out.println("<link href='Stylesheet/update-page-style-sheet.css' rel='stylesheet' type='text/css' />");
		out.println("</head><body>");
		out.println("<h1 id='heading'>Quiz Application</h1> <a class='back-link' href='QuestionAnswerServlet'>Back</a>");
		
		out.println("<div class='main-div' >");
		
		out.println("<div class='main-div-heading'>Update Question");
		
		out.println("</div>");
	
		out.println("<div class='div-card'>");
		
		out.println("<div class='card1-div card' >");
		out.println("<form action='UpdateServlet'>");
		
//		out.println("Question No:");
		out.println("<input type='hidden' name='questionNo' value='"+request.getParameter("questionNo")+"'/><br><br>");
		
		out.println("<label style='font-size:18px;font-family:arial;'>Update Your Question Here:</label><br>");
		out.println("<textarea class='form-textarea' required  rows='5' cols='35' name='question' placeholder='Update your question?'>"+request.getParameter("question")+"</textarea><br><br>");
		
		out.println("<input type='text'class='options' required  placeholder='Update Option 1'  name='opt1' value='"+request.getParameter("opt1")+"' /><br><br>");
		
		out.println("<input type='text' class='options' required  placeholder='Update Option 2'  name='opt2' value='"+request.getParameter("opt2")+"' /><br/><br/>");
		
		out.println("<input type='text' class='options' required  placeholder='Update Option 3'  name='opt3' value='"+request.getParameter("opt3")+"' /><br/><br/>");
		
		out.println("<input type='text' class='options' required  placeholder='Update Option 4' name='opt4' value='"+request.getParameter("opt4")+"' /><br/><br/>");
		
		out.println("Answer:<br>");
		out.println("<input type='text' class='options' required placeholder='Update Answer'  name='txtAnswer' /><br/><br/>");
		
		out.println("<input type='submit' value='Update'  class='submitBtn' />");
		
		out.println("</form>");
		out.println("</div>");
		
		out.println("<div class='card2-div card' >");
		
		out.println("<img src='images/ic_update_students.png' class='update-img' /></div>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		
		String questionNo = request.getParameter("questionNo");
		String question = request.getParameter("question");
		String opt1 = request.getParameter("opt1");
		String opt2 = request.getParameter("opt2");
		String opt3 = request.getParameter("opt3");
		String opt4 = request.getParameter("opt4");
		String answer = request.getParameter("txtAnswer");
		
		if(questionNo!=null && question!=null && opt1!=null && opt2!=null && opt3!=null && opt4!=null && answer !=null) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				String sql = "Update quiz set question=?, option1=?, option2=?, option3=?, option4=?, answer=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, question);
				pstmt.setString(2, opt1);
				pstmt.setString(3, opt2);
				pstmt.setString(4, opt3);
				pstmt.setString(5, opt4);
				pstmt.setString(6, answer);
				pstmt.setInt(7, Integer.parseInt(questionNo));
				
				pstmt.executeUpdate();
				RequestDispatcher rd = request.getRequestDispatcher("/QuestionAnswerServlet");
				rd.forward(request, response);
				
			}catch(Exception ex) {
				out.println(ex);
			}
		}
		
	}
}
