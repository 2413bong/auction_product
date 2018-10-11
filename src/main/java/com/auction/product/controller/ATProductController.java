/*package com.auction.product.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.auction.product.service.ATProductService;
import com.auction.product.util.MediaUtils;
import com.auction.product.util.UploadFileUtils;
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
	
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String uploadAjax(MultipartFile file, String str, HttpSession session,
			HttpServletRequest request, Model model) throws Exception {

		Logger.info("originalName: " + file.getOriginalFilename());

			ResponseEntity<String> img_path = new ResponseEntity<>(
					UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
					HttpStatus.CREATED);
			String user_imgPath = (String) img_path.getBody();

			logger.info(user_imgPath);
			UserVO vo = new UserVO();
			vo.setUser_profileImagePath(user_imgPath);
			UserVO id = (UserVO) session.getAttribute("login");
			System.out.println(id.getUser_id());
			vo.setUser_id(id.getUser_id());
			logger.info("file name : " + user_imgPath);

			return user_imgPath;
	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME: " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {

		logger.info("delete file: " + fileName);

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {

			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}
*/