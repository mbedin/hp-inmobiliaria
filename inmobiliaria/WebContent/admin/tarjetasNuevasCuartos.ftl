<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr valign="top">
							<td colspan="2" class="clsTitulo"><@show.label key="admin.tarjetasNuevas.titulo"/><br><br></td>
						</tr>
						<tr>
							<#if ( (clientes?size)?? && clientes?size > 0 ) >
								<td colspan="2">
									<table class="clsLista">
										<tr>
											<td>&nbsp;</td>
											<td><@show.label key="admin.tarjetasNuevas.cliente.nombre"/></td>
										</tr>
										<#list clientes as cliente>
											<tr>
												<td><@show.checkboxEspecial name="idCliente" id="idCliente${cliente.id?c}" value="${cliente.id?c}" checked="true"/></td>
												<td align="left">${cliente.nombreYApellido}</td>
											</tr>
										</#list>
									</table>
								</td>
							<#else>
								<td colspan="2" class="txTahomaNgr11b">
									<@show.label key="admin.tarjetasNuevas.empty"/>
								</td>
							</#if>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsBotonera">
									<tr>
										<#if ( (clientes?size)?? && clientes?size > 0 ) >
											<td><@show.button key="admin.tarjetasNuevas.button.generar" id="btnGenerar4"/></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
										</#if>
										<td><@show.button key="admin.menu.principal" id="btnMenu"/></td>
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