package CCF.API.FundingSite.Indiegogo;

import CCF.API.Common.Criteria;
import CCF.API.Common.SearchOptions;
import CCF.API.Common.SearchResult;
import CCF.API.FundingSite.IClient;

/**
 * Created by Matt on 21/06/2016.
 */
public class Client implements IClient {

    @Override
    public SearchResult Search(Criteria criteria, SearchOptions options) {



        return null;
    }

    public String createSearchURL() {

        StringBuilder url = new StringBuilder();

        url.append("https://www.indiegogo.com/");
        url.append("private_api/search");
        url.append("?");
        url.append("page");
        url.append("=");
        url.append("page");
        url.append("1");

        return url.toString();
    }
}
