package CCF.API.Common;

/**
 * Created by Matt on 21/06/2016.
 */
public class Entity {
    public EntityTypeEnum EntityType;
    public String Name;

    public enum EntityTypeEnum {
        Person,
        Charity,
        Company
    }
}
