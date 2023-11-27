package org.example.service;

import org.example.entities.Category;
import org.example.repository.CategoryRepository;

public class CategoryService {

    CategoryRepository categoryRepository=new CategoryRepository();


    public boolean createCategory(Category category){

                if(categoryRepository.getByCategoryName(category.getCategoryname()).getId()==0){
                        categoryRepository.createCategory(category);
                        return true;
                }else{
                    System.err.println("Böyle bir kategori zaten mevcut kanka");
                    category.toString();
                    return false;
                }
    }

    public Category getCategory(String categoryName){
       return categoryRepository.getByCategoryName(categoryName);

    }
    public boolean deleteCategory(Category category){
        return categoryRepository.deleteCategory(category);
    }

    public void getAllCategory(){
        for(Category c:categoryRepository.gelAll()){
            System.out.print(c.getCategoryname().toString()+" ");
        }
    }

}
