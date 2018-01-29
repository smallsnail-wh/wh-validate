package com.wh.validate.demo.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wh.validate.demo.ImageCode;
import com.wh.validate.demo.ValidateCodeGenerator;

/**
 * 
 * @author wanghuan
 *
 */
@RestController
@RequestMapping("/validate")
public class ValidateCodeController {
	
	@Autowired
	private ValidateCodeGenerator validateCodeGenerator;
	
	public static final String SESSION_KEY = "SESSION_KEY_VALIDATE_IMAGE";


	@GetMapping("/image")
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ImageCode imageCode = validateCodeGenerator.createImageCode(request);
		request.getSession().setAttribute(SESSION_KEY, imageCode);
		ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
	}
}
