package example;

import io.micronaut.context.annotation.Value;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.inject.*;

@MicronautTest
public class HelloControllerTest {

	@Inject
	HelloClient helloClient;

	@Value("${greeting:FallbackInJUnit}")
    String greeting = "InitialInJunit";

    @Test
    void testHello() {
        assertEquals(
                greeting + " Fred!",
                helloClient.hello("Fred").blockingGet());
    }
}
