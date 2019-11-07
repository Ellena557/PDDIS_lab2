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

    @Test
    public void testGoToService(){
        MyService serviceMock = Mockito.mock(MyService.class);
        MyService service = new MyService();
        String realInfo = "USD000000TOD\t2019-09-24\t63.735\t63.7875\t63.6\t63.7825\t492878000\t63.6845\n" +
                "USD000000TOD\t2019-09-25\t64.0375\t64.4775\t63.9925\t64.4\t944253000\t64.2578\n" +
                "USD000000TOD\t2019-09-26\t64.32\t64.37\t64.095\t64.3325\t603439000\t64.2645\n" +
                "USD000000TOD\t2019-09-27\t64.34\t64.4375\t64.26\t64.305\t727986000\t64.3603\n" +
                "USD000000TOD\t2019-09-30\t64.65\t65\t64.57\t64.96\t826782000\t64.7697\n" +
                "USD000000TOD\t2019-10-01\t64.955\t65.37\t64.95\t65.3475\t699118000\t65.1026\n" +
                "USD000000TOD\t2019-10-02\t65.3475\t65.5575\t65.0225\t65.2375\t647424000\t65.3354\n" +
                "USD000000TOD\t2019-10-03\t65.085\t65.3675\t65.0225\t65.2175\t652828000\t65.1126\n" +
                "USD000000TOD\t2019-10-04\t65.01\t65.0925\t64.51\t64.5375\t814237000\t64.8713\n" +
                "USD000000TOD\t2019-10-07\t64.675\t64.97\t64.675\t64.8575\t515837000\t64.8634\n" +
                "USD000000TOD\t2019-10-08\t64.8375\t65.3625\t64.7525\t65.2875\t652387000\t65.058\n" +
                "USD000000TOD\t2019-10-09\t65.19\t65.195\t64.8075\t64.9\t622432000\t64.981\n" +
                "USD000000TOD\t2019-10-10\t64.7\t64.87\t64.545\t64.585\t553196000\t64.7404\n" +
                "USD000000TOD\t2019-10-11\t64.265\t64.2775\t63.9725\t64.11\t851068000\t64.1311\n" +
                "USD000000TOD\t2019-10-15\t64.2875\t64.5\t64.1825\t64.25\t638537000\t64.3507\n" +
                "USD000000TOD\t2019-10-16\t64.3\t64.4425\t64.14\t64.205\t595571000\t64.2976\n" +
                "USD000000TOD\t2019-10-17\t64.1125\t64.13\t63.8375\t63.915\t828493000\t63.9875\n" +
                "USD000000TOD\t2019-10-18\t64.005\t64.0675\t63.8825\t64.0625\t554766000\t63.9417\n" +
                "USD000000TOD\t2019-10-21\t63.81\t63.8475\t63.62\t63.7275\t670843000\t63.7217\n" +
                "USD000000TOD\t2019-10-22\t63.695\t63.8025\t63.56\t63.68\t606826000\t63.6713\n" +
                "USD000000TOD\t2019-10-23\t63.74\t63.9825\t63.69\t63.9425\t770583000\t63.8508\n";
        Mockito.when(serviceMock.goToService(30)).thenReturn(realInfo);
        //Assert.assertEquals(new MyService().goToService(30),realInfo);
    }

    @Test
    public void testMocMacDollarSign() {
        MyService serviceMock = Mockito.mock(MyService.class);
        //Mockito.verify(serviceMock, Mockito.atLeastOnce()).findMax(30);
        InOrder inOrder = Mockito.inOrder(serviceMock);
        inOrder.verify(serviceMock, Mockito.atLeastOnce()).getLastDays(any());
        inOrder.verify(serviceMock).findMax(any());
    }
}
