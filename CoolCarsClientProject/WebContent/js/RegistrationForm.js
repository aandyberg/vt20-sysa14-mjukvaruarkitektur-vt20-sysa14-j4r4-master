$(document).ready(function(){
	
	$("#textpid").on("input", function(){
	    var value = $("#textpid").val();
	    value = value.replace(/[\D]+/, '');
	    $("#textpid").val(value);
	});//Only digits input
	$("#textname").on("input", function(){
	    var value = $("#textname").val();
	    value = value.replace(/[\d]+/, '');
	    $("#textname").val(value);
	});//Only charachters input
	$("#textemail").on("input", function(){
	    var value = $("#textemail").val();
	    value = value.replace(/[^\S]/, '');
	    $("#textemail").val(value);
	});//No whitespaces
	
	$("#registration").submit(function(){
		var pid = $("#textpid").val();
		console.log("kommer hit");
		if(pid.length != 10) {
			$("#textpid").val("");
			$("#textpid").attr("placeholder", "10 digits please");
			return false
		}
		var email = $("#textemail").val();
		if(!email.includes("@")) {
			$("#textemail").val("");
			$("#textemail").attr("placeholder", "Insert a valid email");
			return false;
		}
	});
	
	
	
}); //End ready function

