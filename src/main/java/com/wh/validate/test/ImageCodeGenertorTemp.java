/*package com.wh.validate.test;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.wh.validate.demo.ImageCode;
import com.wh.validate.demo.ValidateCodeGenerator;
import com.wh.validate.demo.VerifyCodeUtils;

@Component
public class ImageCodeGenertorTemp implements ValidateCodeGenerator {

	@Override
	public ImageCode createImageCode(HttpServletRequest req) throws IOException {
		int width = 110;
		int height = 50;
		int size = 4;
		int expireIn = 60;
		return VerifyCodeUtils.outputVerifyImage(width, height, size, expireIn);
	}

}
*/