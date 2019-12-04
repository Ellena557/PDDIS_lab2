package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

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

    public static interface MaxDollarFinder {
        public List getMaxCurrency();
    }
}
