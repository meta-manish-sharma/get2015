function display(val) {
	if(val=="Show") {
		document.getElementById("button").value="Hidden";
		document.getElementById("span").style.display="inline";	
	}
	else {
		document.getElementById("button").value="Show";
		document.getElementById("span").style.display="none";	
	}
}