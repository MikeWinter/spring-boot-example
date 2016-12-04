package helpers.matchers;

import com.fasterxml.jackson.databind.JsonNode;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class JsonNodeMatcher {
    public static Matcher<JsonNode> missing(String nodeName) {
        return new TypeSafeMatcher<JsonNode>() {
            @Override
            protected boolean matchesSafely(JsonNode item) {
                return !item.has(nodeName);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("missing the ");
                description.appendValue(nodeName);
                description.appendText(" node");
            }
        };
    }
}
