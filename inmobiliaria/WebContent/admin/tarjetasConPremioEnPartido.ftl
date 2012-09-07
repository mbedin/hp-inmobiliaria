<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
	 	<@show.hidden name="hdnRetorno" value="${retorno}" />
		<input type="hidden" name="partidoAdapter.partido.id" id="partidoAdapter.partido_id" value="${partidoAdapter.partido.id}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.partidos.premiosInstantaneos.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.partido.tarjeta.numeroTarjeta"/></td>
										<td><@show.label key="admin.partido.tarjeta.nombreyapellido"/></td>
										<td><@show.label key="admin.partido.tarjeta.EMail"/></td>
									</tr>
									<#list tarjetas as tarjeta>
										<tr>
											<td align="left">${tarjeta.numeroTarjeta}</td>
											<td align="left">${tarjeta.cliente.nombreYApellido}</td>
											<td align="right">${tarjeta.cliente.EMail}</td>
										</tr>
									</#list>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0">
									<tr>
										<td valign="top"><@show.button key="admin.button.exportar" id="btnTarjetasPremiosInstantaneosExcel"/></td>
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