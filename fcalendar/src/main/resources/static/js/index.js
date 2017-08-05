jQuery(document).ready(function($){

	// page is now ready, initialize the calendar...
    $('#calendar').fullCalendar({
        // put your options and callbacks here
    	header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay,listWeek'
		},
		
		locale: 'zh-cn',
		
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
	        
	        var date = start.toDate();
	        while(date.getTime() <= end.toDate().getTime()){
	        	$.ajax({
		            url: '/lunarinfo',
		            dataType: 'json',
		            type: "POST",
		            contentType: "application/json",
		            data: JSON.stringify({
		                'targetDate': date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()
		            }),
		            success: function(lunarInfo) {
		                
		            },
		            error: function(data){
		            	alert("error when call /lunarinfo");
		            },
		            fail: function(data){
		            	alert("fail when call /lunarinfo");
		            }
		        });
	        	
	        	var d = date.getTime();
	        	d = d + 24 * 60 * 60 * 1000;
	        	date.setTime(d);
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

	    },
	    
	    dayRender: function( date, cell ) { 
		
        	$.ajax({
	            url: '/lunarinfo',
	            dataType: 'json',
	            type: "POST",
	            contentType: "application/json",
	            data: JSON.stringify({
	                'targetDate': date.year()+'-'+(date.month()+1)+'-'+date.date()
	            }),
	            success: function(lunarInfo) {
	            	$(cell).text(lunarInfo.ChineseDateString);
	            },
	            error: function(data){
	            	alert("error when call /lunarinfo");
	            },
	            fail: function(data){
	            	alert("fail when call /lunarinfo");
	            }
	        });
	        	
	    }
    })
})