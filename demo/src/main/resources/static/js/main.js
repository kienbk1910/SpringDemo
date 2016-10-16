function validateForm() {
	if($("#exampleInputName2").val() == ""){
		alert("Can't empty.");
		return false;
	}
	return true
}