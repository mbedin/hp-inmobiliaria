<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<@show.hidden name="hdnRetorno" value="${retorno}" />
		<input type="hidden" name="propiedadAdapter.propiedad.id" id="propiedadAdapter_propiedad_id" value="0" />
		<input type="hidden" name="paginador.numeroPagina" id="paginador_numeroPagina" value="${paginador.numeroPagina?c}" />
		<input type="hidden" name="paginador.tamanoPagina" id="paginador_tamanoPagina" value="${paginador.tamanoPagina?c}" />
		<input type="hidden" name="paginador.totalRegistros" id="paginador_totalRegistros" value="${paginador.totalRegistros?c}" />
		<input type="hidden" name="paginador.accion" id="paginador_accion" value="${paginador.accion}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.propiedades.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.propiedades.descripcion"/></td>
										<td><@show.label key="admin.propiedades.direccion"/></td>
										<td><@show.label key="admin.propiedades.estado"/></td>
										<td><@show.label key="admin.propiedades.fechaInauguracion"/></td>
										<td><@show.label key="admin.propiedades.valor"/></td>
										<td><@show.label key="admin.propiedades.estado"/></td>
										<td>&nbsp;</td>
									</tr>
									<#if ( (propiedades?size)?? && propiedades?size > 0 ) >
										<#list propiedades as propiedad>
											<tr>
												<td align="left">${propiedad.descripcion}</td>
												<td align="left">${propiedad.direccion}</td>
												<td align="left">${propiedad.estado}</td>
												<td align="left">${propiedad.fechaInauguracion}</td>
												<td align="left">${propiedad.valor}</td>
												<td align="left">${propiedad.estado}</td>
											</tr>
										</#list>
									<#else>
										<@show.label key="admin.propiedades.empty"/>
									</#if>
								</table>
							</td>
						</tr>								
						
						<#if paginador.totalPaginas gt 1>
							<tr>
								<td colspan="2" class="clsTxPaginador">
									<@show.label key="admin.propiedades.tituloPaginas"/>&nbsp;${paginador.registroDesde?c}&nbsp;<@show.label key="paginador.a"/>&nbsp;${paginador.registroHasta?c}&nbsp;<@show.label key="paginador.de"/>&nbsp;${paginador.totalRegistros?c}<br>
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
							<td colspan="2" align="center"><@show.labelErrorField key="propiedad.eliminar"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.propiedades.button.volver" id="btnVolver"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td><@show.button key="admin.propiedades.button.nuevo" id="btnNuevo"/></td>
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