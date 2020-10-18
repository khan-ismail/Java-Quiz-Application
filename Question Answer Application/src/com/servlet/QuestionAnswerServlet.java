package com.servlet;

import java.io.IOException;
import com.mysql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuestionAnswerServlet")
public class QuestionAnswerServlet extends HttpServlet{

	PrintWriter out = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head>");
		out.println("<link href='Stylesheet/question-page-style-sheet.css' rel='stylesheet' type='text/css' />");
		out.println("</head><body>");
		out.println("<h1 id='heading'>Quiz Application</h1> <a class='back-link' style='background:rgb(0, 132, 255);' href='Home.jsp'>Back</a>");
		out.println("<form action='AnswerServlet'>");
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM quiz";
		out.println("<table class='question-table' style='margin-top: -8px'>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int questionNo = rs.getInt("id");
				String question = rs.getString("question");
				String option1 = rs.getString("option1");
				String option2 = rs.getString("option2");
				String option3 = rs.getString("option3");
				String option4 = rs.getString("option4");
				out.println("<tr style='text-align:left;padding:10px;'>");	
				out.println("<th>"+questionNo+") "+question+"<a class='delete-link' href='DeleteServlet?questionNo="+questionNo+"' onclick='return myFunction()' >Delete</a>"
						+ "<a class='update-link' href='UpdateServlet?questionNo="+questionNo+"&question="+question+"&opt1="+option1+"&opt2="+option2+"&opt3="+option3+"&opt4="+option4+"'>Update</a></th>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td style='padding-top:10px; padding-left:20px;'><label><input type='radio' required name='"+questionNo+"' value='"+option1+"' />"+" "+option1+"</label></td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td style='padding-left:20px;'><label><input type='radio' name='"+questionNo+"' required value='"+option2+"' />"+" "+option2+"</label></td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td style='padding-left:20px;'><label><input type='radio'  name='"+questionNo+"' required value='"+option3+"' />"+" "+option3+"</label></td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td style='padding-bottom:20px; padding-left:20px;'><label><input type='radio' required  name='"+questionNo+"' value='"+option4+"' />"+" "+option4+"</label></td>");
				out.println("</tr>");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		out.println("<tr>");
		out.println("<td style='border:1px solid #ddd;padding:10px; text-align:center;padding-bottom-20px;'>"
				+ "<input class='check-btn' type='submit' value='Submit' /></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<script src='JavaScript/question-delete-javascript.js'></script>");
		out.println("</body></html");
		
	}
}
