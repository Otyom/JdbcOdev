package org.example.service;

import org.example.entities.Category;
import org.example.repository.CategoryRepository;

import java.util.Scanner;

public class CategoryService {

    CategoryRepository categoryRepository=new CategoryRepository();
    private Scanner scannerst=new Scanner(System.in);




    public boolean createCategory(Category category){

                if(categoryRepository.getByCategoryName(category.getCategoryname()).getId()==0){
                        categoryRepository.create(category);
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
    public void getAllCategory(){
        for(Category c:categoryRepository.gelAll()){
            System.out.print(c.getCategoryname().toString()+" ");
        }
    }
    public void deleteCategory(){
        Category category;
        System.out.println("Hangi kategoriyi silmek istersiniz");
        categoryRepository.gelAll();
        String categoryName=scannerst.nextLine();
        category=categoryRepository.getByCategoryName(categoryName);
        categoryRepository.delete(category);
        System.out.println("Categori silinmiştir. Yeni liste:");
        categoryRepository.gelAll();
    }

}
