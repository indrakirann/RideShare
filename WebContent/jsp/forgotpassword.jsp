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
.forgotpassword, .login {
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
  height: 50%;
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
	  $("#forgotpassword").click(function(){
	    var forgotpassword = {email : $("#email").val()};
	    callback = function(data){
	      console.log(data);
	      if(data.emailError){
	        $(".usererror").show();	        	 
	        $(".usererror").text("Email does not exist. Please try again.");	
	        $("#email").css("outline", "2px solid red");	
	    } else{
	    	$(".usererror").hide();
       	    $("#email").removeClass("border-color-red")
       	 	window.location.replace("http://localhost:8080/RideShare/updatepassword");

	    };
	    }
	    post("/RideShare/forgotpassword", forgotpassword , callback);
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
<title>Forgot Password</title>
</head>
<body>

<div class="container">

  <h1 align = "center">Forgot Password</h1>
  <p align = "center"><b>Please fill out the form below to recover your account.</p>

  <hr><br>
<p class="usererror"></p>
 <input type="text" id = "email" placeholder="Email*" autofocus="autofocus" name="email">


<form action = "http://localhost:8080/RideShare/login">
  <button id="login" class = "login"> Back to Login </button>
  </form>

<button id="forgotpassword" class = "forgotpassword"> Submit </button>
</div>
</body>

</html>