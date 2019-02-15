package com.easyget.configuration;

import com.easyget.enums.ApiErrorCodeEnum;
import com.easyget.view.result.ResponseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 统一返回类型
 */
@Component
public class RespMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
	
	private String pattern;
	
	private AntPathMatcher antPathMatcher =  null;

	@Value("${server.context-path}")
	public void setPattern(String adminPath) {
		pattern = "/"+adminPath+"/**";
		antPathMatcher = new AntPathMatcher();
	}

	@Override
	protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
		String uri = request.getServletPath();
		if( antPathMatcher.match(pattern, uri) && (!(object instanceof ResponseData)) )
		{
			ResponseData rs = new ResponseData(ApiErrorCodeEnum.SUCCESS, object);
			super.writeInternal(rs, ResponseData.class, outputMessage);
			return;
		}
		super.writeInternal(object, type, outputMessage);
	}
}
