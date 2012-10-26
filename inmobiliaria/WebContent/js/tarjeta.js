$(document).ready(function() {

	$("#btnAceptar").bind("click", function(){
		document.forms["frmMain"].action = "tarjetaGrabar.action";
		document.forms["frmMain"].submit();
	});

	$("#btnModificar").bind("click", function(){
		document.forms["frmMain"].action = "tarjetaModificar.action";
		document.forms["frmMain"].submit();
	});
	
	$("#btnAceptar8").bind("click", function(){
		document.forms["frmMain"].action = "tarjetaGrabar8.action";
		document.forms["frmMain"].submit();
	});

	$("#btnModificar8").bind("click", function(){
		document.forms["frmMain"].action = "tarjetaModificar8.action";
		document.forms["frmMain"].submit();
	});
	
});

function chkLEV_click(checkbox) {
	var nombre = checkbox.name.split("_")[0];
	var index = checkbox.name.split("_")[1];
	
	if (nombre == "parLocal") {
		$("#parLocal_" + index).attr("checked", "checked");	
		$("#parEmpate_" + index).removeAttr("checked");
		$("#parVisitante_" + index).removeAttr("checked");
	} else if (nombre == "parEmpate") {
		$("#parLocal_" + index).removeAttr("checked");
		$("#parEmpate_" + index).attr("checked", "checked");
		$("#parVisitante_" + index).removeAttr("checked");
	} else if (nombre == "parVisitante") {
		$("#parLocal_" + index).removeAttr("checked");
		$("#parEmpate_" + index).removeAttr("checked");
		$("#parVisitante_" + index).attr("checked", "checked");
	}
}
