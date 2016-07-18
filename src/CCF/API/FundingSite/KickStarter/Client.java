package CCF.API.FundingSite.KickStarter;

import CCF.API.Common.Criteria;
import CCF.API.Common.SearchOptions;
import CCF.API.Common.SearchResult;
import CCF.API.FundingSite.IClient;
import CCF.API.FundingSite.KickStarter.KickStarterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Matt on 21/06/2016.
 */
public class Client implements IClient {

    @Override
    public SearchResult Search(Criteria criteria, SearchOptions options) throws KickStarterException{

        //A double try catch!?  Yes it's bloody horrible, but,  it's the only way I could get this to work.  Feel free to tidy up my mess...!
        try{
            String searchURL = createSearchURL();

            HttpURLConnection con;
            URL url = new URL(searchURL);

            try {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("accept", "application/json, text/javascript, */*; q=0.01");
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36");

                if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String strTemp = "";
                    while ((strTemp = br.readLine()) != null) {
                        System.out.println(strTemp);
                    }

                }

            } catch (Exception ex) {
                throw new KickStarterException(String.format("Error while calling %s: %s", url.toURI().toString(), ex.getMessage()), url.toURI().toString());
            }
        }
        catch (MalformedURLException malex){
            throw new KickStarterException(malex.getMessage(), null);
        }
        catch (URISyntaxException urex){
            throw new KickStarterException(urex.getMessage(), null);
        }

        return null;
    }

    private String createSearchURL() {

        StringBuilder url = new StringBuilder();

        url.append("https://www.kickstarter.com/");
        url.append("projects/search.json");
        url.append("?");
        url.append("page");
        url.append("=");
        url.append("page");
        url.append("1");

        return url.toString();
    }
}
