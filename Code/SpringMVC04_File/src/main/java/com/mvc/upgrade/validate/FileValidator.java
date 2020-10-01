package com.mvc.upgrade.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.upgrade.dto.UploadFile;

@Service
public class FileValidator implements Validator {  //파일 유효성 검사 클래스

	@Override
	public boolean supports(Class<?> clazz) {
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Errors errors : (=)BindingResult
		UploadFile file = (UploadFile) target;
		
		if(file.getMpfile().getSize() == 0) { 
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}

	}

}
