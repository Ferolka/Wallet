package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.services.CategoryService;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/category")
public class CategoryController extends AbstractController<Category, CategoryService>{


    public CategoryController(CategoryService service) {
        super(service);
    }
}
