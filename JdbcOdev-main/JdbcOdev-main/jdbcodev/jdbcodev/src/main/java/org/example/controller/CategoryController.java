package org.example.controller;

import org.example.entities.Category;
import org.example.service.CategoryService;
import org.example.service.UserService;

import java.util.Scanner;

public class CategoryController {
    Scanner src=new Scanner(System.in);
    private static CategoryService categoryService;
    public static CategoryService getInstaceCategory(){
        if (categoryService==null){
            return new CategoryService();
        }return categoryService;
    }




    public void createCategory(){
        Category category=new Category();
        System.out.print("Eklenecek kategori adını giriniz: ");
        String name=src.nextLine();
        category.setCategoryname(name);
        categoryService.createCategory(category);
    }
    public void deleteCategory(){
        categoryService.deleteCategory();
    }
}
