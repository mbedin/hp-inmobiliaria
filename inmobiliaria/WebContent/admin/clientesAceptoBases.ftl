<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.clientesAceptoBases.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="txTahomaNgr10" border="0">
									<tr>
										<td><@show.label key="admin.clientesAceptoBases.listar"/></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
											<#if cliente.aceptoBases>
												<@show.radioButton name="cliente.aceptoBases" id="cliente.aceptoBases" value="true" checked="true" /><@show.label key="admin.clientesAceptoBases.listar.si"/><br>
												<@show.radioButton name="cliente.aceptoBases" id="cliente.aceptoBases" value="false" checked="false"/><@show.label key="admin.clientesAceptoBases.listar.no"/>
											<#else>
												<@show.radioButton name="cliente.aceptoBases" id="cliente.aceptoBases" value="true" checked="false" /><@show.label key="admin.clientesAceptoBases.listar.si"/><br>
												<@show.radioButton name="cliente.aceptoBases" id="cliente.aceptoBases" value="false" checked="true"/><@show.label key="admin.clientesAceptoBases.listar.no"/>
											</#if>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="2">&nbsp;</td>
										<td><@show.button key="admin.clientesAceptoBases.button.buscar" id="btnBuscarAceptoBases"/></td>
									</tr>
								 </table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.cliente.nombre"/></td>
										<td><@show.label key="admin.cliente.mail"/></td>
									</tr>
									<#list clientes as cliente>
										<tr>
											<td align="left">${cliente.nombreYApellido}</td>
											<td align="left">${cliente.EMail}</td>
										</tr>
									</#list>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0">
									<tr>
										<td valign="top"><@show.button key="admin.button.exportar" id="btnExcelAceptoBases"/></td>
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