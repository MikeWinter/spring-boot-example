package example.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class HelloTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnHelloWorldWhenNoNameIsGiven() throws Exception {
        String message = restTemplate
                .getForObject("/hello", String.class);

        assertThat(message, is("Hello World!"));
    }

    @Test
    public void shouldGreetTheNamedCaller() throws Exception {
        String message = restTemplate
                .getForObject("/hello/{name}", String.class, "Jill");

        assertThat(message, is("Hello Jill!"));
    }
}
