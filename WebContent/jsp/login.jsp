<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script type="text/javascript" src="./js/login.js"></script>
<title>Log In</title>
</head>
<body>
<h4>Email : </h4> <input id="email"><br>
<h4>Password : </h4> <input id="password"><br><br>
<button id="login"> Log In </button>
<form action = "http://localhost:8080/RideShare/signup">
  <input type = "submit" value = "Sign Up">
  </form>
<form action = "http://localhost:8080/RideShare/signup">
  <input type = "submit" value = "Forgot Password?">
  </form>
</body>
</html>