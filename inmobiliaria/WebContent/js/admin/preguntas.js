$(document).ready(function() {

	$("#btnNueva").bind("click", function(){
		document.forms["frmMain"].action = "preguntaEdit.action";
		document.forms["frmMain"].submit();
	});

	$("#btnGrabar").bind("click", function(){
		document.forms["frmMain"].action = "grabarPregunta.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnCancelar").bind("click", function(){
		document.forms["frmMain"].action = "preguntas.action";
		document.forms["frmMain"].submit();
	});
	

	$("#lnkAnterior").bind("click", function(){
		($("#paginador_accion")).val("anterior");
		document.forms["frmMain"].action = "preguntas.action";
		document.forms["frmMain"].submit();
	});

	$("#lnkSiguiente").bind("click", function(){
		($("#paginador_accion")).val("siguiente");
		document.forms["frmMain"].action = "preguntas.action";
		document.forms["frmMain"].submit();
	});
	
	$("#preguntaAdapter_fechaPublicacion").datepicker({ dateFormat: 'dd/mm/yy', showOn: 'both', buttonImage: 'img/datePicker/calendar.gif', buttonImageOnly: true });
	
	$("#preguntaAdapter_fechaFinPublicacion").datepicker({ dateFormat: 'dd/mm/yy', showOn: 'both', buttonImage: 'img/datePicker/calendar.gif', buttonImageOnly: true  });
	
});


function modificarPregunta(idPregunta) {
	($("#preguntaAdapter_pregunta_id")).val(idPregunta);
	document.forms["frmMain"].action = "preguntaEdit.action";
	document.forms["frmMain"].submit();
}

function eliminarPregunta(idPregunta) {
	($("#preguntaAdapter_pregunta_id")).val(idPregunta);
	document.forms["frmMain"].action = "eliminarPregunta.action";
	document.forms["frmMain"].submit();
}
