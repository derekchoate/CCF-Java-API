package CCF.API.FundingSite.KickStarter;

import CCF.API.Common.SearchResult;
import CCF.API.Common.ImageDetails;
import CCF.API.Common.ImageList;
import CCF.API.Common.Entity;
import CCF.API.Common.Country;

import java.util.ArrayList;
import java.util.Iterator;
import CCF.API.Common.Campaign;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Matt on 18/07/2016.
 */

public class SearchResponse {
    public ArrayList<Project> projects;

    public Integer total_hits;

    public Integer seed;

    public String search_url;

    public Boolean has_more;

    public SearchResult ToSearchResults(Integer currentPage) {
        SearchResult result = new SearchResult();

        result.Page = currentPage;
        result.PageSize = 20;
        result.RecordCount = has_more ? -1 : ((currentPage - 1) * result.PageSize) + this.projects.size();
        result.PageCount = has_more ? -1 : currentPage;

        result.Campaigns = new ArrayList<Campaign>();

        Iterator it = projects.iterator();

        for (Project project : this.projects) {
            result.Campaigns.add(project.ToCampaign());
        }

        return result;
    }

    public class Photo {
        public String key;

        public String full;

        public String ed;

        public String med;

        public String little;

        public String small;

        public String thumb;

        public String size_1024x576;

        public String size_1536x864;
    }

    public class Avatar {
        public String thumb;

        public String small;

        public String medium;
    }

    public class RelatedResources {
        public String user;

        public String discover;

        public String location;

        public String nearby_projects;

        public String project;

        public String rewards;
    }

    public class RelatedResourcesVariant {
        public RelatedResources web;

        public RelatedResources api;
    }

    public class Creator {
        public Integer id;

        public String name;

        public Avatar avatar;

        public RelatedResourcesVariant urls;

        public String slug;
    }

    public class Location {
        public Integer id;

        public String name;

        public String slug;

        public String short_name;

        public String displayable_name;

        public String country;

        public String state;

        public String type;

        public Boolean is_root;

        public RelatedResources urls;
    }

    public class Category {
        public Integer id;


        public String name;


        public String slug;


        public Integer position;


        public Integer parent_id;


        public Integer color;


        public RelatedResources urls;
    }

    public class ImageUrls {
        public String defaultImage;

        public String baseball_card;
    }

    public class FeatureImageAttributes {
        public ImageUrls image_urls;
    }

    public class Profile {
        public Integer id;

        public Integer project_id;

        public String state;

        public Integer state_changed_at;

        public String name;

        public String blurb;

        public String background_color;

        public String text_color;

        public String link_background_color;

        public String link_text_color;

        public String link_text;

        public String link_url;

        public Boolean show_feature_image;

        public double background_image_opacity;

        public Boolean should_show_feature_image_section;

        public FeatureImageAttributes feature_image_attributes;
    }

    public class Project {
        public Integer id;

        public Photo photo;

        public String name;

        public String blurb;

        public double goal;

        public double pledged;

        public String state;

        public String slug;

        public Boolean disable_communication;

        public String country;

        public String currency;

        public String currency_symbol;

        public Boolean currency_trailing_code;

        public Integer deadline;

        public Integer state_changed_at;

        public Integer created_at;

        public Integer launched_at;

        public Boolean staff_pick;

        public Integer backers_count;

        public String static_usd_rate;

        public String usd_pledged;

        public Creator creator;

        public Location location;

        public Category category;

        public Profile profile;

        public Boolean spotlight;

        public RelatedResourcesVariant urls;

        public Campaign ToCampaign() {
            Campaign campaign = new Campaign();

            campaign.Balance = new BigDecimal(this.pledged, MathContext.DECIMAL64);
            campaign.Category = this.category.name;
            campaign.Contributors = this.backers_count;
//            campaign.Deadline = AjaxDateTimeUtility.FromEpochTime(this.deadline);
            campaign.Description = this.blurb;
            campaign.Goal =  new BigDecimal(this.goal, MathContext.DECIMAL64);
            campaign.Name = this.name;
//            campaign.Published = AjaxDateTimeUtility.FromEpochTime(this.launched_at);
//            campaign.SourceSiteKey = Settings.Default.SiteKey;
            campaign.Style = Campaign.CampaignStyleEnum.GoalWithDeadline;
            campaign.Url = this.urls.web.project;

            campaign.Images = new ImageList();
            campaign.Images.Thumbnail = new ImageDetails();
            campaign.Images.Thumbnail.ResourceUrl = this.photo.thumb;

            campaign.Images.Small = new ImageDetails();
            campaign.Images.Small.ResourceUrl = this.photo.small;

            campaign.Images.Medium = new ImageDetails();
            campaign.Images.Medium.ResourceUrl = this.photo.med;

            campaign.Images.Large = new ImageDetails();
            campaign.Images.Large.ResourceUrl = this.photo.full;

            campaign.Location = new CCF.API.Common.Location();
            campaign.Location.ProvState = this.location.state;

            switch (this.location.type) {
                case "County":
                    campaign.Location.County = this.location.name;
                    break;
                case "Town":
                    campaign.Location.City = this.location.name;
                    break;
                default:
                    break;
            }

            campaign.Location.Country = new Country();
            campaign.Location.Country.CurrencySymbol = this.currency_symbol;
            campaign.Location.Country.ShortName = this.location.country;
            campaign.Location.FormattedLocation = new ArrayList<String>();
            campaign.Location.FormattedLocation.add(this.location.displayable_name);

            campaign.Publisher = new Entity();
            campaign.Publisher.Name = this.creator.name;

            return campaign;
        }
    }
}