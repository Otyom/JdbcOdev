package org.example.utility;

import org.example.controller.UserController;
import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;
import org.example.service.UserService;

public class Singleton {

    private static CategoryService categoryService; // statik kaydetmemiz newlemeden ulaşmamızı sağlar
    private static UserService userService;
    private static UserController userController;






    public static CategoryService getCategoryService() {
        if (categoryService == null){
            categoryService = new CategoryService();
            return categoryService;
        }
        return categoryService;
    }

    public static UserService getUserService(){
        if (userService==null){
            return new UserService();
        }
        return userService;
    }

    public static UserController getUserController(){
        if (userController==null){
            return new UserController();
        }
        return userController;
    }

}
