$(document).ready(function() {

	$("#btnBuscarAceptoBases").bind("click", function(){
		document.forms["frmMain"].action = "clientesAceptoBases.action";
		document.forms["frmMain"].submit();
	});

	$("#btnExcelAceptoBases").bind("click", function(){
		document.forms["frmMain"].action = "clientesAceptoBasesExcel.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnTarjetasClientesExcel").bind("click", function(){
		document.forms["frmMain"].action = "reporteTarjetasClientesExcel.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnPuntosTriviaClientesExcel").bind("click", function(){
		document.forms["frmMain"].action = "reportePuntosTriviaClientesExcel.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnReporteGeneralClientesExcel").bind("click", function(){
		document.forms["frmMain"].action = "reporteGeneralClientesExcel.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnReporteTarjetasPorPuntosExcel").bind("click", function(){
		document.forms["frmMain"].action = "reporteTarjetasPorPuntosExcel.action";
		document.forms["frmMain"].submit();
	});
	
	
	$("#btnReportePuntosClientesExcel").bind("click", function(){
		document.forms["frmMain"].action = "reporteClientesPorPuntosExcel.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnPuntosClientesFinalesExcel").bind("click", function(){
		document.forms["frmMain"].action = "reporteClientesPuntosFinalesExcel.action";
		document.forms["frmMain"].submit();
	});
	
	
});







