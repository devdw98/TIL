package dw.study.springbootapi.controller.exception;

import dw.study.springbootapi.advice.exception.CAuthenticationEntryPointException;
import dw.study.springbootapi.model.response.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @GetMapping("/entrypoint")
    public CommonResult entrypointException(){
        throw new CAuthenticationEntryPointException();
    }

    @GetMapping("/accessdenied")
    public CommonResult accessdeniedException(){
         throw new AccessDeniedException("");
    }
}
