package com.codingdojo.firstproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.Locale;  



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home() {
		return"index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		String pattern = "dd";
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("da", "DK"));
		String day = simpleDateFormat.format(new Date());
		Calendar c = Calendar.getInstance();
		String monthName=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
		
		String pattern2 = "yyyy";
		SimpleDateFormat simpleDateFormat2 =new SimpleDateFormat(pattern2, new Locale("da", "DK"));
		String year = simpleDateFormat2.format(new Date());
		String dayNames[] = new DateFormatSymbols().getWeekdays();
	    Calendar date2 = Calendar.getInstance();
	    String dayName=dayNames[date2.get(Calendar.DAY_OF_WEEK)];
		
		model.addAttribute("myDate", dayName+", the "+day+" of "+monthName+", "+year );
		return "index1.jsp";
	}
	
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date clock = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
		model.addAttribute("myTime",sdf.format(clock) );
		return "index2.jsp";
	}
}
