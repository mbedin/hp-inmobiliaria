<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<input type="hidden" name="grupo.id" id="grupo.id" value="${grupo.id?c}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table border="0" class="txTahomaNgr10">
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.cargaPosicionesGrupo.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2" class="clsTitulo">${grupo.descripcion}</td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0" class="txTahomaNgr10">
									<tr>
										<td><@show.label key="admin.grupo.primerPuesto"/></td>
										<td>&nbsp;</td>
										<td>
											<select name="grupo.equipoPrimero.id" id="grupo.equipoPrimero.id" class="selectFixed">
												<#list Equipos as equipo>
													<option value="${equipo.id?c}" <#if equipo.id?c == equipo.id?c>selected</#if>>${equipo.descripcion}</option>				
												</#list>
											</select>
										</td>	
									</tr>
									<tr>
										<td><@show.label key="admin.grupo.segundoPuesto"/></td>
										<td>&nbsp;</td>
										<td>
											<select name="grupo.equipoSegundo.id" id="grupo.equipoSegundo.id" class="selectFixed">
												<#list Equipos as equipo>
													<option value="${equipo.id?c}" <#if equipo.id?c == equipo.id?c>selected</#if>>${equipo.descripcion}</option>				
												</#list>
											</select>
										</td>	
									</tr>
									<tr>
										<td colspan="6" align="center"><@show.labelErrorField key="posiciones.guardar"/></td>
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