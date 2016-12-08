package example.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@RunWith(SpringRunner.class)
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class HelloPropertiesTest {
    @Autowired
    private HelloProperties properties;

    @Test
    public void shouldHaveDefaultNameValue() throws Exception {
        assertThat(properties.getDefaultName(), is("World"));
    }
}
