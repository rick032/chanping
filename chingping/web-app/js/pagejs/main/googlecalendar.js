$(document).ready(function() {
	$('#calendar').fullCalendar({
		header : {
			left : 'prev,next today',
			center : 'title',
			right : 'month,agendaWeek,agendaDay'
		},
		events : 'https://www.google.com/calendar/feeds/2daojhkof5g5l6inng7iep00nk%40group.calendar.google.com/private-52a71e4c989e615e73a47df71cfdf573/basic',
		eventClick : function(event) {			
			// opens events in a popup window
			window.open(event.url, 'gcalevent', 'width=700,height=600');
			return false;
		},

		loading : function(bool) {
			$('#loading').toggle(bool);
		}
	});
	
	
//	$.ajax({
//		type : "POST",
//		url : contextRoot + "/main/getCtm",
//		success : function(map) {
//			alert(map?map.ctmname:'');
//		}
//	});
});
