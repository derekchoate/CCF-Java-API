package CCF.API.Common;

import java.util.*;

/**
 * Created by Matt on 21/06/2016.
 */
public class Criteria {
    public String Term;
    public Boolean EndingSoon;
    public ArrayList<String> Categories;
    public StatusEnum Status;
    public PercentRaisedEnum PercentRaised;

    public enum StatusEnum {
        all,
        live,
        successful,
        ended
    }

    public enum PercentRaisedEnum {
        all,
        LessThan75,
        Between75and100,
        GreaterThan100
    }
}
