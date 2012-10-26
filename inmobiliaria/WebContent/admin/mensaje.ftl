<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<@show.hidden name="hdnRetorno" value="${retorno}" />
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table border="0">
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2"><b>${mensaje}</b><br><br></td>
						</tr>
						<tr>
							<td colspan="2">
								<@show.button key="admin.mensaje.button.continuar" id="btnVolver"/><br>
							</td>
						</tr>
					</table>
				</td>
			</tr>					
		</table>
	</form>
</@show.pageAdmin>