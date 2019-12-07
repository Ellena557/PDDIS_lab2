package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MaxRestController {

    @Autowired
    private FinalRbkService finalRbkService;
    MyService myService;

    public MaxRestController(MyService myService) {
        this.myService = myService;
    }

    public MaxRestController() {
        myService = new MyService();
    }

    @RequestMapping("/getNiceMax")
    public Double getMaxDollar(){

        //Double maxDollar = myService.findMax(30);

        return finalRbkService.getMaxCurrency();
    }
}
