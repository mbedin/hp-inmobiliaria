$(document).ready(function() {

	$("#btnIngresar").bind("click", function(){
		document.forms["frmMain"].action = "loginIngresar.action";
		document.forms["frmMain"].submit();
	});

	$("#lnkCambioPassword").bind("click", function(){
		document.forms["frmMain"].action = "cambioPassword.action";
		document.forms["frmMain"].submit();
	});

	$("#lnkResetPassword").bind("click", function(){
		document.forms["frmMain"].action = "reseteoPassword.action";
		document.forms["frmMain"].submit();
	});

});