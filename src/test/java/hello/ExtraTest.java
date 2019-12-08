package hello;

import hello.JsonParsing.JsonTempGetterVar1;
import org.json.JSONException;
import org.junit.Test;

import java.util.Calendar;

public class ExtraTest {

    WeatherService weatherService = new WeatherService();


    @Test
    public void checkRunTime() throws JSONException {
        //weatherService.getTodayWeather(getDateNoTimeInMillis()+"");
        //weatherService.getTemperatureFromInfo(weatherService.getTodayWeather(getDateNoTimeInMillis()+""));
        System.out.println(weatherService.getTemperatureForLastMonth());
    }

    public long getDateNoTimeInMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis()/1000;
    }

    @Test
    public void jsonParse() throws JSONException {
        //JsonTempGetterVar1 jsonGetter = new JsonTempGetterVar1(weatherService.getTodayWeather("" + getDateNoTimeInMillis()));
        //System.out.println(jsonGetter.getTemperature());
        String inf = weatherService.getTodayWeather("" + getDateNoTimeInMillis());
        System.out.println(inf);
        JsonTempGetterVar1 jsonGetter = new JsonTempGetterVar1(inf);
        System.out.println(jsonGetter.getTemperature());
    }
}