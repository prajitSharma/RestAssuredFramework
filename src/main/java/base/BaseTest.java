package base;

import factory.BaseUriFactory;
import interfaces.RequestSpecificationBuilder;
import interfaces.AuthenticationStrategy;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.RestAssuredRequestSpecBuilder;

public abstract class BaseTest {

    protected RequestSpecificationBuilder requestSpecificationBuilder;
    private String baseUri;


    // Method to apply authentication strategy on demand
    protected void applyAuthentication(AuthenticationStrategy authenticationStrategy) {
        authenticationStrategy.applyAuthentication(this.requestSpecificationBuilder.getRestAssuredRequestSpecBuilder());
    }

    @BeforeClass
    public void setUp() {
        BaseUriFactory baseUriFactory = new BaseUriFactory();
        String apiName = getApiName(); // This method should be overridden in test classes
        baseUri = baseUriFactory.getBaseUri(apiName);
    }

    @BeforeMethod
    public void initialise() {
        this.requestSpecificationBuilder = new RestAssuredRequestSpecBuilder();
        this.requestSpecificationBuilder.setBaseUri(baseUri);

    }

    protected abstract String getApiName(); // Each test class should specify its API name



}
