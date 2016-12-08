package example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    private final HelloProperties greetings;

    @Autowired
    public Hello(HelloProperties greetings) {
        this.greetings = greetings;
    }

    @GetMapping("/hello")
    public String hello() {
        return String.format("Hello %s!", greetings.getDefaultName());
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return String.format("Hello %s!", name);
    }
}
