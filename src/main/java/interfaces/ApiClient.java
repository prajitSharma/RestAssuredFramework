package interfaces;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public interface ApiClient {

    Response get(RequestSpecification requestSpec, String endpoint);
    Response post(RequestSpecification requestSpec, String endpoint, Object body);
    Response put(RequestSpecification requestSpecification, String endpoint, Object body);
    Response delete(RequestSpecification requestSpecification, String endpoint);
    Response patch(RequestSpecification requestSpecification, String endpoint, Object body);
}