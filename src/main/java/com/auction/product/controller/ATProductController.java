package com.auction.product.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

	@RequestMapping(value = "/ATProductInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<ATProductInfo> getATProductInfoList(@ModelAttribute ATProductInfo ATProductInfo) {
		return ATProductService.getATProductInfoList(ATProductInfo);
	}

	@RequestMapping(value = "/ATProductInfo/{ProductNumber}", method = RequestMethod.GET)
	@ResponseBody
	public ATProductInfo getATProductInfo(@PathVariable Integer ProductNumber) {
		return ATProductService.getATProductInfoList(ProductNumber);

	}

	@RequestMapping(value = "/ATProductInfo", method = RequestMethod.POST)
	@ResponseBody
	public Integer insertATProductInfo(@RequestBody ATProductInfo ATProductInfo) {
		return ATProductService.insertATProductInfo(ATProductInfo);
	}	

	@RequestMapping(value = "/ATProductInfo/{ProductNumber}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteATProductInfo(@PathVariable int ProductNumber) {
		return ATProductService.deleteATProductInfo(ProductNumber) + "";
	}

	@RequestMapping(value = "/ATProductInfo/{ProductNumber}", method = RequestMethod.PUT)
	@ResponseBody
	public Integer updateATProductInfo(@RequestBody ATProductInfo ATProductInfo, @PathVariable Integer ProductNumber) {
		ATProductInfo.setProductNumber(ProductNumber);
		return ATProductService.updateATProductInfo(ATProductInfo);
	}
	private static final int THRESHOLD_SIZE = 1024*1024*1;//1MB
	private static final int UP_TOTAL_SIZE = 1024*1024*200;//200MB
	private static final int UP_FILE_SIZE = 1024*1024*100;//100MB
	
	private static final File TEMP_REPOSITORY = new File(System.getProperty("java.io.tmpdir"));
	
	private static final String UP_PATH = "C:/Users/BaeJinseok/git/auction_product/src/main/resources/productImage";
	@RequestMapping(value="/uploadproduct", method=RequestMethod.POST)
	@ResponseBody
	public Integer test(HttpServletRequest request) {
		
		DiskFileItemFactory dfif = new DiskFileItemFactory(THRESHOLD_SIZE, TEMP_REPOSITORY);

		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setHeaderEncoding("utf-8");
		sfu.setSizeMax(UP_TOTAL_SIZE);
		sfu.setFileSizeMax(UP_FILE_SIZE);
		try {
			List<FileItem> fList = sfu.parseRequest(request);
			Map<String,String> params = new HashMap<String,String>();

			for(FileItem fi:fList) {
				if(fi.isFormField()) {
					params.put(fi.getFieldName(), fi.getString("utf-8"));
				} else {
					String fName = "/" + fi.getName();
					String fPath = UP_PATH + fName;
					
					if(fi.getName().equals("")) continue;
					
					File sFile = new File(fPath);
					
					fi.write(sFile);
					
					params.put(fi.getFieldName(), "/resources/upload" +fName);
				}
				
			}
			
			System.out.println(params);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("받아랏");
		return 1;
	}

}
