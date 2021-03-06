package dw.study.springbootapi.advice;

import dw.study.springbootapi.advice.exception.*;
import dw.study.springbootapi.model.response.CommonResult;
import dw.study.springbootapi.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice //예외 발생 시 json 형태로 결과 반환
public class ExceptionAdvice { //특정 Exception 발생 시 공통으로 처리
    private final ResponseService responseService;
    private final MessageSource messageSource; //에러메세지를 messageSource 내용으로 교체

//    @ExceptionHandler(Exception.class) //exception 발생 시 해당 Handler로 처리 (exception class를 인자로 넣음)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 에러에 대한 처리
//    protected CommonResult defaultException(HttpServletRequest req, Exception e){
//        return responseService.getFailResult();
//    }

    @ExceptionHandler(Exception.class) //exception 발생 시 해당 Handler로 처리 (exception class를 인자로 넣음)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 에러에 대한 처리
    protected CommonResult defaultException(HttpServletRequest req, Exception e){
//        return responseService.getFailResult();
        return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")), getMessage("unKnown.msg")+"("+e.getMessage()+")");
    }

    @ExceptionHandler(CUserNotFoundException.class) //exception 발생 시 해당 Handler로 처리 (exception class를 인자로 넣음)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500 에러에 대한 처리
    protected CommonResult userNotFoundException(HttpServletRequest req, CUserNotFoundException e){
//        return responseService.getFailResult();
        return responseService.getFailResult(Integer.valueOf(getMessage("userNotFound.code")), getMessage("userNotFound.msg"));
    }

    @ExceptionHandler(CEmailSigninFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //로그인 관련 오류
    protected CommonResult emailSigninFailed(HttpServletRequest request, CEmailSigninFailedException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("emailSigninFailed.code")), getMessage("emailSigninFailed.msg"));
    }

    @ExceptionHandler(CAuthenticationEntryPointException.class)
    public CommonResult authenticationEntryPointException(HttpServletRequest request, CAuthenticationEntryPointException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("entryPointException.code")), getMessage("entryPointException.msg"));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public CommonResult AccessDeniedException(HttpServletRequest request, AccessDeniedException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("accessDenied.code")), getMessage("accessDenied.msg"));
    }

    @ExceptionHandler(CCommunicationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //소셜로그인 오류
    public CommonResult communicationException(HttpServletRequest request, CCommunicationException e){
        return responseService.getFailResult(Integer.valueOf(getMessage("communicationError.code")), getMessage("communicationError.msg"));
    }

    @ExceptionHandler(CUserExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //소셜로그인 오류
    public CommonResult userExistException(HttpServletRequest request, CCommunicationException e){
        return responseService.getFailResult(Integer.valueOf(getMessage("existingUser.code")), getMessage("existingUser.msg"));
    }

    //code 정보에 해당하는 메세지 조회
    private String getMessage(String code){
        return getMessage(code, null);
    }

    //code 정보, 추가 argument로 현재 locale에 맞는 메세지 조회
    private String getMessage(String code, Object[] args){
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }


}
