$(document).ready(function(){
$.ajax({
    method: "GET",
    url: "https://ipinfo.io/?token=ipinfo.io",
    error: ajaxReturn_Error,
    success: ajaxReturn_Success
})
//var userStatus = document.getElementById("userstatus").value;
//console.log(userStatus);

/*$("#mypage").click(function() {
	$.ajax({
		method: "GET",
		url: "CCServlet",
		data: { operation : "ajax_myProfile"},
		success: console.log("ajax körs")
	})
})*/
/*function loginCheck(result, status, xhr) {
	console.log("loginCheck");
	if (result == "user_true"){
		window.location.href = "MyProfile.jsp";
	}else {
		window.location.href = "Login.jsp";
	}
}*/
function ajaxReturn_Success(result, status, xhr) {
    ParseJsonFile(result);
}
function ajaxReturn_Error(result, status, xhr) {
    console.log("Ajax-api-stack: "+status);
}
}); //End ready function
function ParseJsonFile(result) {
	var location = result.loc;
    var lat = location.substring(0, location.indexOf(","));
    var long = location.substring(location.indexOf(",")+1, location.length);
    console.log(lat);
    console.log(long);
    var city = result.city;
    var ipNbr = result.ip
    $("#city").text(city);
    $("#ipNbr").text(ipNbr);
    $.ajax({
        method: "GET",
        url: "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+long+"&units=metric"+ "&APPID=b575c92c6df868fbe331bccd2a109bca",
        error: ajaxWeatherReturn_Error,
        success: ajaxWeatherReturn_Success
    })
    function ajaxWeatherReturn_Success(result, status, xhr) {
            var sunrise = result.sys.sunrise;
            var sunset = result.sys.sunset;
            var sunriseDate = new Date(sunrise*1000);
            var timeStrSunrise = sunriseDate.toLocaleTimeString();
            var sunsetDate = new Date(sunset*1000);
            var timeStrSunset = sunsetDate.toLocaleTimeString();
            $("#sunrise").text("Sunrise: "+timeStrSunrise);
            $("#sunset").text("Sunset: "+timeStrSunset);
            $("#weather").text(result.weather[0].main);
            $("#degree").text(Math.round(result.main.temp)+" \u2103");
        } //ajaxWeatherReturn_Success
        function ajaxWeatherReturn_Error(result, status, xhr) {
            alert("Error i OpenWeaterMap Ajax");
        }

}

