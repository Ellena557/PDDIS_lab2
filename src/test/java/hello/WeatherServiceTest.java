package hello;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class WeatherServiceTest {

    WeatherService weatherService = new WeatherService();

    @Test
    public void checkRunTime(){
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
    public void getWeather(){
        String info = "{\"latitude\":34.053044,\"longitude\":118.24375,\"timezone\":\"Asia/Shanghai\",\"hourly\":{\"summary\":\"Clear " +
                "throughout the day.\",\"icon\":\"clear-day\",\"data\":[{\"time\":1575388800,\"summary\":" +
                "\"Clear\",\"icon\":\"clear-night\",\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":33.64," +
                "\"apparentTemperature\":33.64,\"dewPoint\":17.82,\"humidity\":0.52,\"pressure\":1031,\"windSpeed\":2.29," +
                "\"windGust\":4.15,\"windBearing\":268,\"cloudCover\":0,\"uvIndex\":0,\"visibility\":10,\"ozone\":278.7}," +
                "{\"time\":1575392400,\"summary\":\"Clear\",\"icon\":\"clear-night\",\"precipIntensity\":0,\"precipProbability\":0," +
                "\"temperature\":32.93,\"apparentTemperature\":32.93,\"dewPoint\":16.89,\"humidity\":0.51,\"pressure\":1031.1," +
                "\"windSpeed\":1.71,\"windGust\":3.23,\"windBearing\":287,\"cloudCover\":0,\"uvIndex\":0,\"visibility\":10," +
                "\"ozone\":278.1},{\"time\":1575396000,\"summary\":\"Clear\",\"icon\":\"clear-night\",\"precipIntensity\":0," +
                "\"precipProbability\":0,\"temperature\":32.31,\"apparentTemperature\":32.31,\"dewPoint\":15.89,\"humidity\":0.5," +
                "\"pressure\":1030.9,\"windSpeed\":1.45,\"windGust\":2.73,\"windBearing\":265,\"cloudCover\":0,\"uvIndex\":0," +
                "\"visibility\":10,\"ozone\":279.3},{\"time\":1575399600,\"summary\":\"Clear\",\"icon\":\"clear-night\"," +
                "\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":31.33,\"apparentTemperature\":31.33,\"dewPoint\":14.79," +
                "\"humidity\":0.5,\"pressure\":1030.9,\"windSpeed\":1.41,\"windGust\":2.56,\"windBearing\":97,\"cloudCover\":0," +
                "\"uvIndex\":0,\"visibility\":10,\"ozone\":280},{\"time\":1575403200,\"summary\":\"Clear\",\"icon\":\"clear-night\"," +
                "\"precipIntensity\":0,\"precipProbability\":0,\"temperature\":30.24,\"apparentTemperature\":30.24,\"dewPoint\":13.75," +
                "\"humidity\":0.5,\"pressure\":1030.9,\"windSpeed\":1.5,\"windGust\":2.59,\"windBearing\":130,\"cloudCover\":0,\"uvIndex\":0," +
                "\"visibility\":10,\"ozone\":280.9},{\"time\":1575406800,\"summary\":\"Clear\",\"icon\":\"clear-\n";

        WeatherService myService = new WeatherService();
        WeatherService serviceMock = Mockito.spy(myService);
        Mockito.when(serviceMock.getTodayWeather(""+getDateNoTimeInMillis())).thenReturn(info);

        Assert.assertEquals(33.64, serviceMock.getTemperatureFromInfo(serviceMock.getTodayWeather(""+getDateNoTimeInMillis())), 1e-4);
    }
}