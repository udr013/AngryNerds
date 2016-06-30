package eu.programit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.programit.domain.Category;
import eu.programit.service.CategoryService;

@Controller
public class NewCategoryController {


    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "/categorysave", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {
        System.out.println(category);
        categoryService.saveCategory(category);
 
        return "index";
    }



}
