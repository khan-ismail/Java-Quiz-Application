<!DOCTYPE html>
<html>
	<head>
		<title>New Registration</title>
		<link href="Stylesheet/new-user-stylesheet.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<h1 id="heading">Quiz Application</h1>
	<a style='border-radius: 5px; background-color: green; box-shadow: 0px 0px 4px #000; margin-left: 20px; 
	padding: 10px; color: #fff; text-decoration: none;' class='back-link' href='Home.jsp'>Back</a>
		<div class="main-div">
			<div class="main-div-heading">Login | Register</div>
			
			<div class="main-div-body">
			
				<div class="login-div">
					<div class="login-icon">
						<img src="images/ic_login_page.png" class="login-icon-img"/>
					</div>
					<div class="login-form">
						<form action="">
							<label class="label">Username:</label><br>
							<input type="text" class="input" placeholder="Username" /><br><br>
							
							<label class="label">Password:</label><br>
							<input type="password" class="input" placeholder="********" /><br><br>
							
							<div class="submit-btn-div">
								<input type="Submit" value="Login" class="btn-submit" />
							</div>
							<p class="forget-password-login">Forget Password?</p>
							<p class="inform-text">Most logins today are protected by a password. If an attacker can get your
							 password, he can access your account and do anything you could do with that account.</p>
						</form>
					</div>	
				</div>
				
				<div class="register-div">
					<div class="register-icon">
						<img src="images/register-icon.png" class="register-icon-img" />
					</div>
					<div class="register-form">
						<form action="RegisterServlet">
							<label class="label" id="lblFirstName">First Name</label>
							<input type="text" id="txtFirstName" name="txtFirstName" autocomplete="off" class="input" placeholder="First Name" /><br><br>
							
							<label class="label" id="lblLastName">Last Name</label>
							<input type="text" id="txtLastName" name="txtLastName" autocomplete="off" class="input" placeholder="Last Name" /><br><br>
							
							<label class="label" id="lblUserName">Username:</label><br>
							<input type="text" id="txtUserName" name="txtUserName" autocomplete="off" class="input" placeholder="Username" /><br><br>
							
							<label class="label" id="lblPassword">Password:</label><br>
							<input type="password" id="txtPassword" name="txtPassword" class="input" placeholder="********" /><br><br>
							
							<div class="submit-btn-div">
								<input type="Submit" id="btnRegister" value="Register" class="btn-register" />
							</div>
						</form>
					</div>
				</div>
			</div>
			
		</div>
		
		<script src="JavaScript/jquery.js"></script>
		<script src="JavaScript/RegisterForm_validation.js"></script>
	</body>
</html>