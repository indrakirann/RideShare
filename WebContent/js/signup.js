$(document).ready(function(){
  console.log("doc ready");
  $("#signup").click(function(){
    var login = {username : $("#username").val() , passcode : $("#passcode").val()};
    callback = function(data){
      console.log(data);
    };
    post("/userDataEval", login , callback);
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