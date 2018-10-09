package com.auction.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auction.product.service.ATProductService;
import com.auction.product.vo.ATProductInfo;


@Controller
public class ATProductController {
	@Autowired
	private ATProductService ATProductService;
	
	@RequestMapping(value = "/atproductinfo", method=RequestMethod.GET)
	@ResponseBody
	public List<ATProductInfo> getATProductInfoList(@ModelAttribute ATProductInfo ATProductInfo){
		return ATProductService.getATProductInfoList(ATProductInfo);
	}
	@RequestMapping(value="/ATProductInfo/{ProductNumber}",method=RequestMethod.GET)
	@ResponseBody
	public ATProductInfo getATProductInfo(@PathVariable Integer ProductNumber) {
		return ATProductService.getATProductInfoList(ProductNumber);
		
	}
	@RequestMapping(value="/ATProductInfo",method=RequestMethod.POST)
	@ResponseBody
	public Integer insertATProductInfo(@RequestBody ATProductInfo ATProductInfo) {
		return ATProductService.insertATProductInfo(ATProductInfo);
	}
	@RequestMapping(value="/ATProductInfo/{ProductNumber}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteATProductInfo(@PathVariable int ProductNumber) {
		return ATProductService.deleteATProductInfo(ProductNumber)+"";
	}
	
	@RequestMapping(value="/ATProductInfo/{ProductNumber}",method=RequestMethod.PUT)
	@ResponseBody 
	public Integer updateATProductInfo(@RequestBody ATProductInfo ATProductInfo,@PathVariable Integer ProductNumber) {
		ATProductInfo.setProductNumber(ProductNumber);
		return ATProductService.updateATProductInfo(ATProductInfo); 
	}
}
