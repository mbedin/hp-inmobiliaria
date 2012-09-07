$(document).ready(function() {
	
	$("#btnGrabar").bind("click", function(){
		document.forms["frmMain"].action = "grabarPosiciones.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnVolver").bind("click", function(){
		document.forms["frmMain"].action = "gruposPrimeraFase.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnCancelar").bind("click", function(){
		document.forms["frmMain"].action = "gruposPrimeraFase.action";
		document.forms["frmMain"].submit();
	});
	
	$("#tarjetasConPremioClasificacionExcel").bind("click", function(){
		document.forms["frmMain"].action = "tarjetasConPremioClasificacionExcel.action";
		document.forms["frmMain"].submit();
	});
		
});


function cargaPosicion(idGrupo) {
	($("#grupo_id")).val(idGrupo);
	document.forms["frmMain"].action = "cargaPosiciones.action";
	document.forms["frmMain"].submit();
}

function enviaPremios(idGrupo) {
	($("#grupo_id")).val(idGrupo);
	document.forms["frmMain"].action = "tarjetasConAciertosClasificacion.action";
	document.forms["frmMain"].submit();
}


