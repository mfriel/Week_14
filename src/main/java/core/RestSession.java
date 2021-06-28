package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class RestSession {

    // with Headers
    public Response sendRequest(APIMethod apiMethod, Map requestHeaders) throws Exception {
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.addHeaders(requestHeaders);
        return sendSpec(apiMethod, reqBuilder);
    }

    //With Headers and Params
    public Response sendRequest(APIMethod apiMethod, Map requestHeaders, Map requestParams) throws Exception {
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.addHeaders(requestHeaders);
        reqBuilder.addParams(requestParams);
        return sendSpec(apiMethod, reqBuilder);
    }

    //With Headers and Payload
    public Response sendRequest(APIMethod apiMethod, Object payLoad,HashMap<String, String> headerList) throws Exception {
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.addHeaders(headerList);
        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.setBody(payLoad, ObjectMapperType.GSON);
        return sendSpec(apiMethod, reqBuilder);
    }

    private Response sendSpec(APIMethod methodPath, RequestSpecBuilder builder) throws MalformedURLException {
        URL requestUrl = new URL(methodPath.getHostUrl() + "/" +  methodPath.getMethodName());
        Response response = null;
        builder.setBaseUri(methodPath.getHostUrl());
        builder.setBasePath(methodPath.getMethodName());
        RequestSpecification requestSpecification = builder.build();
        requestSpecification.log().all(true);
        ResponseSpecification spec = RestAssured.given().urlEncodingEnabled(false).spec(requestSpecification).response();

        switch(methodPath.getHttpMethod()) {
            case GET:
                response = spec.when().get(requestUrl);
                break;
            case POST:
                response = spec.when().post(requestUrl);
                break;
            case PUT:
                response = spec.when().put(requestUrl);
                break;
            case PATCH:
                response = spec.when().patch(requestUrl);
                break;
            case DELETE:
                response = spec.when().delete(requestUrl);
                break;
            case HEAD:
                response = spec.when().head(requestUrl);
        }
        response.then().log().all(true);
        return response;
    }
}
