package org.example.utility;

import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;

public class Singleton {

    private static CategoryService categoryService; // statik kaydetmemiz newlemeden ulaşmamızı sağlar

    public static CategoryService getCategoryService() {
        if (categoryService == null){
            categoryService = new CategoryService();
            return categoryService;
        }
        return categoryService;
    }

}
