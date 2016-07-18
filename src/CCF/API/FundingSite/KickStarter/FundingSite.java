package CCF.API.FundingSite.KickStarter;

import CCF.API.FundingSite.IClient;
import CCF.API.FundingSite.IFundingSite;

/**
 * Created by Matt on 18/07/2016.
 */
public class FundingSite implements IFundingSite {

    public IClient createClient()
    {
        return new Client();
    }

}
