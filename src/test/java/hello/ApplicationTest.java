package hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import org.mockito.Mockito;

import javax.xml.ws.Service;
import java.util.List;

import static org.junit.Assert.*;

public class ApplicationTest {
    Application application;
    MyService myService = new MyService();

    @Test
    public void testValue() {
        // у нас постоянно должен быть сохранен максимум
        //  разных методах поиск максимума и ...?
        assertEquals(65.3354, myService.findMax(30), 1e-8);
    }

    @Test
    public void testSign() {
        assert (myService.findMax(30) > 0);
    }

//    public interface Service {
    /* МОК + такой сервис -- и вот уже проверка*/
//        void save(List<String data>);
//        String getById(String id);
//        List<String > getAlll();
    // MAYBE: getLastDays(int days
;//        List<String > getByRequest(Request request);
//    }

    //Service serviceMock = Mockito.mock(Service.class);
}