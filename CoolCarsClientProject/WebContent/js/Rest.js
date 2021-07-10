$(document).ready(function(){
	
	$("#DeleteBtn").click(function() {
		var pid = $("#pid").val();
		if (pid != "") {
			$.ajax({
				method: "DELETE",
				url: "RestServlet/" + pid,
				error: ajaxDeleteReturnError,
				success: ajaxDeleteReturnSuccess
			})
			function ajaxDeleteReturnSuccess(result, status, xhr) {
				clearFields();
				$("#pid").attr("placeholder", "Person yeeted");
			}
			function ajaxDeleteReturnError(result, status, xhr) {
				console.log("Ajax-delete: " + status);
			}
		}
	})
	
	$("#FindBtn").click(function() {
		var pid = $("#pid").val();
		if (pid != "") {
			$.ajax({
				method: "GET",
				url: "RestServlet/" + pid,
				error: ajaxFindReturnError,
				success: ajaxFindReturnSuccess
			})
			function ajaxFindReturnSuccess(result, status, xhr) {
				ParseJsonFilePerson(result);
			}
			function ajaxFindReturnError(result, status, xhr) {
				console.log("Ajax-delete: " + status);
			}
		}
	})
	
	$("#AddBtn").click(function() {
		var strPid = $("#pid").val();
		var strName = $("#name").val();
		var strEmail = $("#email").val();
		var strPassword = $("#password").val();
		
		var obj = { pid: strPid, name: strName, email: strEmail, password: strPassword};
		var jsonString = JSON.stringify(obj);
		if (pid != "") {
			$.ajax({
				method: "POST",
				url: "RestServlet/",
				data: jsonString,
				dataType: "json",
				error: ajaxFindReturnError,
				success: ajaxFindReturnSuccess
			})
			function ajaxFindReturnSuccess(result, status, xhr) {
				clearFields();
				$("#pid").attr("placeholder", "Person added");
			}
			function ajaxFindReturnError(result, status, xhr) {
				console.log("Ajax-delete: " + status);
			}
		}
	})
	
	$("#UpdateBtn").click(function() {
		var strPid = $("#pid").val();
		var strName = $("#name").val();
		var strEmail = $("#email").val();
		var strPassword = $("#password").val();
		
		var obj = { pid: strPid, name: strName, email: strEmail, password: strPassword};
		var jsonString = JSON.stringify(obj);
		if (pid != "") {
			$.ajax({
				method: "PUT",
				url: "RestServlet/" + strPid,
				data: jsonString,
				dataType: "json",
				error: ajaxFindReturnError,
				success: ajaxFindReturnSuccess
			})
			function ajaxFindReturnSuccess(result, status, xhr) {
				clearFields();
				$("#pid").attr("placeholder", "Person updated");
			}
			function ajaxFindReturnError(result, status, xhr) {
				console.log("Ajax-delete: " + status);
			}
		}
	})
	
});

function ParseJsonFilePerson(result) {
	console.log(result);
	$("#pid").val(result[0].pid);
	$("#name").val(result[0].name);
	$("#email").val(result[0].email);
	$("#password").val(result[0].password);
}

function clearFields() {
	$("#pid").val("");
	$("#name").val("");
	$("#email").val("");
	$("#password").val("");
}