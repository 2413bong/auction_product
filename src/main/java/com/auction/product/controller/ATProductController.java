/*package com.auction.product.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
//업로드
	@RequestMapping(value = "/ajaxUpload")
	public String ajaxUpload() {
		return "ajaxUpload";
	}

	@RequestMapping(value = "/fileUpload")
	public String fileUp(MultipartHttpServletRequest multi) {

		// 저장 경로 설정
		String root = multi.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/img/";

		String newFileName = ""; // 업로드 되는 파일명

		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		Iterator<String> files = multi.getFileNames();
		while (files.hasNext()) {
			String uploadFile = files.next();

			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			System.out.println("실제 파일 이름 : " + fileName);
			newFileName = System.currentTimeMillis() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);

			try {
				mFile.transferTo(new File(path + newFileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("id : " + multi.getParameter("id"));
		System.out.println("pw : " + multi.getParameter("pw"));

		return "ajaxUpload";
	}
	//업로드
}
*/