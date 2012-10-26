$(document).ready(function() {

	$("#btnGenerar").bind("click", function(){
		document.forms["frmMain"].action = "generarTarjetas.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnGenerar8").bind("click", function(){
		document.forms["frmMain"].action = "generarTarjetasOctavos.action";
		document.forms["frmMain"].submit();
	});

	$("#btnGenerarSinTarjetas").bind("click", function(){
		document.forms["frmMain"].action = "generarSinTarjetas.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnGenerar4").bind("click", function(){
		document.forms["frmMain"].action = "generarTarjetasCuartos.action";
		document.forms["frmMain"].submit();
	});

	$("#btnGenerar2").bind("click", function(){
		document.forms["frmMain"].action = "generarTarjetasSemi.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnGenerarFinal").bind("click", function(){
		document.forms["frmMain"].action = "generarTarjetasFinal.action";
		document.forms["frmMain"].submit();
	});

});
