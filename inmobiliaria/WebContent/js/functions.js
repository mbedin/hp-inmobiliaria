function toggle(targetId, opc){ 
    document.all[targetId].style.display = opc;
}

function enabled(targetId, disabled){ 
	if(disabled == true) {
        ($(targetId)).attr('disabled','disabled');
    } else { 
        ($(targetId)).attr('disabled','');
    } 
}

function enabledInputText(targetId, disabled){ 
	if(disabled == true) {
        ($(targetId)).attr('disabled','disabled');
        ($(targetId)).attr('class',($(targetId)).attr('class') + 'Disabled');
    } else { 
        ($(targetId)).attr('disabled','');
        ($(targetId)).attr('class',($(targetId)).attr('class').replace (/Disabled/g, ''));
    } 
}

function enabledSelect(targetId, disabled){ 
	if(disabled == true) {
        ($(targetId)).attr('disabled','disabled');
    } else { 
        ($(targetId)).attr('disabled','');
    } 
}

function enabledCheck(targetId, disabled){ 
	if(disabled == true) {
        ($(targetId)).attr('disabled','disabled');
    } else { 
        ($(targetId)).attr('disabled','');
    } 
}

function enabledLink(targetId, disabled){ 
	if(disabled == true) {
        ($(targetId)).attr('disabled','disabled');
    } else { 
        ($(targetId)).attr('disabled','');
    } 
}

function cleanSelect(targetId){ 
	($(targetId)).val('-1');
}

function cleanText(targetId){ 
	($(targetId)).val('');
}

function cleanCheck(targetId){ 
	($(targetId)).removeAttr("checked");
}
