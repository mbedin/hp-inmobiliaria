$(document).ready(function() {

	$("#btnCambiar").bind("click", function(){
		document.forms["frmMain"].action = "cambiarPassword.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnReset").bind("click", function(){
		document.forms["frmMain"].action = "resetearPassword.action";
		document.forms["frmMain"].submit();
	});
	
	
});