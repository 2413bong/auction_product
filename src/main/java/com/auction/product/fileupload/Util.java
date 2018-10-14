package com.auction.product.fileupload;

	import java.io.File;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;

	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.multipart.MultipartHttpServletRequest;

	public class Util {

		public static final String uploadPath = "C:\\java_study\\workspace\\auction_product\\src\\main\\webapp\\resources\\img\\";

		public static Map<String, Object> saveFile(MultipartHttpServletRequest request){
			Map<String, Object> map = new HashMap<String, Object>();
			
			Map<String, Object> data = request.getParameterMap();
			Iterator<String> it = data.keySet().iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				map.put(key, data.get(key));
			}
			
			Map<String, MultipartFile> files = request.getFileMap();
			it = request.getFileMap().keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				String fileName = files.get(key).getOriginalFilename();
				
				if(!fileName.equals("")) {
					String extensionName = fileName.substring(fileName.lastIndexOf("."));//확장자명 줄임
					String lastFileName = extensionName + System.currentTimeMillis() ;//이름+업로드시간
					File uploadFile = new File(uploadPath, lastFileName);
					
					try {
						files.get(key).transferTo(uploadFile);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
					map.put(key, lastFileName);
				}
			}
			
			System.out.println(map);
			return map;
		}
		
		public static void deleteFile(String filePath) {
			File file = new File(filePath);
			if(file.exists()){
				file.delete();
			}
			
		}
	}

