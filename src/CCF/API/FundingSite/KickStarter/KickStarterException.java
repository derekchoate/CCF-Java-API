package CCF.API.FundingSite.KickStarter;

/**
 * Created by Matt on 21/06/2016.
 */
public class KickStarterException extends Exception {
    private String Endpoint;

    public KickStarterException (String message, String endpoint) {
        this.Endpoint = endpoint;
    }

    public String getEndPoint(){
        return Endpoint;
    }
}
