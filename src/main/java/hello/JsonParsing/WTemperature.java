package hello.JsonParsing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"latitude", "longtitude"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class WTemperature {
    //@JsonProperty("temperature")
    //public Double temperature;
    public TempOneDay hourly;
}
