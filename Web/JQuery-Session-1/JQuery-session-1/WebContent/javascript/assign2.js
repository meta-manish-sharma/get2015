
$(document).ready(function() {
	$('#button').click(function() {

		showHide();

	});
});

function showHide() {
	if ($('#span').is(":visible")) {

		$('#button').val('Show');
	} else {
		$('#button').val('Hidden');
	}
	$('#span').toggle();
}
