package com.easyget.configuration;

import com.easyget.enums.ApiErrorCodeEnum;
import com.easyget.view.result.ResponseData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一处理返回值
 */
@ControllerAdvice(basePackages = "com.easyget")
public class VoidResponseBodyAdvice implements ResponseBodyAdvice<Object> {

	/**
	 * 返回空值时，添加返回应答码等信息
	 * @param body
	 * @param returnType
	 * @param selectedContentType
	 * @param selectedConverterType
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
		if( body == null )
		{
			body = new ResponseData(ApiErrorCodeEnum.SUCCESS,null);
		}
		return body;
	}
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

}
