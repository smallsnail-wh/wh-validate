package com.wh.validate.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


public class ImageCodeGenertor implements ValidateCodeGenerator {

	private ImageCodeDefaultProperties imageCodeDefaultProperties;
	
	@Override
	public ImageCode createImageCode(HttpServletRequest req) throws IOException {
		int width = imageCodeDefaultProperties.getWidth();
		int height = imageCodeDefaultProperties.getHeight();
		int size = imageCodeDefaultProperties.getSize();
		int expireIn = imageCodeDefaultProperties.getExpireIn();
		return VerifyCodeUtils.outputVerifyImage(width,height,size,expireIn);
	}

	public ImageCodeDefaultProperties getImageCodeDefaultProperties() {
		return imageCodeDefaultProperties;
	}

	public void setImageCodeDefaultProperties(ImageCodeDefaultProperties imageCodeDefaultProperties) {
		this.imageCodeDefaultProperties = imageCodeDefaultProperties;
	}

	


}
