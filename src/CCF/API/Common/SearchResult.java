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
/*
    public static SearchResult Empty {
            var emptyResult = new SearchResult
            {
                Campaigns = new List<Campaign>(),
                        Page = 1,
                        PageSize = 0,
                        PageCount = 0,
                        RecordCount = 0,
                        Success = true
            };

            return emptyResult;

    }
*/
}
