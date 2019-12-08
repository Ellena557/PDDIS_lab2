package hello;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MLServiceTest {

    MLService mlService = new MLService();

    @Test
    public void showPrediction() throws JSONException {
        //MLService mlService = new MLService();
        System.out.println("Prediction!");
        Double currency = 60.0;
        System.out.println("currency = " + currency);
        Double predTemp = mlService.predictTemp(currency);
        System.out.println("predicted temperature = " + predTemp);
    }

    @Test
    public void currencyPredictionSign() throws JSONException {
        Double currency = mlService.predictDollar(40.5);
        Assert.assertTrue(currency > 0);
    }

}