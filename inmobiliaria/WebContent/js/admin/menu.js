$(document).ready(function() {

	$("#btnTarjetasNuevas").bind("click", function() {
		document.forms["frmMain"].action = "tarjetasNuevas.action";
		document.forms["frmMain"].submit();
	});

	$("#btnTarjetasProductor").bind("click", function(){
		document.forms["frmMain"].action = "tarjetasProductor.action";
		document.forms["frmMain"].submit();
	});

	$("#btnSinTarjetas").bind("click", function(){
		document.forms["frmMain"].action = "sinTarjetas.action";
		document.forms["frmMain"].submit();
	});

	$("#btnPromociones").bind("click", function(){
		document.forms["frmMain"].action = "promociones.action";
		document.forms["frmMain"].submit();
	});

	$("#btnPreguntas").bind("click", function(){
		document.forms["frmMain"].action = "preguntas.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnPartidos").bind("click", function(){
		document.forms["frmMain"].action = "partidos.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnPosiciones").bind("click", function(){
		document.forms["frmMain"].action = "gruposPrimeraFase.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnClienteAceptoBases").bind("click", function(){
		document.forms["frmMain"].action = "clientesAceptoBases.action";
		document.forms["frmMain"].submit();
	});

	$("#btnTarjetasClientes").bind("click", function(){
		document.forms["frmMain"].action = "reporteTarjetasClientes.action";
		document.forms["frmMain"].submit();
	});

	$("#btnPuntosTrivia").bind("click", function(){
		document.forms["frmMain"].action = "reportePuntosTriviaClientes.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnListadoGeneral").bind("click", function(){
		document.forms["frmMain"].action = "reporteGeneralClientes.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnTarjetasPorPuntos").bind("click", function(){
		document.forms["frmMain"].action = "reporteTarjetasPorPuntos.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnListadoPuntosClientes").bind("click", function(){
		document.forms["frmMain"].action = "reportePuntosClientes.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnListadoPuntosFinales").bind("click", function(){
		document.forms["frmMain"].action = "reportePuntosFinales.action";
		document.forms["frmMain"].submit();
	});

	$("#btnPlayOff").bind("click", function(){
		document.location.href="tarjetasNuevasOctavos.action";
	});
	
	$("#btnPlayOffCuartos").bind("click", function(){
		document.location.href="tarjetasNuevasCuartos.action";
	});
	
	$("#btnPlayOffSemi").bind("click", function(){
		document.location.href="tarjetasNuevasSemi.action";
	});
	
	$("#btnPlayOffFinal").bind("click", function(){
		document.location.href="tarjetasNuevasFinal.action";
	});
	
	$("#btnCargaFinal").bind("click", function(){
		document.location.href="cargaFinal.action";
	});
	
	$("#btnAnulacion").bind("click", function(){
		document.location.href="anulaTarjeta.action";
	});
	
});
