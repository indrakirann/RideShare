  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body{
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
.card {
  background-color:white;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 500px;
  text-align: center;
  align: center;
  font-family: arial;
  margin: 0% auto 0% auto; /* 2% from the top, 2% from the bottom and centered */
  margin-top: 200px;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

.logo {
  border-radius: 50%;
}

button:hover, a:hover {
  opacity: 0.7;
}
.logo, .output{
  position: absolute;
}
</style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script type="text/javascript" src="./js/profile.js"></script>
<title>Dash Board</title>
</head>
<body>
<body>

<div class = "container">
<div class="card">


<p><input type="file"  accept="image/*" name="image" id="file"  onchange="loadFile(event)" style="display: none;"></p>
<p><label for="file" style="cursor: pointer;">Upload Image</label></p>
<div class = "overlap">
<img src="http://localhost:8080/RideShare/images/profileCircle.png" id = "logo" alt="Avatar" style="width:200px">
<p><img id="output" width="200" /></p>
</div>
<script>
var loadFile = function(event) {
	var image = document.getElementById('output');
	image.src = URL.createObjectURL(event.target.files[0]);
};
</script>

  
  <h1 >Mahek Maheshwari</h1>
  <p class="title" contenteditable = "true">Software Engineer | Film Enthusiast</p><br>
  <p>University of California, Berkeley</p>
  <p>Electrical Engineering and Computer Science</p>
  <br>
  <div style="margin: 24px 0;">
    <a href="#"><i class="fa fa-dribbble"></i></a> 
    <a href="#"><i class="fa fa-twitter"></i></a>  
    <a href="#"><i class="fa fa-linkedin"></i></a>  
    <a href="#"><i class="fa fa-facebook"></i></a> 
  </div>
  <p><button>Chat</button></p>
</div>
</div>

</body>
</body>
</html>