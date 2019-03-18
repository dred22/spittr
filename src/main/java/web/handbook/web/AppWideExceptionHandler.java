package web.handbook.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import web.handbook.exeptions.DuplicateReferenceException;

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(DuplicateReferenceException.class)
    public String duplicateSpittleHandler() {
        return "error/duplicate";
    }
}