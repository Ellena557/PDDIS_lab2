package hello;

import hello.JsonParsing.JsonParser2;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import sun.misc.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;

public class WeatherServiceTest {

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
        return calendar.getTimeInMillis() / 1000;
    }

    @Test
    public void getWeather() throws IOException, URISyntaxException, JSONException {

//        InputStream is = new FileInputStream("weatherLA.json");
//        String jsonTxt = IOUtils.toString(is, "UTF-8");
        String wLA = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/weatherLA.json").toURI())));

        WeatherService myService = new WeatherService();
        WeatherService serviceMock = Mockito.spy(myService);
        Mockito.when(serviceMock.getTodayWeather("" + getDateNoTimeInMillis())).thenReturn(wLA);
        Double weather = serviceMock.getTemperatureForLastDays(1).get(0);
        System.out.println(weather);

        Assert.assertEquals(60.41, weather, 1e-4);
    }

    @Test
    public void testService2() throws IOException, URISyntaxException {
        String wLA = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/weatherLA.json").toURI())));

        WeatherService2 myService = new WeatherService2();
        WeatherService2 serviceMock = Mockito.spy(myService);
        Mockito.when(serviceMock.getTodayWeather("" + getDateNoTimeInMillis())).thenReturn(wLA);
        Double weather = serviceMock.getTemperatureForLastDays(1).get(0);
        //System.out.println(weather);

        Assert.assertEquals(60.41, weather, 1e-4);
    }
}