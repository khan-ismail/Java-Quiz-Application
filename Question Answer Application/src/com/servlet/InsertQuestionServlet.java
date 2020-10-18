package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertQuestionServlet")
public class InsertQuestionServlet extends HttpServlet {

	PrintWriter out = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head>");
		out.println("<link href='Stylesheet/add-new-question-style-sheet.css' rel='stylesheet' type='text/css' />");
		out.println("</head><body>");
		out.println("<h1 id='heading'>Quiz Application</h1> <a "
				+ "style='	border-radius: 5px; background-color: green; box-shadow: 0px 0px 4px #000; margin-left: 20px; padding: 10px; color: #fff; text-decoration: none;'"
				+ "class='back-link' href='Home.jsp'>Back</a>");
		
//		out.println("<a href='Home.jsp'>Home</a>");
		
		out.println("<div class='main-div' style='position:relative; top:-68px;'>");
		out.println("<div class='main-div-heading'>Add New Question");
			
		out.println("</div>");
		out.println("<div class='div-card'>");
		
		out.println("<div class='card1-div card' >");
		out.println("<form action='InsertQuestionServlet' onsubmit='return ValidateForm()'>");
		out.println("<label style='font-size:18px;font-family:arial;'>Type Your Question Here:</label><br>");
		out.println("<textarea class='form-textarea' required rows='5' cols='35' name='txtQuestion' placeholder='Example: Who the first president of india? '></textarea><br><br>");

		out.println("<input type='text'class='options' required name='txtOption1' placeholder='Enter Option 1' autocomplete='off' /><br><br>");

		out.println("<input type='text' class='options' required name='txtOption2' placeholder='Enter Option 2' autocomplete='off' /><br/><br/>");

		out.println("<input type='text' class='options' required name='txtOption3' placeholder='Enter Option 3' autocomplete='off' /><br/><br/>");

		out.println("<input type='text' class='options' required name='txtOption4' placeholder='Enter Option 4' autocomplete='off' /><br/><br/>");
		out.println("<label style='font-size:18px;font-family:arial;'>Answer:</label><br>");
		out.println("<input type='text' class='options' required name='txtAnswer' placeholder='Enter your answer' autocomplete='off' /><br/><br/>");
		
		out.println("<div class='btn-div' >");
		out.println("<input type='submit' class='submitBtn' value='Add Question'/>");
		out.println("</div>");
		
		out.println("</form>");
		out.println("</div>");
	
		out.println("<div class='card2-div card' >");
		out.println("<img src='images/ic_show_student_details.png' class='add-question-img' />");
		out.println("</div>");
	
		out.println("</div>");
		out.println("<script src='JavaScript/jquery.js'></script>");
		out.println("<script src='JavaScript/InsertJavaScript.js'></script>");
		out.println("</body>");
		
		String question = request.getParameter("txtQuestion");
		String option1 = request.getParameter("txtOption1");
		String option2 = request.getParameter("txtOption2");
		String option3 = request.getParameter("txtOption3");
		String option4 = request.getParameter("txtOption4");
		String answer = request.getParameter("txtAnswer");
		
		if(question.trim().isEmpty()) {
			out.println("<label style='color:red;'>Question field is required</label>");
		}
		else if(option1.trim().isEmpty() || option2.trim().isEmpty() || option3.trim().isEmpty() || option1.trim().isEmpty()) {
			out.println("<label style='color:red;'>Please Enter Option</label>");
		}
		else if(question!=null && option1!=null && option2!=null && option3!=null && option4!=null && answer!=null) {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					String sql = "INSERT INTO quiz (question,option1,option2,option3,option4,answer) "
							+ "VALUES (?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, question);
					pstmt.setString(2, option1);
					pstmt.setString(3, option2);
					pstmt.setString(4, option3);
					pstmt.setString(5, option4);
					pstmt.setString(6, answer);
					pstmt.executeUpdate();
					RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
					rd.forward(request, response);
				}
				catch(Exception ex) {
					out.println(ex);
				}
		}
		
		out.println("</html>");
	}
}
