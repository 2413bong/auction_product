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

import com.auction.product.service.BProductService;
import com.auction.product.vo.ATProductInfo;

@Controller
public class BProductController {

	@Autowired
	private BProductService BProductService;
	
	@RequestMapping(value = "/BProductInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<ATProductInfo> getBProductInfoList() {
		return BProductService.getBProductList(null);
	}
	@RequestMapping(value = "/BProductInfo/{ProductNumber}", method = RequestMethod.GET)
	@ResponseBody
	public ATProductInfo getBProductInfo(@PathVariable Integer ProductNumber) {
		return BProductService.getBProductInfo(ProductNumber);
	}
	@RequestMapping(value = "/BProductInfo/{ProductNumber}", method = RequestMethod.DELETE)
	@ResponseBody
	public Integer deleteBProductInfo(@PathVariable int ProductNumber) {
		return BProductService.deleteBProduct(ProductNumber);
	}
	@RequestMapping(value = "/BProductInfo/{ProductNumber}", method = RequestMethod.PUT)
	@ResponseBody
	public Integer updateBProductInfo(@RequestBody ATProductInfo ATProductInfo, @PathVariable int ProductNumber) {
		ATProductInfo.setProductNumber(ProductNumber);
		return BProductService.updateBProduct(ATProductInfo);
	}
	@RequestMapping(value = "/BProductInfo", method = RequestMethod.POST)
	@ResponseBody
	public Integer insertBProductInfo(@RequestBody ATProductInfo ATProductInfo) {
		return BProductService.insertBProduct(ATProductInfo);
	}
	
}
