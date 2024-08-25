package utils;

import interfaces.AuthenticationStrategy;
import io.restassured.builder.RequestSpecBuilder;

public class TokenAuthenticationStrategy implements AuthenticationStrategy {

    private final String token;

    public TokenAuthenticationStrategy(String token) {
        this.token = token;
    }

    @Override
    public void applyAuthentication(RequestSpecBuilder requestSpecBuilder) {
        requestSpecBuilder.addHeader("Authorization", "Bearer " + token);
    }
}
