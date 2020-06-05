$(document).ready(function(){
  console.log("doc ready");
  $("#forgotpassword").click(function(){
    var login = {fname : $("#email").val()};
    callback = function(data){
      console.log(data);
    };
    post("/RideShare/forgotpassword", login , callback);
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