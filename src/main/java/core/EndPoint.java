package core;

public interface EndPoint {

    String getMethodName();

    String getHostUrl();

    HttpMethod getHttpMethod();

    ParameterType getReqParamType();

}
