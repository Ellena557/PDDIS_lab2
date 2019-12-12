package hello.useless;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MaxFinder {
    @GetMapping("/getMax")
    public Double getMaxDollar(){
        List<Double> nDays = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://export.rbc.ru/free/selt.0/free.fcgi?period=DAILY&tickers=USD000000TOD&separator=TAB&data_format=BROWSER&lastdays=" + "30";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        // add in order to mok-s getforentity and getbody
        String info = response.getBody();
        String[] lines = info.split("\\r?\\n");

        for (int i = 0; i < lines.length; i++) {
            String[] splits = lines[i].split("\\s+");
            String curValue = splits[splits.length - 1];
            nDays.add(Double.parseDouble(curValue));
        }

        double maxDollarValue = 0;

        for (int i = 0; i < nDays.size(); i++) {
            if (nDays.get(i) > maxDollarValue) {
                maxDollarValue = nDays.get(i);
            }
        }
        return maxDollarValue;
    }


    /*public MyService myService(@RequestParam(value="days", required=true, defaultValue=30) double maxVal) {
        return myService(new MyService().findMaxThroughDates(new MyService().getLastDays(value)));
    }*/
}
