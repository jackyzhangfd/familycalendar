package com.autobusi.fcalendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {
	
	@RequestMapping(value="/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/lunarinfo", headers = "Content-Type=application/json")
	public Map lunnarInfoOfDate(@RequestBody String date){
		System.out.println(date);
	
		Map lunarInfo = new HashMap<String, Object>();
		lunarInfo.put("isFestival", true);
		lunarInfo.put("festivalName", "Lunar Test Festival");
		return lunarInfo;
	}
}
