package hello;

import hello.useless.DBService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DbTest {

    @Autowired
    private DbWorker dbWorker;

    @Autowired
    private DBService dbService;

    @Autowired
    private FinalRbkService finalRbkService;

    @Test
    public void testGetMaxFromDb() {
        dbService.getMaxFromDb();
        getMaxFromDb();
    }

    @Test
    public void getMaxFromDb() {
        FinalRbkService serviceMock = Mockito.spy(finalRbkService);
        MyService myService = new MyService();
        //Mockito.when(serviceMock.findTodayMax(getDateNoTime())).thenReturn(myService.findMax(30));
        Mockito.when(serviceMock.findTodayMax(getDateNoTime())).thenReturn(68.999);
        //Mockito.when(serviceMock.getMaxFromServer()).thenReturn(68.999);
        Assert.assertEquals(68.999, serviceMock.getMaxCurrency(), 1e-4);
    }

    @Test
    public void accessToDb(){
        //newestRbkService.getMaxDollar();
        finalRbkService.getMaxCurrency();
    }

    public String getDateNoTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().toString();
    }
}
