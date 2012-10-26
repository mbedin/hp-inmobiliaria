<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.tarjetasClientes.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.cliente.nombre"/></td>
										<td><@show.label key="admin.cliente.mail"/></td>
										<td><@show.label key="admin.tarjetasClientes.total"/></td>
										<td><@show.label key="admin.tarjetasClientes.jugadas"/></td>
									</tr>
									<#list clientes as cliente>
										<tr>
											<td align="left">${cliente.nombreYApellido}</td>
											<td align="left">${cliente.EMail}</td>
											<td align="right">${cliente.tarjetasAnterior?c}</td>
											<td align="right">${cliente.tarjetasExtrasAnterior?c}</td>
										</tr>
									</#list>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0">
									<tr>
										<td valign="top"><@show.button key="admin.button.exportar" id="btnTarjetasClientesExcel"/></td>
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