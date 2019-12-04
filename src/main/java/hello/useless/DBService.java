package hello.useless;

import hello.DbWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class DBService {

    @Autowired
    private DbWorker dbWorker;

    public DBService(){

    }

    public void getMaxFromDb() {
        ArrayList<Double> dollars = new ArrayList<>();

        dbWorker.findAll().forEach(e -> dollars.add(e.getCurrency()));
        System.out.println(dollars);

    }

}
