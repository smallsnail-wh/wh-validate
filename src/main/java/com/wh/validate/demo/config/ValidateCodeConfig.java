package com.wh.validate.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wh.validate.demo.ImageCodeDefaultProperties;
import com.wh.validate.demo.ImageCodeGenertor;
import com.wh.validate.demo.ImageCodePropertiesConfigurer;
import com.wh.validate.demo.ImageCodePropertiesConfigurerAdapter;
import com.wh.validate.demo.ValidateCodeGenerator;

/**
 * 
 * @author wanghuan
 *
 */
@Configuration
public class ValidateCodeConfig {

	@Autowired
	private ImageCodeDefaultProperties imageCodeDefaultProperties;
	
	@Autowired
	private ImageCodePropertiesConfigurerAdapter imageCodePropertiesConfigurerAdapter;
	
	@Bean
	@ConditionalOnMissingBean(value=ImageCodePropertiesConfigurerAdapter.class)
	public ImageCodePropertiesConfigurerAdapter imageCodePropertiesConfigurer(){
		return new ImageCodePropertiesConfigurer();
	}
	
	@Bean
	@ConditionalOnMissingBean(value=ValidateCodeGenerator.class)
	public ValidateCodeGenerator imageCodeGenertor() {
		ImageCodeGenertor imageCodeGenertor = new ImageCodeGenertor();
		imageCodePropertiesConfigurerAdapter.imageCodePropertiesConfigure(imageCodeDefaultProperties);
		imageCodeGenertor.setImageCodeDefaultProperties(imageCodeDefaultProperties);
		return imageCodeGenertor;
	}
	
}
