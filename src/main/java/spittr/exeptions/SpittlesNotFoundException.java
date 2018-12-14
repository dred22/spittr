package spittr.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND,
        reason="Spittles list is empty!")
public class SpittlesNotFoundException extends RuntimeException {
}