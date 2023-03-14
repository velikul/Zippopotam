
package apiTests;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("place name")
    @Expose
    private String placeName;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("state abbreviation")
    @Expose
    private String stateAbbreviation;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Place() {
    }

    /**
     * 
     * @param stateAbbreviation
     * @param latitude
     * @param state
     * @param placeName
     * @param longitude
     */
    public Place(String placeName, String longitude, String state, String stateAbbreviation, String latitude) {
        super();
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Place.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("placeName");
        sb.append('=');
        sb.append(((this.placeName == null)?"<null>":this.placeName));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("stateAbbreviation");
        sb.append('=');
        sb.append(((this.stateAbbreviation == null)?"<null>":this.stateAbbreviation));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
