<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<@show.hidden name="hdnRetorno" value="${retorno}" />
		<input type="hidden" name="partidoAdapter.partido.id" id="partidoAdapter_partido_id" value="0" />
		<input type="hidden" name="paginador.numeroPagina" id="paginador_numeroPagina" value="${paginador.numeroPagina?c}" />
		<input type="hidden" name="paginador.tamanoPagina" id="paginador_tamanoPagina" value="${paginador.tamanoPagina?c}" />
		<input type="hidden" name="paginador.totalRegistros" id="paginador_totalRegistros" value="${paginador.totalRegistros?c}" />
		<input type="hidden" name="paginador.accion" id="paginador_accion" value="${paginador.accion}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.partidos.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.partido.id"/></td>
										<td><@show.label key="admin.partido.fecha"/></td>
										<td><@show.label key="admin.partido.fase"/></td>
										<td><@show.label key="admin.partido.grupo"/></td>
										<td><@show.label key="admin.partido.equipoLocal"/></td>
										<td><@show.label key="admin.partido.golesLocal"/></td>
										<td><@show.label key="admin.partido.equipoVisitante"/></td>
										<td><@show.label key="admin.partido.golesVisitante"/></td>
										<td>&nbsp;</td>
									</tr>
									<#if ( (partidos?size)?? && partidos?size > 0 ) >
										<#list partidos as partido>
											<tr>
												<td align="left">${partido.id?c}</td>
												<td align="center">${partido.fecha?string('MM/dd/yyyy')}</td>
												<td align="left">${partido.fase.descripcion}</td>
												<#if ( (partido.grupo)?? && partido.grupo != "" ) >
													<td align="left">${partido.grupo.descripcion}</td>	
												<#else>
													<td align="center">&nbsp;</td>
												</#if>
												<td align="left">${partido.equipoLocal.descripcion}</td>
												<#if ( (partido.resultado)?? && partido.resultado != "" ) >
													<td align="center">${partido.golesLocal}</td>
												<#else>
													<td align="center">&nbsp;</td>
												</#if>
												<td align="left">${partido.equipoVisitante.descripcion}</td>
												<#if ( (partido.resultado)?? && partido.resultado != "" ) >
													<td align="center">${partido.golesVisitante}</td>
												<#else>
													<td align="center">&nbsp;</td>
												</#if>
												<td nowrap>
													<a href="#" onclick="javascript: cargaResultado(${partido.id?c});"><@show.label key="admin.partidos.cargaResultado"/></a>&nbsp;&nbsp;&nbsp;
													<#if ( partido.equipoLocal.resultadoRequerido || partido.equipoVisitante.resultadoRequerido ) >
														<#if ( (partido.resultado)?? && partido.resultado != "" )>
														<a href="#" onclick="javascript: listaTarjetasConPremioEnPartido(${partido.id?c});"><@show.label key="admin.partidos.partidosConPremios"/></a>&nbsp;&nbsp;&nbsp;
														<#else>
															<img src="img/punto.gif" width="20" height="20" alt="" border="0">
														</#if>
													<#else>
														<img src="img/punto.gif" width="20" height="20" alt="" border="0">
													</#if>	
												</td>
											</tr>
											
										</#list>
									<#else>
										<@show.label key="admin.partido.empty"/>
									</#if>
								</table>
							</td>
						</tr>								
						
						<#if paginador.totalPaginas gt 1>
							<tr>
								<td colspan="2" class="clsTxPaginador">
									<@show.label key="admin.partidos.tituloPaginas"/>&nbsp;${paginador.registroDesde?c}&nbsp;<@show.label key="paginador.a"/>&nbsp;${paginador.registroHasta?c}&nbsp;<@show.label key="paginador.de"/>&nbsp;${paginador.totalRegistros?c}<br>
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
						</#if>	
							
						<tr>
							<td colspan="2" align="center"><@show.labelErrorField key="partido.eliminar"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.partidos.button.volver" id="btnVolver"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td><@show.button key="admin.partidos.button.nuevo" id="btnNuevo"/></td>
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