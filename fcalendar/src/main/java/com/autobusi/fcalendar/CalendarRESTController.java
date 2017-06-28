package com.autobusi.fcalendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarRESTController {
	
	@RequestMapping(value="/lunarinfo")
	public Map lunnarInfoOfDate(@RequestBody Object data){
		System.out.println(data);
	
		Map lunarInfo = new HashMap<String, Object>();
		lunarInfo.put("isFestival", true);
		lunarInfo.put("festivalName", "Lunar Test Festival");
		return lunarInfo;
	}
}
