<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top" height="50">
				<td class="clsTitulo"><@show.label key="admin.menu.principal"/></td>
			</tr>
			<tr valign="top" height="450">
				<td class="menu">
					<ul>
						<@show.menuOption key="admin.menu.tarjetasNuevas" id="btnTarjetasNuevas"/>
						<@show.menuOption key="admin.menu.preguntas" id="btnPreguntas"/>
						<@show.menuOption key="admin.menu.clientesAceptoBases" id="btnClienteAceptoBases"/>
						<@show.menuOption key="admin.menu.tarjetasClientes" id="btnTarjetasClientes"/>
						<@show.menuOption key="admin.menu.puntosTriviaClientes" id="btnPuntosTrivia"/>
						<@show.menuOption key="admin.menu.listadoGeneral" id="btnListadoGeneral"/>
						<@show.menuOption key="admin.menu.partidos" id="btnPartidos"/>
						<@show.menuOption key="admin.menu.terjetasPorPuntos" id="btnTarjetasPorPuntos"/>
						<@show.menuOption key="admin.menu.posiciones" id="btnPosiciones"/>
						<@show.menuOption key="admin.menu.tarjetasOctavos" id="btnPlayOff"/>
						<@show.menuOption key="admin.menu.tarjetasCuartos" id="btnPlayOffCuartos"/>
						<@show.menuOption key="admin.menu.tarjetasSemi" id="btnPlayOffSemi"/>
						<@show.menuOption key="admin.menu.tarjetasFinal" id="btnPlayOffFinal"/>
						<@show.menuOption key="admin.menu.reporteClientesPorPuntos" id="btnListadoPuntosClientes"/>
						<@show.menuOption key="admin.menu.reporteClientesPuntosFinales" id="btnListadoPuntosFinales"/>
					</ul>
				</td>
			</tr>				
		</table>
	</form>
</@show.pageAdmin>