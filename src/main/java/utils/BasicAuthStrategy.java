package utils;

import interfaces.AuthenticationStrategy;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BasicAuthStrategy implements AuthenticationStrategy {

    private final String username;
    private final String password;

    public BasicAuthStrategy(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void applyAuthentication(RequestSpecBuilder requestSpecBuilder) {
        requestSpecBuilder.setAuth(io.restassured.RestAssured.basic(username, password));
    }
}
