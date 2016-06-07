package eu.programit.Controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by udr013 on 1-6-2016.
 */
<<<<<<< HEAD
@Controller
=======
@RestController
@ComponentScan
>>>>>>> 21415622fbbbcbe9d39ee62bfd0943fda0619bfc
public class WebController {

    @RequestMapping("/test")
    public String Start(){
        return "index.html";
    }
}
