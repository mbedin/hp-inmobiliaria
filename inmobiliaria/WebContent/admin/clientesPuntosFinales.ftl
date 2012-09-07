<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.reporteGeneralClientes.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.cliente.usuario"/></td>
										<td><@show.label key="admin.cliente.nombre"/></td>
										<td><@show.label key="admin.cliente.aceptoBases"/></td>
										<td><@show.label key="admin.puntosTriviaClientes.puntos"/></td>
									</tr>
									<#list clientes as cliente>
										<tr>
											<td align="center">${cliente.usuario}</td>
											<td align="center">${cliente.nombreYApellido}</td>
											<#if cliente.aceptoBases>
												<td align="center"><@show.label key="admin.clientesAceptoBases.si"/></td>
											<#else>
												<td align="center"><@show.label key="admin.clientesAceptoBases.no"/></td>
											</#if>
											<td align="center">${cliente.tarjetasExtras?c}</td>
										</tr>
									</#list>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0">
									<tr>
										<td valign="top"><@show.button key="admin.button.exportar" id="btnPuntosClientesFinalesExcel"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top"><@show.button key="admin.menu.principal" id="btnMenu"/><br></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>			
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>					
	</form>
</@show.pageAdmin>