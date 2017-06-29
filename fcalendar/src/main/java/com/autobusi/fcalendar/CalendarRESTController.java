package com.autobusi.fcalendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobusi.fcalendar.util.LunarCalendar;

@RestController
public class CalendarRESTController {
	
	@RequestMapping(value="/lunarinfo")
	public Map lunnarInfoOfDate(@RequestBody Object data){
		System.out.println(data);
		
		Map targetDateMap = (Map)data;
		Date targetDate = null;
		if(targetDateMap != null && targetDateMap.get("targetDate") != null){
			String targetDateString = (String)targetDateMap.get("targetDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try{
				targetDate = sdf.parse(targetDateString);
			}catch (Exception ex){
				return null;
			}
		}
		
		LunarCalendar lc = new LunarCalendar(targetDate);
		
		Map lunarInfo = new HashMap<String, Object>();
		lunarInfo.put("isFestival", true);
		lunarInfo.put("ChineseDateString", lc.toString());
		return lunarInfo;
	}
}
