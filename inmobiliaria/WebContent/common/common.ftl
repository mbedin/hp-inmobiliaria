<#assign s=JspTaglibs["/META-INF/struts-tags.tld"]><#t/>

<#-- --------------------------------------------------- -->
<#-- --------------------------------------------------- -->
<#-- --------------------------------------------------- -->
<#-- --------------------------------------------------- -->

<#macro FillEmptyCells Max Count>	

	<#assign first = Count />
	<#assign last = (Max - 1) />
	
	<#if (first <= last )>
		<#list first..last as i>
			<td width="225">&nbsp;</td>
		</#list>		
	</#if>

</#macro>


<#macro getProperties key>
	<@s.text name=key />
</#macro>


<#macro inputText_old key disabled="false" required="false" style="null" value="" size="" class="null" maxlength="null">
		<input type="text" id="${key}" name="${key}" 
			<#if (disabled != "false")>disabled</#if>
			<#if (style!="null")> style="${style}" </#if>
			<#if (class!="null")> class="${class}" </#if>
			<#if (required=="true")>required="true"</#if>
			<#if (value != "")>value="${value}"</#if>
			<#if (size != "")>size="${size}"</#if>
			<#if (maxlength != "")>maxlength="${maxlength}"</#if>>
			<#if (submitted && fieldErrors?keys?seq_contains(key))><br><span class="showFormFieldError">${fieldErrors[key][0]}</span></#if>
</#macro>


<#macro submitButton text cssClass onclick="null">
    <button type=submit
         <#if (onclick!="null")>onclick="${onclick}"</#if>
         <#if (cssClass!="null")>class="${cssClass}"</#if>><@s.text name=text /></button>
</#macro>


<#macro invtrButtonNormal id text cssClass="null" onclick="null">
    <button id="${id}"
         <#if (onclick!="null")>onclick="${onclick}"</#if>
         <#if (cssClass!="null")>class="${cssClass}"</#if>><@s.text name=text /></button>
</#macro>


<#macro invtrCalendar key trigger size="">
	<input type="text" id="${key}" name="${key}" 
		<#if ((key?eval)??)>value="${key?eval?date}"</#if> 
		<#if (size != "")>size="${size}"</#if> 
		readonly="true"/>    
	<img class="imgcalendar" id="${trigger}" name="${trigger}"/>
	<#if (submitted && fieldErrors?keys?seq_contains(key))><br><span class="showFormFieldError">${fieldErrors[key][0]}</span></#if>
</#macro>

<#macro invtrCalendarValue key trigger size="" value="">
	<input type="text" id="${key}" name="${key}" 
		<#if (value!= "")>value="${value}"</#if> 
		<#if (size != "")>size="${size}"</#if> 
		readonly="true"/>    
	<img class="imgcalendar" id="${trigger}" name="${trigger}"/>
	<#if (submitted && fieldErrors?keys?seq_contains(key))><br><span class="showFormFieldError">${fieldErrors[key][0]}</span></#if>
</#macro>

<#macro invtrError key>
	<#if (submitted && fieldErrors?keys?seq_contains(key))><span class="showFormFieldError">${fieldErrors[key][0]}</span></#if>
</#macro>

<#macro invtrError2 key>
	<#if (submitted && fieldErrors?keys?seq_contains(key))><br><span class="showFormFieldError">&nbsp;${fieldErrors[key][0]}</span></#if>
</#macro>

<#macro invtrError3 key>
	<#if (fieldErrors?keys?seq_contains(key))><br><span class="showFormFieldError">${fieldErrors[key][0]}</span></#if>
</#macro>


<#macro invtrButton key id arrowLeft="0" arrowRight="0">
	<table border="0" cellpadding="0" cellspacing="0" style="cursor:pointer;" id="${id}">
		<tr>
			<td><#if (arrowLeft=="0")><img src="img/im_boton_1.gif" width="19" height="30" alt="" border="0"><#else><img src="img/im_boton_1B.gif" width="29" height="30" alt="" border="0"></#if></td>
			<td class="txTahomaBlc16" background="img/bg_boton.gif" align="center" valign="middle" nowrap><label style="cursor:pointer;"><@s.property value="getText('${key}')" /></label></td>
			<td><#if (arrowRight=="0")><img src="img/im_boton_2B.gif" width="19" height="30" alt="" border="0"><#else><img src="img/im_boton_2.gif" width="29" height="30" alt="" border="0"></#if></td>
		</tr>
	</table>
</#macro>

<#macro selectDay id name value="1" cssClass="null" disabled=false selectText="DD">
    <select id="${id}" name="${name}"
    	<#if (disabled)>disabled</#if>
    	<#if (cssClass!="null")>class="${cssClass}"</#if> >
    		<option value="-1">${selectText}</option>
			<#assign x=31>    		
			<#list 1..x as i>
				<option value="${i}" <#if (value == i?c?string)>selected</#if>>${i}</option>
			</#list>
	</select>
</#macro>

<#macro selectMonth id name value="1" cssClass="null" disabled=false selectText="MM">
    <select id="${id}" name="${name}"
    	<#if (disabled)>disabled</#if>
    	<#if (cssClass!="null")>class="${cssClass}"</#if> >
    		<option value="-1">${selectText}</option>
			<#assign x=12>    		
			<#list 1..x as i>
				<option value="${i}" <#if (value == i?string)>selected</#if>>${i}</option>
			</#list>
	</select>
</#macro>

<#macro selectYear id name value="1" cssClass="null" disabled=false min="1900" max="0" selectText="YYYY">
    <#assign maxim = max>
    <#if (maxim=="0")>
    	<#assign maxim=currentDate?date?string('yyyy')>
    </#if>
    <select id="${id}" name="${name}"
    	<#if (disabled)>disabled</#if>
    	<#if (cssClass!="null")>class="${cssClass}"</#if> >
    		<option value="-1">${selectText}</option>
			<#list min?number..maxim?number as i>
				<option value="${i?c}" <#if (value == i?c?string)>selected</#if>>${i?c}</option>
			</#list>
	</select>
</#macro>


<#macro invtrLabel key cssClass="null" align="null">
<label 
	<#if (cssClass != "null") >class="${cssClass}" </#if>
	<#if (align != "null") >align="${align}" </#if>><@s.property value="getText('${key}')" /></label>
</#macro>

