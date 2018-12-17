package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spittr.exeptions.DuplicateSpittleException;

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(DuplicateSpittleException.class)
    public String duplicateSpittleHandler() {
        return "error/duplicate";
    }
}