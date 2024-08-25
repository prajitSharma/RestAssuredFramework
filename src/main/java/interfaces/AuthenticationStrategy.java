package interfaces;

import io.restassured.builder.RequestSpecBuilder;

public interface AuthenticationStrategy {
    void applyAuthentication(RequestSpecBuilder requestSpecBuilder);
}
