# wh-validate

### 项目介绍
此项目实现图片验证码的功能
### 使用方法
- 将com.wh.validate.demo包中的所有代码copy到你的项目，完成相关依赖的导入（可参考此项目本身）。
- 项目提供默认网址：/validate/image，来获取验证码图片。
- 实现ImageCodePropertiesConfigurerAdapter接口并注册为bean，配置需要验证的url，可配置多个。  
**注意**   验证请求中必须以 imageCode="XXXX"（XXXX为验证字符串），这样的参数形式传入。（若验证请求为post形式，数据格式必须为application/x-www-form-urlencoded）
```
@Component
public class ImageCodePropertiesConfigurerAdapterTemp implements ImageCodePropertiesConfigurerAdapter {

	@Override
	public void imageCodePropertiesConfigure(ImageCodeDefaultProperties imageCodeDefaultProperties) {
		imageCodeDefaultProperties.setUrl("/login","/logintest");
	}

}
```
-  如果验证错误会返回json
	{"error":403,"message":"验证码不匹配"}
### 自定义配置

 分两种情况：1.完全使用你自己的图片验证码样式。2，使用此项目图片验证样式，但是改变宽高，以及验证码字符数量和验证码过期时间。

如果完全使用你自己的图片验证码样式，你需要实现ValidateCodeGenerator并注册为bean。在createImageCode中返回ImageCode

```
@Component
public class ImageCodeGenertorTemp implements ValidateCodeGenerator {

	@Override
	public ImageCode createImageCode(HttpServletRequest req) throws IOException {
		//你生产的验证码图片
		BufferedImage image;
		//验证码图片对应的字符串
		String code;
		//过期时间（单位秒）
		int expireIn;
		
		ImageCode imageCode = new ImageCode(image,code,expireIn);
		return imageCode;
	}

}
```

如果使用此项目图片验证样式，但是改变宽高，以及验证码字符数量和验证码过期时间，你可以直接在实现ImageCodePropertiesConfigurerAdapter接口的那个类中，直接配置。

```
@Component
public class ImageCodePropertiesConfigurerAdapterTemp implements ImageCodePropertiesConfigurerAdapter {

	@Override
	public void imageCodePropertiesConfigure(ImageCodeDefaultProperties imageCodeDefaultProperties) {
		imageCodeDefaultProperties.setSize(5).setHeight(50).setWidth(200).setExpireIn(60).setUrl("/login","/logintest");
	}

}
```

