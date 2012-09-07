$(document).ready(function() {

	$("#lnkAnterior").bind("click", function(){
		($("#paginador_accion")).val("anterior");
		document.forms["frmMain"].action = "tarjetasJugadas.action";
		document.forms["frmMain"].submit();
	});

	$("#lnkSiguiente").bind("click", function(){
		($("#paginador_accion")).val("siguiente");
		document.forms["frmMain"].action = "tarjetasJugadas.action";
		document.forms["frmMain"].submit();
	});

});

	function cargarTarjeta(idTarjeta) {
		($("#tarjeta_id")).val(idTarjeta);
		document.forms["frmMain"].action = "tarjetaJugada.action";
		document.forms["frmMain"].submit();
	
	}
	
	function cargarTarjeta8(idTarjeta) {
		($("#tarjeta_id")).val(idTarjeta);
		document.forms["frmMain"].action = "tarjetaJugada8.action";
		document.forms["frmMain"].submit();
	
	}
