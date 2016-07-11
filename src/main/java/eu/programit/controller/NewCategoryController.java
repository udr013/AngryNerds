package eu.programit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.Category;
import eu.programit.service.ICategoryService;

@Controller
public class NewCategoryController {

	private static String toTheIndexPage = "index";
    @Autowired
    ICategoryService iCategoryService;

  //onderstaande methode zorgt voor het volgende:
    //als je na de pagina localhost:8888/categorysave gaat, wordt er verwacht dat er gegevens op de pagina staan van het type category, die via de variable model
    //beschikbaar zijn in de variabele category (haalt die van de pagina daar is die ook beschikbaar)de iCategoryService zorgt vervolgens voor de afhandeling voor het opslaan
    @RequestMapping(value = "/categorysave", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {
        System.out.println(category);
        iCategoryService.saveCategory(category);
 
        return toTheIndexPage;
    }



}
