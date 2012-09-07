$(document).ready(function() {

	// Botones Menu Principal
	$("#btnTarjetasPorJugar").bind("click", function(){
		document.forms["frmMain"].action = "tarjetasPorJugarInit.action";
		document.forms["frmMain"].submit();
		//document.location.href = "tarjetasPorJugar.action";
	});
	
	$("#btnTarjetasJugadas").bind("click", function(){
		document.forms["frmMain"].action = "tarjetasJugadasInit.action";
		document.forms["frmMain"].submit();
		//document.location.href = "tarjetasJugadas.action";
	});

	$("#btnTarjetasExtras").bind("click", function(){
		document.forms["frmMain"].action = "tarjetasExtras.action";
		document.forms["frmMain"].submit();
		//document.location.href = "tarjetasExtras.action";		
	});

	$("#btnPuntosBonus").bind("click", function(){
		document.forms["frmMain"].action = "puntosBonus.action";
		document.forms["frmMain"].submit();
		//document.location.href = "puntosBonus.action";
	});

	$("#btnPrincipal").bind("click", function(){
		document.forms["frmMain"].action = "principal.action";
		document.forms["frmMain"].submit();
		//document.location.href = "principal.action";
	});

	$("#btnVolver").bind("click", function(){
		document.forms["frmMain"].action = $("#hdnRetorno").val() + ".action";
		document.forms["frmMain"].submit();
		//document.location.href = $("#hdnRetorno").val() + ".action";
	});

	$("#lnkCambioPassword").bind("click", function(){
		document.forms["frmMain"].action = "cambioPassword.action";
		document.forms["frmMain"].submit();
		//document.location.href = "cambioPassword.action";
	});
	
	$("#btnComoJugar").bind("click", function(){
		document.forms["frmMain"].action = "comoJugar.action";
		document.forms["frmMain"].submit();
		//document.location.href = "comoJugar.action";
	});

});
