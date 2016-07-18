package CCF.API.FundingSite;

/**
 * Created by Matt on 18/07/2016.
 */
public interface IFundingSite {
/*
    Java won't let me declare these unless they're static and final.  This may need to be an abstract class

    public String Key;
    public String Name;
    public String Url;
*/
    public IClient createClient();

}
