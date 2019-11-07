package hello;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class ApplicationMockitoTest {
    /*@Test
    public void testMocMaxDollar(){
        MyService serviceMock = Mockito.mock(MyService.class);

        Mockito.when(serviceMock.findMax(30)).thenReturn(65.3354);

        Double maxDollar = serviceMock.findMax(30);
        Assert.assertEquals(65.3354, maxDollar, 1e-4);

    }*/

    @Test
    public void testMocMaxDollar(){
        //MyService serviceMock = Mockito.mock(MyService.class);
        MyService myService = new MyService();
        MyService serviceMock = Mockito.spy(myService);
        Double[] arr = {64.184, 64.3745, 64.1152, 63.8162, 63.9509, 63.6845, 64.2578, 64.2645,
                64.3603, 64.7697, 65.1026, 65.3354, 65.1126, 64.8713, 64.8634, 65.058, 64.981,
                64.7404, 64.1311, 64.3507, 64.2976};
        List<Double> dates = Arrays.asList(arr);

        Mockito.when(serviceMock.getLastDays(30)).thenReturn(dates);

        //MyService service = new MyService();
        //Double maxDollar = service.findMaxThroughDates(serviceMock.getLastDays(30));
        //Assert.assertEquals(65.3354, maxDollar, 1e-4);
        Assert.assertEquals(65.3354, serviceMock.findMaxThroughDates(serviceMock.getLastDays(30)), 1e-4);
    }

    @Test
    public void testControllerMaxDollar(){
        //MyService serviceMock = Mockito.mock(MyService.class);
        MyService myService = new MyService();
        MyService serviceMock = Mockito.spy(myService);
        Double[] arr = {70.184, 64.3745, 64.1152, 63.8162, 63.9509, 63.6845, 64.2578, 64.2645,
                64.3603, 64.7697, 65.1026, 65.3354, 65.1126, 64.8713, 64.8634, 65.058, 64.981,
                64.7404, 64.1311, 64.3507, 64.2976};
        List<Double> dates = Arrays.asList(arr);

        Mockito.when(serviceMock.getLastDays(30)).thenReturn(dates);
        Assert.assertEquals(70.184, new MaxRestController(serviceMock).getMaxDollar(), 1e-4);
    }
}
