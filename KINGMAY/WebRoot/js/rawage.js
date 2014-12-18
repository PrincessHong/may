$(document).ready(function (){
	var s = $('input[type=text]');
	for (var i = 0; i < s.length; i++) {
		var single = s[i];
		if(single.value == '-1') {
			single.setAttribute('value','无效');
		}
	}
});