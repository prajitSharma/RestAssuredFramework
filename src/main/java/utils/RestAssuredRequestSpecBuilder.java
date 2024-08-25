package utils;

import interfaces.AuthenticationStrategy;
import interfaces.RequestSpecificationBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

import java.util.Map;

public class RestAssuredRequestSpecBuilder implements RequestSpecificationBuilder {

    private final RequestSpecBuilder builder;

    public RestAssuredRequestSpecBuilder() {
        // If you want to set the base Uri at object creation then use below commented line
        // this.requestSpecification = new RequestSpecBuilder().setBaseUri("GetUriAsArgument").build();
        this.builder = new RequestSpecBuilder();
    }

    @Override
    public RequestSpecificationBuilder setBaseUri(String baseUri) {
        this.builder.setBaseUri(baseUri);
        return this;
    }

    @Override
    public RequestSpecificationBuilder addHeader(String key, String value) {
        this.builder.addHeader(key, value);
        return this;
    }

    @Override
    public RequestSpecificationBuilder addHeaders(Map<String, String> headers) {
        this.builder.addHeaders(headers);
        return this;
    }

    @Override
    public RequestSpecificationBuilder addQueryParam(String key, String value) {
        this.builder.addQueryParam(key, value);
        return this;
    }

    @Override
    public RequestSpecificationBuilder addQueryParams(Map<String, ?> parametersMap) {
        this.builder.addQueryParams(parametersMap);
        return this;
    }



    @Override
    public RequestSpecification build() {
        return this.builder.build().log().all();
    }

    @Override
    public RequestSpecBuilder getRestAssuredRequestSpecBuilder() {
        return this.builder;
    }
}