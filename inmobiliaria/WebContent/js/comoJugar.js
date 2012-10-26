$(document).ready(function() {

	$("#btnAceptoBases").bind("click", function(){
		document.forms["frmMain"].action = "aceptoBases.action";
		document.forms["frmMain"].submit();
	});
	
});
