<#ftl>
<#import "/common/showMacros.ftl" as show>
<@show.pageAdmin cssClass="clsBody">
	<form name="frmMain" id="frmMain" method="post">
		<table width="760" height="500" cellspacing="0" cellpadding="0" border="0">
			<tr valign="top" height="50">
				<td class="clsTitulo"><@show.label key="admin.menu.principal"/></td>
			</tr>
			<tr valign="top" height="450">
				<td class="menu">
					<ul>
						<@show.menuOption key="admin.menu.propiedades" id="btnPropiedades"/>
					</ul>
					<ul>
						<@show.menuOption key="admin.menu.propietarios" id="btnPropietarios"/>
					</ul>
				</td>
			</tr>				
		</table>
	</form>
</@show.pageAdmin>