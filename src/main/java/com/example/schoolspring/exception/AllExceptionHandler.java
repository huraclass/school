package com.example.schoolspring.exception;

import com.example.schoolspring.util.CommonUtils;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpEntity<ErrorResponse> handlerBindingResultException(com.co.kr.exception.RequestException exception){

        // catch exception
        if(exception.getException() != null) {
            Exception ex = exception.getException();
            StackTraceElement [] steArr = ex.getStackTrace();
            for(StackTraceElement ste : steArr) {
                System.out.println(ste.toString());
            }
        }

        // response 담기
        ErrorResponse errRes = ErrorResponse.builder()
                .result(exception.getCode().getResult())
                .resultDesc(exception.getCode().getResultDesc())
                .resDate(CommonUtils.currentTime())
                .reqNo(exception.getReqNo())
                .httpStatus(exception.getHttpStatus())
                .build();

        return new ResponseEntity<ErrorResponse>(errRes, errRes.getHttpStatus());
    }


    //db error
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpEntity<ErrorResponse> handelerInternalServerError(InternalException exception) {
        System.out.println("=========Internal Error=========" + exception.getMessage());
        ErrorResponse errRes = ErrorResponse.builder()
                .result(exception.getCode().getResult())
                .resultDesc(exception.getCode().getResultDesc())
                .resDate(CommonUtils.currentTime())
                .reqNo(CommonUtils.currentTime())
                .build();
        return new ResponseEntity<ErrorResponse>(errRes, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // error page
    @ExceptionHandler(Exception.class)
    public ModelAndView commonException(Exception e) {
        e.getStackTrace();
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e.getStackTrace());
        mv.setViewName("commons/commonErr.html");
        return mv;
    }

}
