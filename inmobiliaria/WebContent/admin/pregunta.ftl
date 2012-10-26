<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table border="0">
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.preguntas.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0" class="txTahomaNgr10">
									<#if preguntaAdapter.pregunta.id != 0>
										<tr>
											<td><@show.label key="admin.pregunta.id"/></td>
											<td>&nbsp;</td>
											<td>
												<@show.inputText key="pregunta_id" disabled="true" required="true" style="null" value="${preguntaAdapter.pregunta.id?c}" size="10" class="inputText" maxlength="20"/>
												<input type="hidden" name="preguntaAdapter.pregunta.id" id="preguntaAdapter.pregunta.id" value="${preguntaAdapter.pregunta.id?c}" />
											</td>
										</tr>
									</#if>
									<tr>
										<td><@show.label key="admin.pregunta.descripcion"/></td>
										<td>&nbsp;</td>
										<td>
											<textarea cols="60" rows="5" name="preguntaAdapter.pregunta.descripcion" id="preguntaAdapter.pregunta.descripcion" class="taDescripcion">${preguntaAdapter.pregunta.descripcion}</textarea>
										</td>
									</tr>
									
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="pregunta.descripcion"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.pregunta.puntos"/></td>
										<td>&nbsp;</td>
										<td>
											<select name="preguntaAdapter.pregunta.puntos" id="preguntaAdapter.pregunta.puntos" class="selectFixed">
													<option value="3" <#if 3 == preguntaAdapter.pregunta.puntos > selected </#if>>3</option>
													<option value="5" <#if 5 == preguntaAdapter.pregunta.puntos > selected </#if>>5</option>
													<option value="7" <#if 7 == preguntaAdapter.pregunta.puntos > selected </#if>>7</option>
											</select>
										</td>	
									</tr>
									<tr>
										<td><@show.label key="admin.pregunta.fecha"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="preguntaAdapter_fechaPublicacion" name="preguntaAdapter.fechaPublicacion" class="inputTextDate" required="true" value="${preguntaAdapter.fechaPublicacion}" size="50" maxlength="10">&nbsp;(dd/mm/yyyy)
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="pregunta.fechaPublicacion"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.pregunta.fechaFinPub"/></td>
										<td>&nbsp;</td>
										<td>
											<input type="text" id="preguntaAdapter_fechaFinPublicacion" name="preguntaAdapter.fechaFinPublicacion" class="inputTextDate" required="true" value="${preguntaAdapter.fechaFinPublicacion}" size="50" maxlength="10">&nbsp;(dd/mm/yyyy)
										</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="pregunta.fechaFinPublicacion"/></td>
									</tr>
									<tr>	
										<td colspan="3" align="center"><@show.labelErrorField key="pregunta.rangoFechas"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.pregunta.respCorrecta"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="preguntaAdapter.respCorrecta" disabled="false" required="true" style="null" value="${preguntaAdapter.respCorrecta?string}" size="50" class="inputText" maxlength="20"/>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="pregunta.respCorrecta"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.pregunta.respIncorrecta1"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="preguntaAdapter.respuestaIncorrecta1" disabled="false" required="true" style="null" value="${preguntaAdapter.respuestaIncorrecta1?string}" size="50" class="inputText" maxlength="20"/>&nbsp;</td>
									</tr>
									<tr>
										<td><@show.label key="admin.pregunta.respIncorrecta2"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="preguntaAdapter.respuestaIncorrecta2" disabled="false" required="true" style="null" value="${preguntaAdapter.respuestaIncorrecta2?string}" size="50" class="inputText" maxlength="20"/>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="pregunta.respIncorrectas"/></td>
									</tr>
									
									<tr>
										<td colspan="3" align="center"><@show.labelErrorField key="pregunta"/></td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.preguntas.button.grabar" id="btnGrabar"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td><@show.button key="admin.preguntas.button.cancelar" id="btnCancelar"/></td>
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