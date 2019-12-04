package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

//@Configurable
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DbFiller {

    //@Autowired
    // private ApplicationContext context;// = new SpringApplicationBuilder(Application.class).run();
    private static MyService myService = new MyService();

    @Resource
    DbWorker dbWorker;

    @Test
    public void fill() {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("Currencies");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Double> dollars = myService.getLastDays(30);
        for (int i = 0; i < 30; i++) {
            RbkDb rbk = new RbkDb();
            rbk.setCurrency(dollars.get(i));
        }*/

        //DbWorker repo = context.getBean(DbWorker.class);

        //System.out.println(context);
        //System.out.println(repo);
        List<Double> dollars = myService.getLastDays(30);

        for (int i = 0; i < dollars.size(); i++) {
            RbkDb rbk = new RbkDb("" + i, dollars.get(i));
            dbWorker.save(rbk);
        }
    }

}
