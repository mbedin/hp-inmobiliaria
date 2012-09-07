$(document).ready(function() {

	$("#btnIngresar").bind("click", function(){
		document.forms["frmMain"].action = "loginIngresarAdmin.action";
		document.forms["frmMain"].submit();
	});
	
});