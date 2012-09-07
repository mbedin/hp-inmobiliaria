$(document).ready(function() {

	$("#btnNueva").bind("click", function(){
		document.forms["frmMain"].action = "promocion.action";
		document.forms["frmMain"].submit();
	});

	$("#btnGrabar").bind("click", function(){
		document.forms["frmMain"].action = "grabarPromocion.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnCancelar").bind("click", function(){
		document.forms["frmMain"].action = "promociones.action";
		document.forms["frmMain"].submit();
	});

	
});


function modificarPromocion(idPromocion) {
	($("#promocion_id")).val(idPromocion);
	document.forms["frmMain"].action = "promocion.action";
	document.forms["frmMain"].submit();
}

function eliminarPromocion(idPromocion) {
	($("#promocion_id")).val(idPromocion);
	document.forms["frmMain"].action = "eliminarPromocion.action";
	document.forms["frmMain"].submit();
}
