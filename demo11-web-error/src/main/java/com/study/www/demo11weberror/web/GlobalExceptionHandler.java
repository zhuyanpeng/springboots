package com.study.www.demo11weberror.web;

import com.study.www.demo11weberror.dto.ErrorInfo;
import com.study.www.demo11weberror.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述: 全局异常处理类
 *
 * @outhor Administrator
 * @create 2017-10-08 15:25
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERRR_VIEW="error";
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException e){
        ErrorInfo<String> stringErrorInfo = new ErrorInfo<>();
        stringErrorInfo.setMessage(e.getMessage());
        stringErrorInfo.setCode(ErrorInfo.ERROR);
        stringErrorInfo.setUrl(request.getRequestURI().toString());
        stringErrorInfo.setData("some data");
        return stringErrorInfo;
    }
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e.getMessage());
        modelAndView.addObject("url",request.getRequestURI());
        modelAndView.setViewName(DEFAULT_ERRR_VIEW);
        return modelAndView;
    }

}
