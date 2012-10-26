$(document).ready(function() {

	$("#btnPregunta3").bind("click", function(){
		($("#pregunta_puntos")).val(3);
		document.forms["frmMain"].action = "pregunta.action";
		document.forms["frmMain"].submit();
	});

	$("#btnPregunta5").bind("click", function(){
		($("#pregunta_puntos")).val(5);
		document.forms["frmMain"].action = "pregunta.action";
		document.forms["frmMain"].submit();
	});

	$("#btnPregunta7").bind("click", function(){
		($("#pregunta_puntos")).val(7);
		document.forms["frmMain"].action = "pregunta.action";
		document.forms["frmMain"].submit();
	});

	$("#btnRespuesta").bind("click", function(){

		document.forms["frmMain"].action = "respuesta.action";
		document.forms["frmMain"].submit();
	});
	
});
