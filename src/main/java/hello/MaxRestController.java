package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MaxRestController {

    MyService myService;

    public MaxRestController(MyService myService) {
        this.myService = myService;
    }

    public MaxRestController() {
        myService = new MyService();
    }

    @RequestMapping("/getNiceMax")
    public Double getMaxDollar(){

        Double maxDollar = myService.findMax(30);

        return maxDollar;
    }
}
