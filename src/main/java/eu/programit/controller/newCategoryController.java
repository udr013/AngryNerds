package eu.programit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by udr013 on 16-6-2016.
 */

import eu.programit.domain.Answer;
import eu.programit.domain.Category;
import eu.programit.domain.Question;
import eu.programit.service.ICategoryService;

@Controller
public class newCategoryController {


    @Autowired
    ICategoryService iCategoryService;


    @RequestMapping(value = "/categorysave", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {
        System.out.println(category);
        iCategoryService.saveCategory(category);
 
        return "category";
    }



}
