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
	
	//Strings met logische namen voor verwijzing naar html pagina
	private String ToRegisterPage = "register";
	private String RedirectToLoginPage = "redirect:/login";
		
	//Hieronder vind je het eigenlijke programma mbt de gebruikers   	
    @Autowired
    IUserService IUserService; //Hier wordt een nieuw object gemaakt van de IUserService, zodat de
		 					   //methodes van de UserService gebruikt kunnen worden (save en get).
		 					   //In de toekomst zou hier ook nog delete bij kunnen voor de administrator.
		 					   //De methode deleteUser is al beschikbaar in de UserService.
		 					   //En in de toekomst zou de administrator de user moeten kunnen wijzigen.

    @RequestMapping("/register")
    public String registerPage(Model model){
       Collection<User> allUsers = IUserService.getAllUsers();
        for(User user:allUsers){
            System.out.println(user);
        }
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", allUsers);
        return ToRegisterPage;
    }

    @RequestMapping(value = {"/register/save"}, method = RequestMethod.POST)
        public String registerPage( @ModelAttribute("user") User user) {
        IUserService.saveUser(user);
        System.out.println(user);
        System.out.println("saving user");
        return RedirectToLoginPage;

    }
    //Dit gedeelte wordt gebruikt om uit te kunnen loggen. Dit gedeelte haalt methodes op van Springboot Authentication.
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return RedirectToLoginPage;//generally it's a good practice to show login screen again.
    }
}
