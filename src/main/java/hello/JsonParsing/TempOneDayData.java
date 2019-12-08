package hello.JsonParsing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TempOneDayData {
    public double temperature;
}
