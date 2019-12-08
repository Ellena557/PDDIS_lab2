package hello.JsonParsing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JsonParser2 {
    public String info;

    public JsonParser2(String info) {
        this.info = info;
    }

    public double getTemperature() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        WTemperature wTemperature = mapper.readValue(info, WTemperature.class);
        double temp = wTemperature.hourly.data.get(0).temperature;
        return temp;
    }
}
