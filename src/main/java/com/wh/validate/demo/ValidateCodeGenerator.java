package com.wh.validate.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author wanghuan
 *
 */
public interface ValidateCodeGenerator {
	ImageCode createImageCode(HttpServletRequest req) throws IOException;
}
