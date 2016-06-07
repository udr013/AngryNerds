package eu.programit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by udr013 on 1-6-2016.
 */

@Controller
public class WebController {

	@RequestMapping("/test")
	public String Start() {
		return "index.html";
	}
}
