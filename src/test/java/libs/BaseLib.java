package libs;

import core.APIMethods;
import core.Config;
import core.RestSession;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

public class BaseLib {

    private RestSession session;

    public ResponseBody getPlaces() throws Exception {
        session = new RestSession();
        Response resp = session.sendRequest(APIMethods.GET_SKYSCANNER_LIST_PLACES, Config.skyscannerAPIKey);
        Assert.assertEquals(resp.getStatusCode(), 200);
        return resp.getBody();
    }
}
