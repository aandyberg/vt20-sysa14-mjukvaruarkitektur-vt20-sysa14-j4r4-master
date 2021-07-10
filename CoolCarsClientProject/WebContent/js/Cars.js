$(document).ready(function(){
	$.ajax({
		method: "GET",
		url: "CCServlet",
		data: { operation : "ajax_cars"},
		success: ajaxCarsSuccess
	})
	
});

function ajaxCarsSuccess(result, status, xhr) {
	console.log(result);
	result = $.parseJSON(result);
	console.log(result);
	var resultString = "";
	$.each(result, function(key, value) {
		resultString += "<tr>";
		resultString += "<td class=\"carTableTd\">" + value.brand + "</td>";
		resultString += "<td class=\"carTableTd\">" + value.licenseNbr + "</td>";
		resultString += "<td class=\"carTableTd\">" + value.price + " kr/day</td>";
		resultString += "<td class=\"carTableTd\"><form action=\"CCServlet\" id=\"formRent\" method=\"post\"><input type=\"hidden\" name=\"licenseNbr\" value=" + value.licenseNbr + "><input type=\"submit\" onclick=\"return confirm('Are you sure you want to rent this car?')\" name=\"operation\" value=\"Rent\"></form></td>";
		resultString += "</tr>";
	});
	$("#tbody").append(resultString);
}
