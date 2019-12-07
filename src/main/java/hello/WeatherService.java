package hello;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public Double getTemperatureFromInfo(String info) {
        Double resTemp = Double.valueOf(0);
        // in this file the today temperature is given after the FIRST word "temperature" (11 letters)
        boolean reachedTheAnswer = false;
        int iterator = 0;
        while (!reachedTheAnswer && iterator < info.length()) {
            String shouldBe = "temperature";
            if (info.substring(iterator, iterator + 11).equals(shouldBe)) {
                reachedTheAnswer = true;

                // here goes also " and :
                int startOfTemp = iterator + 13;
                //ends before ,
                String totalTemp = "";
                while (!info.substring(startOfTemp, startOfTemp + 1).equals(",")) {
                    totalTemp += info.substring(startOfTemp, startOfTemp + 1);
                    startOfTemp += 1;
                }

                //System.out.println(totalTemp);
                resTemp = Double.parseDouble(totalTemp);
            }
            iterator += 1;
        }

        return resTemp;
    }

    public ArrayList<Double> getTemperatureForLastMonth() {
        ArrayList<Double> temps = new ArrayList<>();

        long currentDayInSec = Calendar.getInstance().getTimeInMillis() / 1000;
        long oneDayInSec = 24 * 60 * 60;

        for (int i = 0; i < 30; i++) {
            long curDateSec = currentDayInSec - i * oneDayInSec;
            Double curTemp = getTemperatureFromInfo(getTodayWeather("" + curDateSec));
            temps.add(curTemp);
        }

        return temps;
    }

    public ArrayList<Double> getTemperatureForLastDays(int days) {
        ArrayList<Double> temps = new ArrayList<>();

        long currentDayInSec = Calendar.getInstance().getTimeInMillis() / 1000;
        long oneDayInSec = 24 * 60 * 60;

        for (int i = 0; i < days; i++) {
            long curDateSec = currentDayInSec - i * oneDayInSec;
            Double curTemp = getTemperatureFromInfo(getTodayWeather("" + curDateSec));
            temps.add(curTemp);
        }

        return temps;
    }

}
