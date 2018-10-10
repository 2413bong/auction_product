package com.auction.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class URIController {
	
	@RequestMapping(value="/url/{path}",method=RequestMethod.GET)
	public String goPage(@PathVariable String path) {
		path = path.replace(":", "/");
		return path;
	} 
}
