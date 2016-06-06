package eu.programit.Controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by udr013 on 1-6-2016.
 */
@RestController
@ComponentScan
public class WebController {

    @RequestMapping("/")
    public String Start(){
        return "index";
    }
}
