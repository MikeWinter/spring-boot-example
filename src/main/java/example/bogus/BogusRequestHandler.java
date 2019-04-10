package example.bogus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BogusRequestHandler {
    @ExceptionHandler(BogusRequestException.class)
    @ResponseBody
    public String bogusRequest() {
        return "That was a bogus request!";
    }
}
