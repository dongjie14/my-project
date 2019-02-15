package com.easyget.handler;

import com.easyget.enums.ApiErrorCodeEnum;
import com.easyget.view.result.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class AppExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 实现restful风格时，使用以下方式处理返回报文
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class, BindException.class})
    public ResponseEntity handleParameterException(Exception exception){
        logger.error("非法参数异常",exception);
        return new ResponseEntity(new ResponseData(ApiErrorCodeEnum.INVALID_PARAMETER, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity handleCommonException(Exception exception){
        logger.error("未知异常",exception);
        return new ResponseEntity(new ResponseData(ApiErrorCodeEnum.UNKOWN_ERROR, null),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
