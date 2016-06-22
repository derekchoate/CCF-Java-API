package CCF.API.Common;

/**
 * Created by Matt on 21/06/2016.
 */
public class SearchOptions {
    public int Page;
    public int PageSize;
    public SortTypeEnum SoryType;

    public enum SearchTypeEnum {
        keyword,
        curated
    }

    public enum SortTypeEnum {
        standard,
        endingSoon,
        popularity,
        mostFunded,
        newest
    }
}