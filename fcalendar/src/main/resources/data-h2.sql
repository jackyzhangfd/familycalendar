insert into event_series
(id)
values
(1);

insert into event
(id,start_time,end_time,event_series_id,name, detail)
values
(2,'2017-5-1 10:00:00','2017-5-1 11:00:00',1,'Dev. Team Meeting', 'Discuss how to develop RMV application' );

insert into event
(id,start_time,end_time,name, detail)
values
(3,'2017-6-25 10:00:00','2017-6-25 11:00:00','HR Meeting', 'some HR topics' );