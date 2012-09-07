<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top">
				<td>
					<table>
						<tr>
							<td><@show.label key="admin.login.label.usuario"/></td>
							<td><@show.inputText key="usuario.usuario" disabled="false" required="true" style="null" value="${usuario.usuario}" size="10" class="inputText" maxlength="20"/></td>
						</tr>
						<tr>
							<td><@show.label key="admin.login.label.password"/></td>
							<td><@show.inputPassword key="usuario.password" disabled="false" required="true" style="null" value="${usuario.password}" size="10" class="inputText" maxlength="20"/></td>
						</tr>
						<tr>
							<td colspan="2">
								<@show.button key="admin.login.button.ingresar" id="btnIngresar"/><br>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<@show.labelErrorField key="usuario.login"/>
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