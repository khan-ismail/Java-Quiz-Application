$(document).ready(function(){
	
	var fname = true;
	var lname = true;
	var uname = true;
	var pass = true;
	
/*----------------------  First Name Validation is Here  ------------------------ */
	
	$('#txtFirstName').keyup(function(){
		checkFirstName();
	});
	
	function checkFirstName(){
		var firstname_val = $('#txtFirstName').val();
		
		if(firstname_val.length == ''){
			$('#txtFirstname').focus();
			$('#lblFirstName').html("*First Name");
			$('#lblFirstName').css("color","red");
			fname = false;	
		} else {
			$('#lblFirstName').html("First Name");
			$('#lblFirstName').css("color","#262626");
			fname = true;
		}
	}
	
/*----------------------  Last Name Validation is Here  ------------------------ */
	$('#txtLastName').keyup(function(){
		checkLastName();
	});
	
	
	function checkLastName(){
		var lastname_val = $('#txtLastName').val();
		
		if(lastname_val.length == ''){
			$('#txtFirstname').focus();
			$('#lblLastName').html("*Last Name");
			$('#lblLastName').css("color","red");
			lname = false;	
		} else {
			$('#lblLastName').html("Last Name");
			$('#lblLastName').css("color","#262626");
			lname = true;	
		}
	}
	
/*----------------------  User Name Validation is Here  ------------------------ */
	
	$('#txtUserName').keyup(function(){
		checkUserName();
	});
	
	function checkUserName(){
		var username_val = $('#txtUserName').val();
		
		if(username_val.length == ''){
			$('#txtUserName').focus();
			$('#lblUserName').html("*Username");
			$('#lblUserName').css("color","red");
			uname = false;	
		} else {
			$('#lblUserName').html("Username");
			$('#lblUserName').css("color","#262626");
			uname = true;
		}
	}

/*----------------------  Password Validation is Here  ------------------------ */
	
	$('#txtPassword').keyup(function(){
		checkPassword();
	});
	
	function checkPassword(){
		var password_val = $('#txtPassword').val();
		
		if(password_val.length == ''){
			$('#txtPassword').focus();
			$('#lblPassword').html("*Password");
			$('#lblPassword').css("color","red");
			pass = false;	
		} else {
			$('#lblPassword').html("Password");
			$('#lblPassword').css("color","#262626");
			pass = true;
		}
	}
	
	
	$('#btnRegister').click(function(){
		checkFirstName();
		checkLastName();
		checkUserName();
		checkPassword();
		
		if(fname == false){
			$('#txtFirstName').focus();
			return false;
		}
		else if(lname == false){
			$('#txtLastName').focus();
			return false;
		}
		else if(uname == false){
			$('#txtUserName').focus();
			return false;
		}
		else if(pass == false){
			$('#txtPassword').focus();
			return false;
		}
		else {
			return true;
		}
		
	});
});
