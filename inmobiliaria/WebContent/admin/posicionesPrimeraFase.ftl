<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<@show.hidden name="hdnRetorno" value="${retorno}" />
		<input type="hidden" name="grupo.id" id="grupo_id" value="${grupo.id?c}}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.grupos.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table class="clsLista">
									<tr>
										<td><@show.label key="admin.grupos.id"/></td>
										<td><@show.label key="admin.grupos.descripcion"/></td>
										<td><@show.label key="admin.grupos.equipoPrimero.descripcion"/></td>
										<td><@show.label key="admin.grupos.equipoSegundo.descripcion"/></td>
										
										<td>&nbsp;</td>
									</tr>
									<#list grupos as grupo>
									<tr>
										<td align="center">${grupo.id?c}</td>
										<td align="center">${grupo.descripcion}</td>
										<#if ( (grupo.equipoPrimero)?? && grupo.equipoPrimero != "" ) >
											<td align="center">${grupo.equipoPrimero.descripcion}</td>
											<td align="center">${grupo.equipoSegundo.descripcion}</td>
											<td>
												<a href="#" onclick="javascript: cargaPosicion(${grupo.id?c});"><@show.label key="admin.grupos.cargaPosicion"/></a>&nbsp;
												<a href="#" onclick="javascript: enviaPremios(${grupo.id?c});"><@show.label key="admin.grupos.enviaPremios"/></a>&nbsp;
											</td>
										<#else>
											<td align="center">&nbsp;</td>
											<td align="center">&nbsp;</td>
											<td>
												<a href="#" onclick="javascript: cargaPosicion(${grupo.id?c});"><@show.label key="admin.grupos.cargaPosicion"/></a>&nbsp;
											</td>										
										</#if>
									</tr>
									</#list>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><@show.labelErrorField key="grupo.eliminar"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.partidos.button.volver" id="btnVolver"/></td>
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