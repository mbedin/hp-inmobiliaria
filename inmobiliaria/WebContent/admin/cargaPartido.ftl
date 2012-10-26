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
										<td><@show.label key="admin.partido.fecha"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="partidoAdapter_fechaPartido" name="partidoAdapter.fechaPartido" class="inputTextDate" required="true" value="${partidoAdapter.fechaPartido}" size="50" maxlength="10">&nbsp;(dd/mm/yyyy)
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="partido.fechaPartido"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.partido.hora"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="partidoAdapter.horaPartido" disabled="false" required="true" style="null" value="${partidoAdapter.horaPartido?string}" size="10" class="inputText" maxlength="10"/>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="partido.horaPartido"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.partido.equipoLocal"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="partidoAdapter.partido.equipoLocal.id" id="partidoAdapter.partido.equipoLocal.id" class="selectFixed">
											<#list Equipos as equipo>
												<option value="${equipo.id?c}" <#if equipo.id?c == equipo.id?c>selected</#if>>${equipo.descripcion}</option>				
											</#list>
										</select>
										</td>
									</tr>
									<tr>
										<td><@show.label key="admin.partido.equipoVisitante"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="partidoAdapter.partido.equipoVisitante.id" id="partidoAdapter.partido.equipoVisitante.id" class="selectFixed">
												<#list Equipos as equipo>
													<option value="${equipo.id?c}" <#if equipo.id?c == equipo.id?c>selected</#if>>${equipo.descripcion}</option>				
												</#list>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="partido.equipos"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.partido.sede"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="partidoAdapter.partido.sede.id" id="partidoAdapter.partido.sede.id" class="selectFixed">
											<#list Sedes as sede>
												<option value="${sede.id?c}" <#if sede.id?c == sede.id?c>selected</#if>>${sede.descripcion}</option>				
											</#list>
										</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="partido.sede"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.partido.fase"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="partidoAdapter.partido.fase.id" id="partidoAdapter.partido.fase.id" class="selectFixed">
												<#list fases as fase>
													<option value="${fase.id?c}" <#if fase.id?c == fase.id?c>selected</#if>>${fase.descripcion}</option>				
												</#list>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="partido.fase"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.partidos.button.grabar" id="btnGrabaPartido"/></td>
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