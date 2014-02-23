$(document).ready(function() {
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth() + 1;
	var y = date.getFullYear();

	var cal = $('#calendar').fullCalendar({
		header : {
			left : 'prev,next today',
			center : 'title',
			right : 'month,agendaWeek,agendaDay'
		},
		editable : false,
		weekMode : 'variable',		
		events : function(start, end, timezone, callback) {			
			$.ajax({
				url : contextRoot + "/main/getEvents",
				dataType : 'json',
				data : {
					start : start.format('YYYY,MM,DD'),
					end : end.format('YYYY,MM,DD')
				},
				success : function(doc) {
					var events = [];
					// $(doc).find('event').each(function() {
					$(doc).each(function() {
						events.push({
							id : $(this).attr('id'),
							title : $(this).attr('title'),
							start : new Date(Date.parse($(this).attr('start'))),
							allDay : true
						});
					});
					callback(events);
				}
			});
		},
		eventClick : function(event) {
			$.ajax({
				url : contextRoot + "/main/getEvent",
				type : "POST",
				data : {
					'tradeno' : event.id
				},
				success : function(res) {
					$("#eventdialog").fancybox({
						openMethod : 'zoomIn',
						afterLoad : function() {
						}
					}).open();
					$("#pclose1").click(function() {
						$.fancybox.close();
					});
				}
			});
		}
	});
});
