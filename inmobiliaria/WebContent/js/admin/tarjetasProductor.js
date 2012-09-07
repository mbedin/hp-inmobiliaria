$(document).ready(function() {

	$("#btnGenerar").bind("click", function(){
		document.forms["frmMain"].action = "generarTarjetasProductor.action";
		document.forms["frmMain"].submit();
	});
	
});
