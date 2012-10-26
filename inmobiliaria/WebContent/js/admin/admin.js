$(document).ready(function() {

	// Botones Menu Principal
	$("#btnTarjetasNuevas").bind("click", function(){
		document.forms["frmMain"].action = "tarjetasNuevas.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnVolver").bind("click", function(){
		document.forms["frmMain"].action = $("#hdnRetorno").val() + ".action";
		document.forms["frmMain"].submit();
	});


	$("#btnMenu").bind("click", function(){
		document.forms["frmMain"].action = "menuAdmin.action";
		document.forms["frmMain"].submit();
	});

});
