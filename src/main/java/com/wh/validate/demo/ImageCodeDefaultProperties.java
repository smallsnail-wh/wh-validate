package com.wh.validate.demo;

import org.springframework.stereotype.Component;

/**
 * 
 * @author wanghuan
 *
 */
@Component
public final class ImageCodeDefaultProperties {

	private int width = 110;
	
	private int height = 32;
	
	private int size = 4;
	
	private int expireIn = 60;
	
	private String[] url = {};

	public int getWidth() {
		return width;
	}

	public ImageCodeDefaultProperties setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public ImageCodeDefaultProperties setHeight(int height) {
		this.height = height;
		return this;
	}

	public int getSize() {
		return size;
	}

	public ImageCodeDefaultProperties setSize(int size) {
		this.size = size;
		return this;
	}

	public int getExpireIn() {
		return expireIn;
	}

	public ImageCodeDefaultProperties setExpireIn(int expireIn) {
		this.expireIn = expireIn;
		return this;
	}

	public String[] getUrl() {
		return url;
	}

	public ImageCodeDefaultProperties setUrl(String... url) {
		this.url = url;
		return this;
	}

}
