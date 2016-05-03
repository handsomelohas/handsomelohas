package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("Hello springMVC");
		String hello = "Hello Lohas";
		
		Map<String , Object> map = new HashMap<String , Object>();
		map.put("map1", "First kill");
		map.put("map2", "doube kill");
		map.put("map3", "legendary");
		return new ModelAndView("/welcome" , "map" , map);
	}

}
