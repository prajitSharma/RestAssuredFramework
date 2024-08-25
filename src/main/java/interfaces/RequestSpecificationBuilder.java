package interfaces;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public interface RequestSpecificationBuilder {

    RequestSpecificationBuilder setBaseUri(String baseUri);
    RequestSpecificationBuilder addHeader(String key, String value);
    RequestSpecificationBuilder addHeaders(Map<String,String> headers);
    RequestSpecificationBuilder addQueryParam(String key, String value);
    RequestSpecificationBuilder addQueryParams(Map<String,?> parametersMap);
    RequestSpecification build();
    RequestSpecBuilder getRestAssuredRequestSpecBuilder();
}
