package skyscannertest;

import libs.BaseLib;
import org.testng.annotations.Test;

public class SkyscannerTests extends BaseLib{

    @Test
    public void TC001() throws Exception {
        getPlaces();
    }

}
