package core;

import java.io.StringReader;
import java.util.HashMap;

public class APIMethod implements EndPoint{

    private String hostUrl;
    private String methodName;
    private HttpMethod httpMethod;
    private HashMap<String, String> params = new HashMap<>();
    private ParameterType reqParamType = ParameterType.JSON;
    private String methodURLWithParam;

    public APIMethod (String hostUrl, String methodName, HttpMethod httpMethod, ParameterType paramType){
        this.httpMethod = httpMethod;
        this.reqParamType = paramType;
        this.hostUrl = hostUrl;
    }

    public APIMethod (String hostUrl, String methodName, HttpMethod httpMethod){
        this.methodName = methodName;
        this.httpMethod = httpMethod;
        this.hostUrl = hostUrl;
    }

    public void addMethodParam(String param){
        if (this.methodURLWithParam.contains("@@param")){
            this.methodName = this.methodURLWithParam;
            this.methodName = this.methodName.replaceFirst("@@param", param);
        }
    }

    @Override
    public String getMethodName(){
        return methodName;
    }

    @Override
    public String getHostUrl(){
        return hostUrl;
    }

    @Override
    public HttpMethod getHttpMethod(){
        return httpMethod;
    }

    @Override
    public ParameterType getReqParamType(){
        return reqParamType;
    }
}
