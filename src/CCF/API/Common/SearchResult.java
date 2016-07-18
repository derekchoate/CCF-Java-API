package CCF.API.Common;

import java.util.*;

/**
 * Created by Matt on 21/06/2016.
 */
public class SearchResult {
    public ArrayList<Campaign> Campaigns;
    public int Page;
    public int PageSize;
    public int PageCount;
    public int RecordCount;

    public Boolean Success;
    public String ErrorMessage;
    public String StackTrace;

    public void CalculatePageCount() {
        CalculatePageCount(this.RecordCount, this.PageSize);
    }

    public void CalculatePageCount(int recordCount, int pageSize) {
        if (pageSize <= 0 || recordCount <= 0) {
            this.PageCount = 0;
            return;
        }

        int pageCount = recordCount / pageSize;

        if (pageSize * pageCount < recordCount) {
            ++pageCount;
        }

        this.PageCount = pageCount;
    }

    public static SearchResult getEmpty() {
        SearchResult emptyResult = new SearchResult();
        emptyResult.Page = 1;
        emptyResult.PageSize = 0;
        emptyResult.PageCount = 0;
        emptyResult.RecordCount = 0;
        emptyResult.Success = true;
        emptyResult.Campaigns = new ArrayList<Campaign>();

        return emptyResult;
    }

}
