<#assign s=JspTaglibs["/META-INF/struts-tags.tld"]><#t/>

<#-- Macro para pagina completa Admin-->
<#macro pageAdmin cssClass="null"><#t />
	<@compress>
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>
			<head>
			  	<@page_header/>
			</head>
			<body <#if (cssClass != "null")>class="${cssClass}"</#if> >
				<center>	
					<table width="760" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<#include "/admin/header.ftl" />
							</td>
						</tr>
						<tr>
							<td>
								<#nested />
							</td>
						</tr>
						<tr>
							<td>
								<#include "/admin/footer.ftl" />
							</td>
						</tr>			
					</table>
				</center>		
			</body>
		</html>
	</@compress>
</#macro>

<#-- Macro para pagina completa Public-->
<#macro page cssClass="null" image="null"><#t />
	<@compress>
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<html>
			<head>
			  	<@page_header/>
			  	<#if (image != "null")>
					<script language="javascript">
	    				var imagen1 = new Image();
	    				imagen1.src = "${image}";
					</script>			  	
			  	</#if>			  	
			</head>
			<body <#if (cssClass != "null")>class="${cssClass}"</#if> >
				<center>	
					<#nested />
				</center>		
			</body>
		</html>
	</@compress>
</#macro>

<#macro page_header >
	<!-- Header -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Language" Content="es">
	   
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate, proxy-revalidate">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
	

	<title><@show.labelOnly key="general.empresa"/> - <@show.labelOnly key="general.aplicacion"/></title>

	<LINK REL="shortcut icon" href="img/favicon.ico">
	<link rel="STYLESHEET" type="text/css" href="css/common.css">

	<#list stylesheets as stylesheet>
		<link rel="STYLESHEET" type="text/css" href="${stylesheet}">
	</#list>

	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/jquery.i18n.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
	
	<#list scripts as script>
		<script src="${script}" type="text/javascript"></script>
	</#list>

</#macro>

<#macro label key cssClass="null" align="null">
	<label 
		<#if (cssClass != "null") >class="${cssClass}" </#if>
		<#if (align != "null") >align="${align}" </#if>><@s.property value="getText('${key}')" />
	</label>
</#macro>

<#macro labelOnly key >
	<@s.property value="getText('${key}')" />
</#macro>

<#macro button key id >
	<a href="#" id="${id}" class="eButton"><@s.property value="getText('${key}')" /></a>
</#macro>

<#macro menuOption key id class="null">
	<li><a href="#" id="${id}" <#if (class!="null")> class="${class}" </#if>><@s.property value="getText('${key}')" /></a></li>
</#macro>

						
<#macro inputText key name="null" disabled="false" required="false" style="null" value="" size="" class="null" maxlength="null"> 
		<#if (name!="null")> 
			<input type="text" id="${key}" name="${name}" 
		<#else> 
			<input type="text" id="${key}" name="${key}" 
		</#if> 
		<#if (disabled != "false")>disabled</#if> 
		<#if (style!="null")> style="${style}" </#if> 
		<#if (class!="null")> class="${class}" </#if> 
		<#if (required=="true")>required="true"</#if> 
		<#if (value != "")>value="${value}"</#if> 
		<#if (size != "")>size="${size}"</#if> 
		<#if (maxlength != "")>maxlength="${maxlength}"</#if>> 
</#macro>

<#macro inputPassword key name="null" disabled="false" required="false" style="null" value="" size="" class="null" maxlength="null"> 
		<#if (name!="null")> 
			<input type="password" id="${key}" name="${name}" 
		<#else> 
			<input type="password" id="${key}" name="${key}" 
		</#if> 
		<#if (disabled != "false")>disabled</#if> 
		<#if (style!="null")> style="${style}" </#if> 
		<#if (class!="null")> class="${class}" </#if> 
		<#if (required=="true")>required="true"</#if> 
		<#if (value != "")>value="${value}"</#if> 
		<#if (size != "")>size="${size}"</#if> 
		<#if (maxlength != "")>maxlength="${maxlength}"</#if>> 
</#macro>

<#macro actionErrorsShow>
	<div>
	    <#list actionErrors as aError>
        	<span class="showErrorText">${aError}</span>
    	</#list>
	</div>
</#macro>

<#macro labelErrorField key>
	<#if (fieldErrors?keys?seq_contains(key))><span class="showFormFieldError">${fieldErrors[key][0]}</span></#if>
</#macro>

<#macro labelErrorVirtualField key>
	<#if (fieldErrors?keys?seq_contains(key))><span class="showFormFieldError">${fieldErrors[key][0]}</span></#if>
</#macro>

<#macro hidden name value>
    <input type="hidden" name="${name}" id="${name}" value="${value}" />
</#macro>

<#macro checkbox name id value disabled=false cssClass="null" onclick="null">
        <input type="checkbox" name="${name}" id="${id}" value="${value}"
            <#if (disabled)>disabled</#if>
            <#if (onclick!="null")>onclick="${onclick}"</#if>
            <#if ( (name?eval)?? && name?eval == true )>checked="checked"</#if>
            <#if (cssClass!="null")>class="${cssClass}"</#if>>
</#macro>

<#macro checkboxEspecial name id value disabled="false" cssClass="null" onclick="null" checked="false">
        <input type="checkbox" name="${name}" id="${id}" value="${value}"
            <#if (disabled=="true")>disabled</#if>
            <#if (onclick!="null")>onclick="${onclick}"</#if>
            <#if (checked=="true")>checked="checked"</#if>
            <#if (cssClass!="null")>class="${cssClass}"</#if>>
</#macro>

<#macro radioButton name id value cssClass="null" disabled=false checked="false" onclick="null">
        <input type="radio"  id="${id}" name="${name}" value="${value}" 
            <#if (onclick!="null")>onclick="${onclick}"</#if>
            <#if (cssClass!="null")>class="${cssClass}"</#if>
            <#if (disabled)>disabled</#if>
            <#if (checked=="true")>checked="checked"</#if>>
</#macro>

<#-- --------------------------------------------------- -->
<#-- --------------------------------------------------- -->
<#-- --------------------------------------------------- -->
<#-- --------------------------------------------------- -->

