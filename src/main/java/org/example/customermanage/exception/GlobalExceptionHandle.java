package org.example.customermanage.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showErrorPage(){
        System.err.println("Have error");
        return  new ModelAndView("user/error");
    }
}
