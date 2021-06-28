package core;

public class APIMethods {

    public static APIMethod GET_SKYSCANNER_LIST_PLACES = new APIMethod(Environments.getSkyscannerEndPoint(), "/autosuggest/v1.0/", HttpMethod.GET);
}
