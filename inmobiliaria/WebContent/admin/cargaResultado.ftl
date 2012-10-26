<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<input type="hidden" name="partidoAdapter.partido.id" id="partidoAdapter_partido_id" value="${partidoAdapter.partido.id}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table border="0">
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.partidos.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0" class="txTahomaNgr10">
										<tr>
											<td><@show.label key="admin.partido.equipoLocal"/></td>
											<td>&nbsp;</td>
											<td>${partidoAdapter.partido.equipoLocal.descripcion}</td>
										</tr>
										<tr>
											<td><@show.label key="admin.partido.golesLocal"/></td>
											<td>&nbsp;</td>
											<td><@show.inputText key="partidoAdapter.partido.golesLocal" disabled="false" required="true" style="null" value="${partidoAdapter.partido.golesLocal}" size="50" class="inputText" maxlength="10"/></td>
										</tr>
										<tr>
											<td><@show.label key="admin.partido.equipoVisitante"/></td>
											<td>&nbsp;</td>
											<td>${partidoAdapter.partido.equipoVisitante.descripcion}</td>
										</tr>
										<tr>
											<td><@show.label key="admin.partido.golesVisitante"/></td>
											<td>&nbsp;</td>
											<td><@show.inputText key="partidoAdapter.partido.golesVisitante" disabled="false" required="true" style="null" value="${partidoAdapter.partido.golesVisitante}" size="50" class="inputText" maxlength="10"/></td>
										</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.partidos.button.grabar" id="btnGrabar"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td><@show.button key="admin.partidos.button.cancelar" id="btnCancelar"/></td>
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