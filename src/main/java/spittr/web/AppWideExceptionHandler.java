package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spittr.exeptions.DuplicateReferenceException;

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(DuplicateReferenceException.class)
    public String duplicateSpittleHandler() {
        return "error/duplicate";
    }
}