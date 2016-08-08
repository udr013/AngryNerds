package eu.programit.controller;


import eu.programit.domain.User;
import eu.programit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;


@Controller
public class UserController {

		

    @Autowired
    IUserService iUserService;

    @RequestMapping("/register")
    public String registerPage(Model model){
       Collection<User> allUsers = iUserService.getAllUsers();
        for(User user:allUsers){
            System.out.println(user);
        }
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", allUsers);
        return "register";
    }

    @RequestMapping(value = {"/register/save"}, method = RequestMethod.POST)
        public String registerPage( @ModelAttribute("user") User user, Model model) {
        if(user.getPassword().equals(user.getConfirmPassword())&&user.getPassword()!=null) {
            try {
                iUserService.saveUser(user);


            } catch (org.springframework.dao.DataIntegrityViolationException e) {
                model.addAttribute("registerError", true);
                user.setUsername(null);
                return "register";
            }
        }else {
            model.addAttribute("passwordError",true);
            user.setPassword(null);
            user.setConfirmPassword(null);
            return "register";
        }
        model.addAttribute("registered", true);
        return "login"; //do not use redirect or errormessage will not be displayed

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";//generally it's a good practice to show login screen again.
    }
}
