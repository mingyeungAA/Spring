package com.mvc.upgrade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.upgrade.dto.UploadFile;
import com.mvc.upgrade.validate.FileValidator;



@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		//bindingresult : 
		//파일,파일이름,파일설명 = uploadFile
		fileValidator.validate(uploadFile, result);
		
		if(result.hasErrors()) {
			return "upload";
		}
		
		MultipartFile file = uploadFile.getMpfile();
		String name = file.getOriginalFilename();  //파일 실제 이름(원본)
		
		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		//WebUtils : Session에 담겨있는 객체들을 보다 짧은 코드로 넣고 빼고 할 수 있으며, 세션 객체나 쿠키 객체를 받아올 수 있습니다.
		//getRealPath("/") : webapp 폴더 의미
		try {
			inputStream = file.getInputStream();
			//지금해당 프로젝트가 어딨냐(현재 프로젝트 경로)
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			
			System.out.println("업로드 될 실제 경로 : "+path);
			
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdir();  //mkdir : 새폴더 생성
			}
			
			//newFile : 
			File newFile = new File(path + "/" + name);
			if(!newFile.exists()) {
				newFile.createNewFile();  //새폴더 생성
			}
			
			
			//지금까지는 올린 파일이 0바이트임
			//서버에
			outputStream = new FileOutputStream(newFile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			//클라이언트에서 서버로 전달된 file값이 byte배열로 되어있는데, 하나씩 가져와서 read에다가 하나씩 대입(클라이언트의 파일을 서버로 복사)
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		byte[] down = null;
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			File file = new File(path + "/" + name);
			
			down = FileCopyUtils.copyToByteArray(file); //파일을 바이트배열로 바꾼다.
			String filename = new String(file.getName().getBytes(), "8859_1");
			
			//Content-Disposition 헤더를 이용해서 전송되는 파일의 이름을 명시
			//응답 본문을 브라우저가 어떻게 표시해야 할지 알려주는 헤더입니다. 
			//inline인 경우 웹페이지 화면에 표시되고, attachment인 경우 다운로드됩니다.
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return down;
	}
	
}
