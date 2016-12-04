package example;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static helpers.matchers.HealthCheckMatcher.healthy;
import static helpers.matchers.JsonNodeMatcher.missing;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"spring.profiles.active=production"})
@RunWith(SpringRunner.class)
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class ProductionHealthTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldBeHealthyAfterLaunch() throws Exception {
        JsonNode status = restTemplate
                .getForObject("/health", JsonNode.class);

        assertThat(status, is(healthy()));
    }

    @Test
    public void shouldNotIncludeDiskSpaceMetricsInUnauthenticatedRequests() throws Exception {
        JsonNode status = restTemplate
                .getForObject("/health", JsonNode.class);

        assertThat(status, is(missing("diskSpace")));
    }
}
