package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {
    @Test
    public void testApiResponse() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        assertEquals(200, response.getStatusCode());
        assertTrue(response.jsonPath().getString("title") != null);
    }
}
