$(document).ready(function(){
  console.log("doc ready");
  $("#signup").click(function(){
    var signup = {fname : $("#fname").val() , lname : $("#lname").val(), email : $("#email").val(), password : $("#password").val()};
    callback = function(data){
      console.log(data);
    };
    post("/RideShare/signup", signup , callback);
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