package CCF.API.FundingSite.KickStarter;

/**
 * Created by Matt on 21/06/2016.
 */
public class KickStarterException extends Exception {
    public String Endpoint;

    public KickStarterException (String message, String endpoint) {
        this.Endpoint = endpoint;
    }
}
