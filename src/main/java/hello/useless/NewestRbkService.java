package hello.useless;

import hello.DbWorker;
import hello.MyService;
import hello.RbkDb;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.xml.ws.RespectBinding;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//@SpringBootApplication
////@ContextConfiguration{"classpath*:spring/applicationContext.xml"})
//@Service
//@Configurable
@Component
public class NewestRbkService {

    @Bean
    public RestTemplate bean() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate bean;

    @Autowired
    private DbWorker myDbWorker;

    private Optional<RbkDb> rbkDb;

    private static MyService myService = new MyService();

//    public NewestRbkService(){
//
//    }

    @Transactional
    public void saveNewLine(Double dollar) {
        String currentDate = Calendar.getInstance().getTime().toString();
        RbkDb rbk = new RbkDb(currentDate, dollar);
        //myDbWorker.save(rbk);
        System.out.println(myDbWorker);
    }

    //@Transactional
    public void saveAllDollars(){
        List<Double> dollars = myService.getLastDays(30);

        for (int i = 0; i < dollars.size(); i++) {
            //RbkDb rbk = new RbkDb("" + i, dollars.get(i));
            //dbWorker.save(rbk);
            saveNewLine(dollars.get(i));
        }
    }

    //@Transactional
    public void getMaxDollar(){
        String currentDate = Calendar.getInstance().getTime().toString();
        saveAllDollars();
        //System.out.println(myService.getLastDays(30));
        //System.out.println(dbWorker.getAllDates());
        System.out.println("LLLLL");
    }
}
