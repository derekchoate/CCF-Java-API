package CCF.API.Common;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Matt on 21/06/2016.
 */
public class Campaign {
    public String SourceSiteKey;
    public String Name;
    public String Description;
    public int Contributors;
    public BigDecimal Goal;

    public BigDecimal Balance;
    public Date Published;
    public Date Deadline;
    public Entity Publisher;
    public Location Location;
    public ImageList Images;
    public String Url;
    public String Category;
    public CampaignStyleEnum Style;
/*
    public String StyleName { get
        {
            return Style.ToString();
        }
    }
*/
    public String RecurringPeriod;
    public enum CampaignStyleEnum {
        MustHitGoalWithDeadline,
        GoalWithDeadline,
        RecurringGoal
    }

}
