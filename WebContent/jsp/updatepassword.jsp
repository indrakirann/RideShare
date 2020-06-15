<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
/* Full-width input fields */
input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 10px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
/* Add a background color when the inputs get focus */
input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
/* Set a style for all buttons */
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
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
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
  margin: 5% auto 5% auto; /* 2% from the top, 2% from the bottom and centered */
  border: 1px solid #888;
  width: 40%;
  height: 85%;
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script type="text/javascript" src="./js/changepassword.js"></script>
  <script>
  $(document).ready(function(){
	  console.log("doc ready");
	  $("#updatepassword").click(function(){
	    var updatepassword = {email : $("#email").val(), code : $("#code").val(), newpass : $("#newpass").val(), rptnewpass : $("#rptnewpass").val() };
	    callback = function(data){
	      console.log(data);
	    }
	    post("/RideShare/updatepassword", updatepassword , callback);
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
<title>Update Password</title>
</head>
<body>
<div class="container">
 <h1 align = "center">Update Password</h1>
  <p align = "center"><b>Please fill out the form below to update your password.</p>

  <hr><br>
  <label for="email"></label>
  <input type="text" id = "email" placeholder="Email*" name="email">
  <p class="emailerror"></p>
<label for="code"></label>
  <input type="text" id = "code" placeholder="Code*" name="code">
  <p class="emailerror"></p>
<label for="password"></label>
  <input type="password" id = "newpass" placeholder="New Password*" name="newpass">
  <p class="emailerror"></p>
  <label for="rptpassword"></label>
  <input type="password" id = "rptnewpass" placeholder="Repeat New Password*" name="rptnewpass" >
  <p class="emailerror"></p>
  <button id="updatepassword" class = "updatepassword"> Update Password </button>
</body>
</html>