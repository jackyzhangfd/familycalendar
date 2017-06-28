jQuery(document).ready(function($){

	// page is now ready, initialize the calendar...
    $('#calendar').fullCalendar({
        // put your options and callbacks here
    	header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay,listWeek'
		},
		
		events: function(start, end, timezone, callback) {
	        $.ajax({
	            url: '/events',
	            dataType: 'json',
	            data: {
	                // our hypothetical feed requires UNIX timestamps
	                start: start.unix(),
	                end: end.unix()
	            },
	            success: function(doc) {
	                var events = [];
	                $(doc._embedded.events).each(function() {
	                    events.push({
	                        title: $(this).attr('name'),
	                        start: $(this).attr('startTime'),
							end: $(this).attr('endTime'),
							
							eventDetail: $(this).attr('detail')
	                    });
	                });
	                callback(events);
	            }
	        });
	        
	        var date = start;
	        while(date <= end){
	        	$.ajax({
		            url: '/lunarinfo',
		            dataType: 'json',
		            type: "POST",
		            contentType: "application/json",
		            data: {
		                'targetDate': "'" + date.calendar() + "'"
		            },
		            success: function(lunarInfo) {
		                alert(lunarInfo);
		            },
		            error: function(data){
		            	alert(data);
		            },
		            fail: function(data){
		            	alert(data);
		            }
		        });
	        	
	        	date = date.valueOf();
	        	date = date + 24 * 60 * 60 * 1000;
	        	date = new moment(date);
	        }
	    },
	    
	    lazyFetching: true,
	    theme: true,
	    
	    eventClick: function(calEvent, jsEvent, view) {

	        alert('Event: ' + calEvent.title);
	        alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
	        alert('View: ' + view.name);

	        // change the border color just for fun
	        $(this).css('border-color', 'red');

	    }
    })
})