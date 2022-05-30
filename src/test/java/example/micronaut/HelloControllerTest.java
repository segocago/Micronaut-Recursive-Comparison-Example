package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class HelloControllerTest {

  @Test
  public void testHello() {
    HttpRequest<String> request = HttpRequest.GET("/hello");  // <3>
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("Hello World", body);
  }
}