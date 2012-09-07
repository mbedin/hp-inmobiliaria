<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
	 	<@show.hidden name="hdnRetorno" value="${retorno}" />
		<input type="hidden" name="grupo.id" id="grupo_id" value="${grupo.id}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.grupos.posiciones.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.grupo.tarjeta.numeroTarjeta"/></td>
										<td><@show.label key="admin.grupo.tarjeta.nombreyapellido"/></td>
										<td><@show.label key="admin.grupo.tarjeta.EMail"/></td>
									</tr>
									<#list tarjetas as tarjeta>
										<tr>
											<td align="center">${tarjeta.numeroTarjeta}</td>
											<td align="center">${tarjeta.cliente.nombreYApellido}</td>
											<td align="center">${tarjeta.cliente.EMail}</td>
										</tr>
									</#list>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0">
									<tr>
										<td valign="top"><@show.button key="admin.button.exportar" id="tarjetasConPremioClasificacionExcel"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top"><@show.button key="admin.partidos.button.cancelar" id="btnCancelar"/><br></td>
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