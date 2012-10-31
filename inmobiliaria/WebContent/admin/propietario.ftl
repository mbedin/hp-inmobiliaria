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
										<td rowspan="15" height="85"><img src="img/punto.gif" width="126" height="7" alt="" border="0"></td>
										<td class="clsTxArialBlc12" ><@show.label key="propietario.NombreyApellido"/></td>
										<td>&nbsp;</td>
										<td >
										<@show.inputText key="propietario.nombreYApellido" disabled="false" required="true" style="null" value="${propietario.nombreYApellido?string}" size="50" class="inputText" maxlength="20"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="4" align="center"><@show.labelErrorField key="propietario.nombreyapellido"/></td>
									</tr>
									<tr>
										<td class="clsTxArialBlc12" ><@show.label key="propietario.celular"/></td>
										<td>&nbsp;</td>
										<td>
											<@show.inputText key="propietario.celular" disabled="false" required="true" style="null" value="${propietario.celular?string}" size="20" class="inputText" maxlength="20"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="4" align="center"><@show.labelErrorField key="propietario.celular"/></td>
									</tr>
									<tr>
										<td class="clsTxArialBlc12" ><@show.label key="propietario.documento"/></td>
										<td>&nbsp;</td>
										<td>
											<select name="propietario.tipoDocumento.id" id="propietario.tipoDocumento.id" >
												<#list tipoDocumentos as tipoDocumento>
													<option value="${tipoDocumento.id?c}" <#if tipoDocumento.id == propietario.tipoDocumento.id>selected</#if> >${tipoDocumento.descripcionTipo}</option>
												</#list>
											</select>
											<@show.inputText key="propietario.numeroDocumento" disabled="false" required="true" style="null" value="${propietario.numeroDocumento?string}" size="15" class="inputText" maxlength="15"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="4" align="center"><@show.labelErrorField key="propietario.documento"/></td>
									</tr>
									<tr>
										<td class="clsTxArialBlc12" ><@show.label key="propietario.Email"/></td>
										<td>&nbsp;</td>
										<td>
											<@show.inputText key="propietario.email" disabled="false" required="true" style="null" value="${propietario.email?string}" size="40" class="inputText" maxlength="100"/>
										</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="4" align="center"><@show.labelErrorField key="propietario.email"/></td>
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