package hello.JsonParsing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TempOneDay {
    public ArrayList<TempOneDayData> data;
}
