package hello;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class MLServiceTest {


    MLService mlService = new MLService();

    @Test
    public void showPrediction(){
        //MLService mlService = new MLService();
        System.out.println("Prediction!");
        Double currency = 60.0;
        System.out.println("currency = " + currency);
        Double predTemp = mlService.predictTemp(currency);
        System.out.println("predicted temperature = " + predTemp);
    }

}