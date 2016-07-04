package CCF.API.FundingSite.KickStarter;

import java.util.ArrayList;

/**
 * Created by Matt on 23/06/2016.
 */
public class SearchResponse {
    
    public class SearchResponse
    {
        public ArrayList<Project> projects;
        public int total_hits;
        public int seed;
        public String search_url;
        public boolean has_more;

        public SearchResult ToSearchResults(Int32 currentPage)
        {
            SearchResult result = new SearchResult();

            result.Page = currentPage;
            result.PageSize = 20;
            result.RecordCount = has_more ? -1 : ((currentPage - 1) * result.PageSize) + this.projects.Count;
            result.PageCount = has_more ? - 1 : currentPage;

            result.Campaigns = new List<Campaign>();

            foreach (var project in this.projects)
            {
                result.Campaigns.Add(project.ToCampaign());
            }

            return result;
        }
    }

    public class Photo
    {
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

    public class Avatar
    {
        public String thumb;
        public String small;
        public String medium;
    }

    public class RelatedResources
    {
        public String user;
        public String discover;
        public String location;
        public String nearby_projects;
        public String project;
        public String rewards;
    }

    public class RelatedResourcesVariant
    {
        public RelatedResources web;
        public RelatedResources api;
    }

    public class Creator
    {
        public int id;
        public String name;
        public Avatar avatar;
        public RelatedResourcesVariant urls;
        public String slug;
    }

    public class Location
    {
        public int id;
        public String name;
        public String slug;
        public String short_name;
        public String displayable_name;
        public String country;
        public String state;
        public String type;
        public boolean is_root;
        public RelatedResources urls;
    }

    public class Category
    {
        public int id;
        public String name;
        public String slug;
        public int position;
        public int parent_id;
        public int color;
        public RelatedResources urls;
    }

    public class ImageUrls
    {
        public String defaultImage;
        public String baseball_card;
    }

    public class FeatureImageAttributes
    {
        public ImageUrls image_urls;
    }

    public class Profile
    {
        public int id;
        public int project_id;
        public String state;
        public int state_changed_at;
        public String name;
        public String blurb;
        public String background_color;
        public String text_color;
        public String link_background_color;
        public String link_text_color;
        public String link_text;
        public String link_url;
        public boolean show_feature_image;
        public double background_image_opacity;
        public boolean should_show_feature_image_section;
        public FeatureImageAttributes feature_image_attributes;
    }

    public class Project
    {
        public int id;
        public Photo photo;
        public String name;
        public String blurb;
        public double goal;
        public double pledged;
        public String state;
        public String slug;
        public boolean disable_communication;
        public String countr
        public String currency;
        public String currency_symbol;
        public boolean currency_trailing_code;
        public int deadline;
        public int state_changed_at;
        public int created_at;
        public int launched_at;
        public boolean staff_pick;
        public int backers_count;
        public String static_usd_rate;
        public String usd_pledged;
        public Creator creator;
        public Location location;
        public Category category;
        public Profile profile;
        public boolean spotlight;
        public RelatedResourcesVariant urls;

        public Campaign ToCampaign()
        {
            Campaign campaign = new Campaign();

            campaign.Balance = Convert.ToDecimal(this.pledged);
            campaign.Category = this.category.name;
            campaign.Contributors = this.backers_count;
            campaign.Deadline = AjaxDateTimeUtility.FromEpochTime(this.deadline);
            campaign.Description = this.blurb;
            campaign.Goal = Convert.ToDecimal(this.goal);
            campaign.Name = this.name;
            campaign.Published = AjaxDateTimeUtility.FromEpochTime(this.launched_at);
            campaign.SourceSiteKey = Settings.Default.SiteKey;
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

            campaign.Location = new Common.Location();
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
            campaign.Location.FormattedLocation = new List<String> { this.location.displayable_name };

            campaign.Publisher = new Entity();
            campaign.Publisher.Name = this.creator.name;

            return campaign;
        }
    }
}