package example.health;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static helpers.matchers.HealthCheckMatcher.healthy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DefaultHealthTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldBeHealthyAfterLaunch() throws Exception {
        JsonNode status = restTemplate
                .getForObject("/health", JsonNode.class);

        assertThat(status, is(healthy()));
    }

    @Test
    public void shouldIncludeDiskSpaceMetrics() throws Exception {
        JsonNode disk = restTemplate
                .getForObject("/health", JsonNode.class)
                .with("diskSpace");

        assertThat(disk, is(healthy()));
    }
}
