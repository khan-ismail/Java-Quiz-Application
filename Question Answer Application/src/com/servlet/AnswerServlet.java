package com.servlet;

import java.io.IOException;
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

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {

	PrintWriter out = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head>");
		out.println("<link href='Stylesheet/answer-page-stylesheet.css' rel='stylesheet' type='text/css' />");
		out.println("</head><body>");
		out.println("<h1 id='heading'>Quiz Application</h1> <a href='QuestionAnswerServlet'></a>");
		
		out.println("<div class='main-div' style='position:relative; top:-68px;'>");
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * from quiz";
		out.println("<table border='1' class='answer-table' style='margin-top:18px;'>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			int score = 0;
			
			while(rs.next()) {
				String option = request.getParameter(Integer.toString(rs.getInt("id")));
				out.println("<tr style='text-align:left;padding:10px;' >");
				out.println("<th>"+rs.getInt("id")+") "+rs.getString("question")+" </th>");
				out.println("</tr>");
				
				String answer = rs.getString("answer");
				
				if(answer.equalsIgnoreCase(option)) {
					out.println("<tr style='background:rgba(92, 179, 92,0.3);'>");
					out.println("<td style='padding-left: 30px;padding-top: 30px;padding-bottom:30px;'><label class='answer-is-correct'>You select <b>[ "+option+" ]</b> is <b>correct</b> option:</label></td>");
					out.println("</tr>");
					score++;
				}
				else {
					out.println("<tr style='background:rgba(219, 71, 71,0.3);'>");
					out.println("<td style='padding-left: 30px;padding-top: 30px;padding-bottom:30px;'><label class='answer-is-wrong'>You select <b>[ "+option+" ]</b> is <b>wrong</b> option:</label><br>"
							+ " <p style='margin-top:10px;color:#363636;'>Correct Option is: <b>[ "+rs.getString("answer")+" ]</b></p></td>");
					out.println("</tr>");
				}
			}
			
			out.println("</table>");
			
			out.println("</div>");
			
			out.println("<label class='total-score'>Total Score is: "+score+"</label>");
			out.println("<a href='Home.jsp' class='back-link'>Back</a>");
			out.println("</body>");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
