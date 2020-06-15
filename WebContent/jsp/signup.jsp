<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="signup.css" media="screen"/>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
input[type=password] {
  float: left;
  
  width: 50%;
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
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
/* Float cancel and signup buttons and add an equal width */

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
  background-color: #fefefe;
  margin: 0% auto 0% auto; /* 2% from the top, 2% from the bottom and centered */
  border: 1px solid #888;
  width: 40%;
  height: 100%;
  padding-top: 40px;
  padding-bottom: 80px;
  padding-left: 40px;
  padding-right: 40px;
}
body {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  /*height: 100%;  Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: #474e5d;
  padding-top: 45px;
  margin-bottom: 200px;
}
.fielderror{
    color: red;
}
.emailerror, .rpterror{
	color: red;
	margin-top: 0px;
	margin-bottom: 0px;
}
</style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script type="text/javascript" src="./js/signup.js"></script>
  <script>
$(document).ready(function(){
	  console.log("doc ready");
	  $("#signup").click(function(){
      $(".fielderror").hide();
      $("#fname").css("outline", "none");
      $("#lname").css("outline", "none");
      $("#email").css("outline", "none");
      $("#password").css("outline", "none");
      $("#rptpassword").css("outline", "none");
		    if(document.getElementById("fname").value ==""){
				$(".fielderror").show();
	       		$(".fielderror").text("Please fill in all the required fields.");
	       		$("#fname").css("outline", "2px solid red");
		    } if(document.getElementById("lname").value ==""){
				$(".fielderror").show();
	       		$(".fielderror").text("Please fill in all the required fields.");
	       		$("#lname").css("outline", "2px solid red");
			} if(document.getElementById("email").value ==""){
				$(".fielderror").show();
	       		$(".fielderror").text("Please fill in all the required fields.");
	       		$("#email").css("outline", "2px solid red");
			} if(document.getElementById("password").value ==""){
				$(".fielderror").show();
	       		$(".fielderror").text("Please fill in all the required fields.");
	       		$("#password").css("outline", "2px solid red");
			} if(document.getElementById("rptpassword").value ==""){
				$(".fielderror").show();
	       		$(".fielderror").text("Please fill in all the required fields.");
	       		$("#rptpassword").css("outline", "2px solid red");
			}else if(!(document.getElementById("email").value.includes("@"))){
				$(".fielderror").show();
	       		$(".fielderror").text("Please enter a vaild email.");
	       		$("#email").css("outline", "2px solid red");
			}else{
			    var signup = {fname : $("#fname").val() , lname : $("#lname").val(), email : $("#email").val(),
			    		password : $("#password").val(), rptpassword : $("#rptpassword").val()};
			    callback = function(data){
			    console.log(data);
			    console.log(data.error);
			    if(data.varError){
		       	 	$(".fielderror").show();
		       	 	$(".fielderror").text("Email is already in use. Please try again.");
		       	 	$("#email").css("outline", "2px solid red");

			    }else if (data.rptError){
		       	 	$(".fielderror").show();
		       	 	$(".fielderror").text("Passwords do not match. Please try again.");
		       	    $("#password").css("outline", "2px solid red");
		       	 	$("#rptpassword").css("outline", "2px solid red");
		       } else{
		       	 	$(".fielderror").hide();
		       	 	window.location.replace("http://localhost:8080/RideShare/login");

		        }
			    };
			    post("/RideShare/signup", signup , callback);
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
<title>Sign Up</title>
</head>
<body>
<div class="container">
  <h1 align = "center">Sign Up</h1>
  <p align = "center"><b> Already have an account?</b> <a href="http://localhost:8080/RideShare/login"><STYLE>A {text-decoration: none;} </STYLE>Login!</a></p>
  <hr>
  <p class = "fielderror"> </p>
  <input type="text" id = "fname" placeholder="First Name*" name="fname" autofocus="autofocus" >

  <input type="text" id = "lname" placeholder="Last Name*" name="lname">

  <input type="text" id = "email" placeholder="Email*" name="email">

  <input type="password" id = "password" placeholder="Enter Password*" name="password" required>
  <input type="password" id = "rptpassword" placeholder="Repeat Password*" name="rptpassword" required>
  <p class="rpterror"></p>

   <label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
   </label>

  <button id="signup" class = "signup"> Submit </button>

</div>
</body>

</html>
