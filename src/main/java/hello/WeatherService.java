package hello;

import hello.JsonParsing.JsonTempGetterVar1;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Calendar;

@Service
public class WeatherService {


    // here we go to dark sky service
    public String getTodayWeather(String date) {

        String mySecretKey = "ac1830efeff59c748d212052f27d49aa";
        String obligatoryForecastStart = "https://api.darksky.net/forecast/ac1830efeff59c748d212052f27d49aa/";
        String LAcoordinates = "34.053044,-118.243750,";
        String exclude = "exclude=daily";

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = obligatoryForecastStart + LAcoordinates + date + "?" + exclude;
        //System.out.println(fooResourceUrl);
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        String info = response.getBody();
        //System.out.println(info);
        return info;
    }

    public Double getTemperatureFromInfo(String date) throws JSONException {
        String info = getTodayWeather(date);
        JsonTempGetterVar1 jsonGetter = new JsonTempGetterVar1(info);
        Double curTemp = Double.parseDouble(jsonGetter.getTemperature());
        return curTemp;
    }


    public ArrayList<Double> getTemperatureForLastMonth() throws JSONException {
        ArrayList<Double> temps = new ArrayList<>();

        long currentDayInSec = Calendar.getInstance().getTimeInMillis() / 1000;
        long oneDayInSec = 24 * 60 * 60L;

        for (int i = 0; i < 30; i++) {
            long curDateSec = currentDayInSec - i * oneDayInSec;
            Double curTemp = getTemperatureFromInfo("" + curDateSec);
            temps.add(curTemp);
        }

        return temps;
    }

    public ArrayList<Double> getTemperatureForLastDays(int days) throws JSONException {
        ArrayList<Double> temps = new ArrayList<>();

        long currentDayInSec = Calendar.getInstance().getTimeInMillis() / 1000;
        long oneDayInSec = 24 * 60 * 60L;

        for (int i = 0; i < days; i++) {
            long curDateSec = currentDayInSec - i * oneDayInSec;
            Double curTemp = getTemperatureFromInfo(""+curDateSec);
            temps.add(curTemp);
        }

        return temps;
    }

    public Double getTomorrowWeather() throws JSONException {
        long currentDayInSec = Calendar.getInstance().getTimeInMillis() / 1000;
        long tomorrow = currentDayInSec + 60 * 60 * 24;
        Double tomorrowWeather = getTemperatureFromInfo(""+tomorrow);
        return tomorrowWeather;
    }
}
