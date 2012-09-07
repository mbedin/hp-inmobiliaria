<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<input type="hidden" name="promocion.id" id="promocion_id" value="0" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.promociones.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.promocion.id"/></td>
										<td><@show.label key="admin.promocion.nombre"/></td>
										<td><@show.label key="admin.promocion.vigencia"/></td>
										<td>&nbsp;</td>
									</tr>
									<#list promociones as promocion>
										<tr>
											<td align="left">${promocion.id?c}</td>
											<td align="left">${promocion.nombreProducto}</td>
											<td align="right">${promocion.vigencia}</td>
											<td nowrap>
												<a href="#" onclick="javascript: modificarPromocion(${promocion.id?c});"><@show.label key="admin.promociones.editar"/></a>&nbsp;&nbsp;&nbsp;
												<a href="#" onclick="javascript: eliminarPromocion(${promocion.id?c});"><@show.label key="admin.promociones.eliminar"/></a>	
											</td>
										</tr>
									</#list>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsBotonera">
									<tr>
										<td><@show.button key="admin.promociones.button.nueva" id="btnNueva"/></td>
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