package eu.programit.Controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by udr013 on 1-6-2016.
 */
@Controller
@ComponentScan
public class WebController {

    @RequestMapping("/")
    public String Start(){
        return "index";
    }
}
