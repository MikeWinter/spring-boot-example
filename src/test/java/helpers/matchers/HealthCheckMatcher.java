package helpers.matchers;

import com.fasterxml.jackson.databind.JsonNode;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HealthCheckMatcher {
    public static Matcher<JsonNode> healthy() {
        return new TypeSafeMatcher<JsonNode>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("healthy");
            }

            @Override
            protected void describeMismatchSafely(JsonNode item, Description mismatchDescription) {
                if (!item.has("status")) {
                    mismatchDescription.appendText("missing a status");
                } else {
                    mismatchDescription.appendText("status was");
                    mismatchDescription.appendValue(item.get("status").textValue());
                }
            }

            @Override
            protected boolean matchesSafely(JsonNode jsonNode) {
                return jsonNode.has("status")
                        && jsonNode.get("status").textValue().equals("UP");
            }
        };
    }
}
