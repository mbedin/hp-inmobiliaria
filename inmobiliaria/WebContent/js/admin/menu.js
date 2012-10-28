$(document).ready(function() {

	$("#btnPropiedades").bind("click", function() {
		document.forms["frmMain"].action = "propiedades.action";
		document.forms["frmMain"].submit();
	});

});
