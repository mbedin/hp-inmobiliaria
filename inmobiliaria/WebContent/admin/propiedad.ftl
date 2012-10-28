<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<input type="hidden" name="propiedadAdapter.propiedad.id" id="propiedadAdapter_propiedad_id" value="${propiedadAdapter.propiedad.id}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table border="0">
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.propiedad.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0" class="txTahomaNgr10">
									<tr>
										<td><@show.label key="admin.propiedad.fecha"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propiedadAdapter_fechaAlta" name="propiedadAdapter.fechaAlta" class="inputTextDate" required="true" value="${propiedadAdapter.fechaAlta}" size="50" maxlength="10">&nbsp;(dd/mm/yyyy)
										</td>
									</tr>
									<tr>
										<td><@show.label key="admin.propiedad.descripcion"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propiedadAdapter_descripcion" name="propiedadAdapter.descripcion" class="inputText" required="true" value="${propiedadAdapter.descripcion}" size="50" maxlength="10">
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propiedad.descripcion"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propiedad.direccion"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propiedadAdapter_direccion" name="propiedadAdapter.direccion" class="inputText" required="true" value="${propiedadAdapter.direccion}" size="50" maxlength="10">
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propiedad.direccion"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propiedad.localidad"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="propiedadAdapter.propiedad.localidad.id" id="propiedadAdapter.propiedad.localidad.id" class="selectFixed">
											<#list localidades as loc>
												<option value="${loc.id?c}" <#if loc.id?c == loc.id?c>selected</#if>>${loc.descripcion}</option>				
											</#list>
										</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propiedad.localidad"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><@show.label key="admin.propiedad.cantAmbientes"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="propiedadAdapter.propiedad.cantAmbientes" id="propiedadAdapter.propiedad.cantAmbientes" class="selectFixed">
												<option value="1" <#if 1 == propiedadAdapter.propiedad.cantAmbientes > selected </#if>>1</option>
												<option value="2" <#if 2 == propiedadAdapter.propiedad.cantAmbientes > selected </#if>>2</option>
												<option value="3" <#if 3 == propiedadAdapter.propiedad.cantAmbientes > selected </#if>>3</option>
												<option value="4" <#if 4 == propiedadAdapter.propiedad.cantAmbientes > selected </#if>>4</option>
												<option value="5" <#if 5 == propiedadAdapter.propiedad.cantAmbientes > selected </#if>>5</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propiedad.cantAmbientes"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propiedad.cantHabitaciones"/></td>
										<td>&nbsp;</td>
										<td width="265" class="clsTxArialNgr7">
											<select name="propiedadAdapter.propiedad.cantHabitaciones" id="propiedadAdapter.propiedad.cantHabitaciones" class="selectFixed">
												<option value="1" <#if 1 == propiedadAdapter.propiedad.cantHabitaciones > selected </#if>>1</option>
												<option value="2" <#if 2 == propiedadAdapter.propiedad.cantHabitaciones > selected </#if>>2</option>
												<option value="3" <#if 3 == propiedadAdapter.propiedad.cantHabitaciones > selected </#if>>3</option>
												<option value="4" <#if 4 == propiedadAdapter.propiedad.cantHabitaciones > selected </#if>>4</option>
												<option value="5" <#if 5 == propiedadAdapter.propiedad.cantHabitaciones > selected </#if>>5</option>
											</select>
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="propiedad.localidad"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.propiedad.propietario.dni"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="propiedadAdapter_dniPropietario" name="propiedadAdapter.dniPropietario" class="inputText" required="true" value="${propiedadAdapter.dniPropietario}" size="50" maxlength="10">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.propiedad.button.grabar" id="btnGrabapropiedad"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td><@show.button key="admin.propiedad.button.cancelar" id="btnCancelar"/></td>
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