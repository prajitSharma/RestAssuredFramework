package utils;

import interfaces.ApiClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestAssuredApiClient implements ApiClient {

    @Override
    public Response get(RequestSpecification requestSpec, String endpoint) {
        return given().spec(requestSpec).when().get(endpoint)
                .then().log().all() // Logs all details of the response
                .extract().response();
    }

    @Override
    public Response post(RequestSpecification requestSpec, String endpoint, Object body) {
        return given().spec(requestSpec).body(body).when().post(endpoint)
                .then().log().all()
                .extract().response();
    }

    @Override
    public Response put(RequestSpecification requestSpec, String endpoint, Object body) {
        return given().spec(requestSpec).body(body).when().put(endpoint)
                .then().log().all()
                .extract().response();
    }

    @Override
    public Response delete(RequestSpecification requestSpec, String endpoint) {
        return given().spec(requestSpec).when().delete(endpoint)
                .then().log().all()
                .extract().response();
    }

    @Override
    public Response patch(RequestSpecification requestSpec, String endpoint, Object body){
        return given().spec(requestSpec).body(body).when().patch()
                .then().log().all()
                .extract().response();
    }
}
