package hello;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MLService {

    //@Autowired
    private FinalRbkService finalRbkService = new FinalRbkService();

    //@Autowired
    private WeatherService weatherService = new WeatherService();

    public Double predictTemp(Double currency){

        SimpleRegression regression = new SimpleRegression();

        List<Double> dollarVals = finalRbkService.getCurrencyForMonth();
        List<Double> weatherVals = weatherService.getTemperatureForLastDays(dollarVals.size());

        int nDays = dollarVals.size();

        double info[][] = new double[2][nDays];
        for (int i = 0; i < nDays; i++) {
            info[0][i] = dollarVals.get(i);
            info[1][i] = weatherVals.get(i);
        }

        regression.addData(info);

        return regression.predict(currency);
    }
}
