<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td colspan="2" class="clsTitulo"><@show.label key="admin.tarjetasProductor.titulo"/><br><br></td>
			</tr>
			<tr>
				<td colspan="2" class="txTahomaNgr10">
					<@show.label key="admin.tarjetasProductor.tarjetas"/>:&nbsp;
					<@show.inputText key="cantidad" disabled="false" required="true" style="null" value="${cantidad}" size="10" class="inputText" maxlength="2"/><br><br>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table class="clsLista">
						<tr>
							<td>&nbsp;</td>
							<td><@show.label key="admin.tarjetasProductor.cliente.nombre"/></td>
						</tr>
						<#list clientes as cliente>
							<tr>
								<td><@show.checkbox name="idCliente" id="idCliente${cliente.id?c}" value="${cliente.id?c}" disabled=false/></td>
								<td align="left">${cliente.nombreYApellido}</td>
							</tr>
						</#list>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table class="clsBotonera">
						<tr>
							<td><@show.button key="admin.tarjetasProductor.button.generar" id="btnGenerar"/></td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td><@show.button key="admin.menu.principal" id="btnMenu"/></td>
						</tr>
					</table>
				</td>
			</tr>
			
		</table>
	</form>
</@show.pageAdmin>