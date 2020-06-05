$(document).ready(function(){
  console.log("doc ready");
  $("#login").click(function(){
    var login = {fname : $("#email").val() , lname : $("#password").val()};
    callback = function(data){
      console.log(data);
    };
    post("/RideShare/login", login , callback);
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