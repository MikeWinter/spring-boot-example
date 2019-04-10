package example.bogus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bogus {
    @GetMapping("/bogus")
    public String bogus() {
        throw new BogusRequestException();
    }

    // Exception handlers can also be embedded within the controller
    // instead of a separate class:
    //
    // @ExceptionHandler(BogusRequestException.class)
    @ResponseBody
    public String bogusRequest() {
        return "That was a bogus request!";
    }
}
