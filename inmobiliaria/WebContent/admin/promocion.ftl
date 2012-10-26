<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table border="0">
						<tr>
							<td colspan="2" class="clsTitulo"><@show.label key="admin.promociones.titulo"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<table border="0" class="txTahomaNgr10">
									<#if promocion.id != 0>
										<tr>
											<td><@show.label key="admin.promocion.id"/></td>
											<td>&nbsp;</td>
											<td>
												<@show.inputText key="id" disabled="true" required="true" style="null" value="${promocion.id?c}" size="10" class="inputText" maxlength="20"/>
												<input type="hidden" name="promocion.id" id="promocion.id" value="${promocion.id?c}" />
											</td>
										</tr>
									</#if>
									<tr>
										<td><@show.label key="admin.promocion.nombre"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="promocion.nombreProducto" disabled="false" required="true" style="null" value="${promocion.nombreProducto}" size="50" class="inputText" maxlength="200"/></td>
									</tr>
									<tr>
										<td><@show.label key="admin.promocion.texto"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="promocion.textoPromocion" disabled="false" required="true" style="null" value="${promocion.textoPromocion}" size="50" class="inputText" maxlength="200"/></td>
									</tr>
			
									<tr>
										<td><@show.label key="admin.promocion.imagen"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="promocion.imagen" disabled="false" required="true" style="null" value="${promocion.imagen}" size="50" class="inputText" maxlength="200"/></td>
									</tr>
			
									<tr>
										<td><@show.label key="admin.promocion.fechaDesde"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="promocion.fechaDesde" disabled="false" required="true" style="null" value="${promocion.fechaDesde?string('MM/dd/yyyy')}" size="50" class="inputText" maxlength="10"/>&nbsp;(mm/dd/yyyy)</td>
									</tr>
			
									<tr>
										<td><@show.label key="admin.promocion.fechaHasta"/></td>
										<td>&nbsp;</td>
										<td><@show.inputText key="promocion.fechaHasta" disabled="false" required="true" style="null" value="${promocion.fechaHasta?string('MM/dd/yyyy')}" size="50" class="inputText" maxlength="10"/>&nbsp;(mm/dd/yyyy)</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<table>
									<tr>
										<td><@show.button key="admin.promociones.button.grabar" id="btnGrabar"/></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td><@show.button key="admin.promociones.button.cancelar" id="btnCancelar"/></td>
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