package dw.study.springbootapi.advice;

import dw.study.springbootapi.advice.exception.CUserNotFoundException;
import dw.study.springbootapi.model.response.CommonResult;
import dw.study.springbootapi.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice //예외 발생 시 json 형태로 결과 반환
public class ExceptionAdvice { //특정 Exception 발생 시 공통으로 처리
    private final ResponseService responseService;

//    @ExceptionHandler(Exception.class) //exception 발생 시 해당 Handler로 처리 (exception class를 인자로 넣음)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 에러에 대한 처리
//    protected CommonResult defaultException(HttpServletRequest req, Exception e){
//        return responseService.getFailResult();
//    }

    @ExceptionHandler(CUserNotFoundException.class) //exception 발생 시 해당 Handler로 처리 (exception class를 인자로 넣음)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 에러에 대한 처리
    protected CommonResult defaultException(HttpServletRequest req, Exception e){
        return responseService.getFailResult();
    }

}
