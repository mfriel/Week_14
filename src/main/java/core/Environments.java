package core;

import static core.Config.ENV;

public class Environments {

    private static String skyscannerEndPoint;

    public static void load(){
        if (ENV.equalsIgnoreCase("DEV")){
            skyscannerEndPoint = "https://partners.api.skyscanner.net/apiservices";
        }

        if (ENV.equalsIgnoreCase("STAGING")){
            skyscannerEndPoint = "https://partners.api.skyscanner.net/apiservices";
        }

        if (ENV.equalsIgnoreCase("PROD")){
            skyscannerEndPoint = "https://partners.api.skyscanner.net/apiservices";
        }
    }

    public static String getSkyscannerEndPoint(){
        return skyscannerEndPoint;
    }

}
