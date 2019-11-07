package hello;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);

        //double result = findMaxDollar();
        Service myService = new MyService();
        Double result = myService.findMax(30);
        System.out.println("Max dollar: " + result);
    }

//    public static double findMaxDollar() {
//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl = "http://export.rbc.ru/free/selt.0/free.fcgi?period=DAILY&tickers=USD000000TOD&separator=TAB&data_format=BROWSER&lastdays=30";
//        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//
//        String info = response.getBody();
//        String[] lines = info.split("\\r?\\n");
//        double maxDollarValue = 0;
//
//        for (int i = 0; i < lines.length; i++) {
//            String[] splits = lines[i].split("\\s+");
//            String curValue = splits[splits.length - 1];
//            if (Double.parseDouble(curValue) > maxDollarValue) {
//                maxDollarValue = Double.parseDouble(curValue);
//            }
//        }
//
//        return maxDollarValue;
//    }
}
