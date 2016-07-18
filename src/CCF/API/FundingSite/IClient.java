package CCF.API.FundingSite;

import CCF.API.Common.SearchResult;
import CCF.API.Common.Criteria;
import CCF.API.Common.SearchOptions;

/**
 * Created by Matt on 21/06/2016.
 */
public interface IClient {

    SearchResult Search(Criteria criteria, SearchOptions options) throws Exception;

}