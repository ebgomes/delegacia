function handleLoginRequest(xhr, status, args) {
	/*alert("HERE!");*/
	if (args.validationFailed || !args.loggedIn) {
		PF('dlg').jq.effect("shake", {
			times : 5
		}, 100);
	} else {
		PF('dlg').hide();
		$('#loginLink').fadeOut();
	}
}

function handleValidator(xhr, status, args, dialogId) {
	if (args.validationFailed) {		
		$('#' + dialogId).effect("shake", {
			times : 2
		}, 100);
	}
	
}

