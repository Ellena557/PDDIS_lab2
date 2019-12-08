package hello;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class MaxRestController {

    @Autowired
    private FinalRbkService finalRbkService;
    MyService myService;

    @Autowired
    private MLService mlService;

    public MaxRestController(MyService myService) {
        this.myService = myService;
    }

    public MaxRestController() {
        myService = new MyService();
    }

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherService2 weatherService2;

    @RequestMapping("/getNiceMax")
    public Double getMaxDollar() {
        //Double maxDollar = myService.findMax(30);
        return finalRbkService.getMaxCurrency();
    }

    @RequestMapping("/getWeather")
    public Double getTodayWeather() throws JSONException {
        //Double maxDollar = myService.findMax(30);
        return weatherService.getTemperatureForLastDays(1).get(0);
    }

    @RequestMapping(value = "/postWeather", method = {RequestMethod.POST, RequestMethod.GET})
    public PostResponce getWeatherTemps(int days) throws JSONException {
        PostResponce responce = new PostResponce();
        int mdays = Math.max(days, 1);
        ArrayList<Double> temps = weatherService.getTemperatureForLastDays(mdays);
        responce.temp = temps;
        return responce;
    }

    @RequestMapping(value = "/predictDollar", method = RequestMethod.GET)
    public Double predictDollar(Double temp) throws JSONException {
        Double dollar = mlService.predictDollar(temp);
        return dollar;
    }

    //http://localhost:8080/predictTemp?dollar=22.3
    @RequestMapping(value = "/predictTemp", method = RequestMethod.GET)
    public Double predictTemp(Double dollar) throws JSONException {
        Double temp = mlService.predictTemp(dollar);
        return temp;
    }
}
