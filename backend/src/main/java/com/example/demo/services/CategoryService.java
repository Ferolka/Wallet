package com.example.demo.services;

import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category, CategoryRepository> {

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
