<!DOCTYPE html>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cach");
	response.setHeader("Expires", "0");
%>
<html>
	<head>
		<title>Home Page</title>
		<link href="Stylesheet/Home-Style-Sheet.css" rel="stylesheet" type="text/css" />
		<link href="Stylesheet/footer-stylesheet.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<h1 id="heading">Quiz Application</h1>
		<div class="main-div">
			<div class="main-div-heading">Home</div>
			
		
			<div class="div-card">
				<div class="card1-div card">
					<div class="card1-heading cheading">Let's Play</div>
					
					<div class="card1-body cbody">
						<a href="QuestionAnswerServlet">
							<img src="images/game_play.png" style="width: 135px; height: 140px;margin-left:-20px; margin-top: 15px;" />
						</a>
					</div>
				</div>
				
				<div class="card2-div card">
					<div class="card2-heading cheading">Add Question</div>
					
					<div class="card2-body cbody">
						<a href="InsertQuestionServlet" class="list2-link nlink">
							<img src="images/ic_save_class.png" style="width: 140px; margin-left:40px; margin-top:20px;" />
						</a>
					</div>
				</div>
				
				<div class="card3-div card">
					<div class="card3-heading cheading">New User</div>
					
					<div class="card3-body cbody">
						<a href="new-user-registration.jsp" class="list3-link nlink">
							<img src="images/ic_attendance_dashboard.png" style="width: 160px; margin-left: 10px;"/>
						</a>
					</div>
				</div>
			</div>
			
		</div>
		
		<!-- <div class="footer">
		
		</div> -->
		
	</body>
</html>