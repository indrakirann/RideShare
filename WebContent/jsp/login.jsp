<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 10px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: blue;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
.login {
  padding: 14px 20px;
  background-color: #f44336;
}
/* Float cancel and signup buttons and add an equal width */
.signup, .login {
  float: left;
  width: 50%;
}
button:hover {
  opacity:1;
}
/* Style the horizontal ruler */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 10px;
}
/* Add padding to container elements */
.container {
  padding: 40px;
}
.container {
  background-color: #fefefe;
  margin: 7% auto 5% auto; /* 2% from the top, 2% from the bottom and centered */
  border: 1px solid #888;
  width: 40%;
  height: 70%;
}
body {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: #474e5d;
  padding-top: 50px;
}
.usererror, .passerror, .fielderror{ 
  color:red;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script type="text/javascript" src="./js/login.js"></script>
  <script>
$(document).ready(function(){
	  console.log("doc ready");
	  $("#login").click(function(){
		if((document.getElementById("email").value =="") && (document.getElementById("password").value =="")){
			$(".fielderror").show();	        	 
       		$(".fielderror").text("Please fill in all the required fields.");	
       		$("#email").css("outline", "2px solid red");
       		$("#password").css("outline", "2px solid red");
		} else if(document.getElementById("email").value ==""){
			$(".fielderror").show();	        	 
       		$(".fielderror").text("Please fill in all the required fields.");
       		$("#email").css("outline", "2px solid red");
		} else if(document.getElementById("password").value ==""){
			$(".fielderror").show();	        	 
       		$(".fielderror").text("Please fill in all the required fields.");
       		$("#password").css("outline", "2px solid red");
		}else if(!(document.getElementById("email").value.includes("@"))){
			$(".usererror").show();	        	 
       		$(".usererror").text("Please enter a vaild email.");
       		$("#email").css("outline", "2px solid red");
		}else{
		    var login = {Email : $("#email").val() , Password : $("#password").val()};
		    callback = function(data){
		    	console.log(data);
		        if(data.usererror){
		        	 $(".passerror").hide();
		        	 $(".usererror").show();	        	 
		        	 $(".usererror").text("Incorrect email. Please try again.");	
		        	 $("#email").css("outline", "2px solid red");	
		        	 
		        	 
		        	 
		        }else if (data.passerror){
		        	 $(".usererror").hide();
		        	 $(".passerror").show();	        	 
		        	 $(".passerror").text("Incorrect password. Please try again.");	
		        	 $("#password").css("outline", "2px solid red");	
		        	 
		        } else{
		        	 $(".usererror").hide();
		        	 $(".passerror").hide();
		        	 $("#email").removeClass("border-color-red")
		        }
		    };
		    post("/RideShare/login", login , callback);
		}
	    
	  });
	});
	function post(url , data , callback){
	  $.ajax({
	    type: "POST",
	    url: url,
	    data: data,
	    success: callback
	  });
	}
</script>
<title>Log In</title>
</head>
<body>

<div class="container">

  <h1 align = "center">Log In</h1>
  <p align = "center"><b>New to Ride Share? </b><a href="http://localhost:8080/RideShare/signup"><STYLE>A {text-decoration: none;} </STYLE>Sign up!</a></p>

  <hr>
   <p class="fielderror"></p>

<label for="email"><b>Email</b></label>
 <div class = "userborder">
 <input type="text" id = "email" placeholder="Email" name="email" required></div>
<p class="usererror"></p>
<label for="password"><b>Password</b></label>
 <div class = "passborder">
 <input type="password" id = "password" placeholder="Password" name="password" required></div>
<p class="passerror"></p>
   <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
   </label>


<form action = "http://localhost:8080/RideShare/signup">
  <button id="signup" class = "signup"> Sign Up </button>
  </form>
    <button id="login" class = "login"> Log In </button>
<!--  <form action = "http://localhost:8080/RideShare/profile">
  </form> -->
</div>
</body>

</html>