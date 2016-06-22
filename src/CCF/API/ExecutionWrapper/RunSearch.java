package CCF.API.ExecutionWrapper;

import CCF.API.FundingSite.KickStarter.Client;

/**
 * Created by Matt on 21/06/2016.
 */
public class RunSearch {

    public static void main(String[] args) {

        Client kickstarter = new Client();

        System.out.println(kickstarter.Search(null, null));

    }
}
