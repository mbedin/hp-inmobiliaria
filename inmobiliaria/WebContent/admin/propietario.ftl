<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<input type="hidden" name="propietario.propietario.id" id="propietario_propietario_id" value="${propietario.propietario.id}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table border="0">
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.propietario.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0" class="txTahomaNgr10">
									<tr>
										<td><@show.label key="admin.propietario.fechaNacimiento"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propietario_fechaNacimiento" name="propietario.fechaNacimiento" class="inputTextDate" required="true" value="${propietario.fechaNacimiento}" size="50" maxlength="10">&nbsp;(dd/mm/yyyy)
										</td>
									</tr>
									<tr>
										<td><@show.label key="admin.propietario.nombre"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propietario_nombreYApellido" name="propietario.nombreYApellido" class="inputText" required="true" value="${propietario.nombreYApellido}" size="50" maxlength="10">
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propietario.nombreYApellido"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propietario.direccion"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propietario_direccion" name="propietario.direccion" class="inputText" required="true" value="${propietario.direccion}" size="50" maxlength="10">
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propietario.direccion"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propietario.localidad"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="propietario.propietario.localidad.id" id="propietario.propietario.localidad.id" class="selectFixed">
											<#list localidades as loc>
												<option value="${loc.id?c}" <#if loc.id?c == loc.id?c>selected</#if>>${loc.descripcion}</option>				
											</#list>
										</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propietario.localidad"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><@show.label key="admin.propietario.cantAmbientes"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="propietario.propietario.cantAmbientes" id="propietario.propietario.cantAmbientes" class="selectFixed">
												<option value="1" <#if 1 == propietario.propietario.cantAmbientes > selected </#if>>1</option>
												<option value="2" <#if 2 == propietario.propietario.cantAmbientes > selected </#if>>2</option>
												<option value="3" <#if 3 == propietario.propietario.cantAmbientes > selected </#if>>3</option>
												<option value="4" <#if 4 == propietario.propietario.cantAmbientes > selected </#if>>4</option>
												<option value="5" <#if 5 == propietario.propietario.cantAmbientes > selected </#if>>5</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propietario.cantAmbientes"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propietario.cantHabitaciones"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="propietario.propietario.cantHabitaciones" id="propietario.propietario.cantHabitaciones" class="selectFixed">
												<option value="1" <#if 1 == propietario.propietario.cantHabitaciones > selected </#if>>1</option>
												<option value="2" <#if 2 == propietario.propietario.cantHabitaciones > selected </#if>>2</option>
												<option value="3" <#if 3 == propietario.propietario.cantHabitaciones > selected </#if>>3</option>
												<option value="4" <#if 4 == propietario.propietario.cantHabitaciones > selected </#if>>4</option>
												<option value="5" <#if 5 == propietario.propietario.cantHabitaciones > selected </#if>>5</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propietario.localidad"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propietario.propietario.dni"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propietario_dniPropietario" name="propietario.dniPropietario" class="inputText" required="true" value="${propietario.dniPropietario}" size="50" maxlength="10">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.propietario.button.grabar" id="btnGrabapropietario"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td><@show.button key="admin.propietario.button.cancelar" id="btnCancelar"/></td>
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