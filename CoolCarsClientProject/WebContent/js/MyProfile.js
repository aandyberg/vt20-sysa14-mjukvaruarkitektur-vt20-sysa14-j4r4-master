$(document).ready(function(){
	var originalName = $("#textname").val();
	var originalEmail = $("#textemail").val();
	console.log(originalEmail);
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
	
	$("#userinformation").submit(function(){
		var name = $("#textname").val();
		if(name == ""){
			$("#textname").val(originalName);
			$("#textemail").val(originalEmail);
			return false;
		}
		var email = $("#textemail").val();
		if(!email.includes("@") || email == "") {
			$("#textname").val(originalName);
			$("#textemail").val(originalEmail);
			return false;
		}
	});
});