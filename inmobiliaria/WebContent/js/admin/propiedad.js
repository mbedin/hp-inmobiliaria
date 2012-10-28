$(document).ready(function() {

	$("#btnCancelar").bind("click", function() {
		document.forms["frmMain"].action = "propiedades.action";
		document.forms["frmMain"].submit();
	});

	$("#btnVolver").bind("click", function() {
		document.forms["frmMain"].action = "menuAdmin.action";
		document.forms["frmMain"].submit();
	});

	$("#lnkAnterior").bind("click", function() {
		($("#paginador_accion")).val("anterior");
		document.forms["frmMain"].action = "propiedades.action";
		document.forms["frmMain"].submit();
	});

	$("#lnkSiguiente").bind("click", function() {
		($("#paginador_accion")).val("siguiente");
		document.forms["frmMain"].action = "propiedades.action";
		document.forms["frmMain"].submit();
	});

	$("#btnNuevo").bind("click", function() {
		document.forms["frmMain"].action = "cargaPropiedad.action";
		document.forms["frmMain"].submit();
	});

	$("#btnGrabapropiedad").bind("click", function() {
		document.forms["frmMain"].action = "guardaPropiedad.action";
		document.forms["frmMain"].submit();
	});

	$("#propiedadAdapter_fechaAlta").datepicker({
		dateFormat : 'dd/mm/yy',
		showOn : 'both',
		buttonImage : 'img/datePicker/calendar.gif',
		buttonImageOnly : true
	});

});

function cargaResultado(idPartido) {
	($("#partidoAdapter_partido_id")).val(idPartido);
	document.forms["frmMain"].action = "cargaResultado.action";
	document.forms["frmMain"].submit();

}

function listaTarjetasConPremioEnPartido(idPartido) {
	($("#partidoAdapter_partido_id")).val(idPartido);
	document.forms["frmMain"].action = "tarjetasConPremio.action";
	document.forms["frmMain"].submit();

}
