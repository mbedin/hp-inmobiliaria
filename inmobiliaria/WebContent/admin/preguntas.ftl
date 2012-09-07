<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<@show.hidden name="hdnRetorno" value="${retorno}" />
		<input type="hidden" name="preguntaAdapter.pregunta.id" id="preguntaAdapter_pregunta_id" value="0" />
		<input type="hidden" name="paginador.numeroPagina" id="paginador_numeroPagina" value="${paginador.numeroPagina?c}" />
		<input type="hidden" name="paginador.tamanoPagina" id="paginador_tamanoPagina" value="${paginador.tamanoPagina?c}" />
		<input type="hidden" name="paginador.totalRegistros" id="paginador_totalRegistros" value="${paginador.totalRegistros?c}" />
		<input type="hidden" name="paginador.accion" id="paginador_accion" value="${paginador.accion}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.preguntas.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.pregunta.id"/></td>
										<td><@show.label key="admin.pregunta.descripcion"/></td>
										<td><@show.label key="admin.pregunta.fecha"/></td>
										<td><@show.label key="admin.pregunta.fechaFinPub"/></td>
										<td><@show.label key="admin.pregunta.puntos"/></td>
										<td>&nbsp;</td>
									</tr>
									<#if ( (preguntas?size)?? && preguntas?size > 0 ) >
										<#list preguntas as pregunta>
											<tr>
												<td align="left">${pregunta.id?c}</td>
												<td align="left">${pregunta.descripcion}</td>
												<td align="center">${pregunta.fechaPublicacion?string('dd/MM/yyyy')}</td>
												<td align="center">${pregunta.fechaFinPublicacion?string('dd/MM/yyyy')}</td>
												<td align="center">${pregunta.puntos?c}</td>
												<td nowrap>
													<#if pregunta.editable>
														<a href="#" onclick="javascript: modificarPregunta(${pregunta.id?c});"><@show.label key="admin.preguntas.editar"/></a>&nbsp;&nbsp;&nbsp;
													</#if>
													<a href="#" onclick="javascript: eliminarPregunta(${pregunta.id?c});"><@show.label key="admin.preguntas.eliminar"/></a>	
												</td>
											</tr>
											
										</#list>
									<#else>
										<@show.label key="admin.preguntas.empty"/>
									</#if>
								</table>
							</td>
						</tr>
								
						<#if paginador.totalPaginas gt 1>
							<tr>
								<td colspan="2" align="center">
									<table class="clsTxPaginador">
										<tr>
											<td align="center">
												<@show.label key="admin.preguntas.tituloPaginas"/>&nbsp;${paginador.registroDesde?c}&nbsp;<@show.label key="paginador.a"/>&nbsp;${paginador.registroHasta?c}&nbsp;<@show.label key="paginador.de"/>&nbsp;${paginador.totalRegistros?c}
											</td>
										</tr>
										<tr>
											<td align="center">
												<#if paginador.tieneAnterior>
													<a href="#" class="lnkPaginador" id="lnkAnterior"><@show.labelOnly key="paginador.anterior"/>&nbsp;${paginador.tamanoPagina?c}</a>
												</#if>
												<#if paginador.tieneAnterior && paginador.tieneSiguiente>
													&nbsp;-&nbsp;
												</#if>
												<#if paginador.tieneSiguiente>
													<a href="#" class="lnkPaginador" id="lnkSiguiente"><@show.labelOnly key="paginador.siguiente"/>&nbsp;${paginador.tamanoPagina?c}</a>
												</#if>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</#if>	
							
						<tr>
							<td colspan="2" align="center"><@show.labelErrorField key="pregunta.eliminar"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsBotonera">
									<tr>
										<td><@show.button key="admin.preguntas.button.nueva" id="btnNueva"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
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