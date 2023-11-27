package org.example.service;

import org.example.entities.Category;
import org.example.entities.UserProfile;
import org.example.repository.CategoryRepository;
import org.example.repository.UserRepository;
import org.example.utility.Singleton;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class UserService {
            UserRepository userRepository =new UserRepository();
            CategoryService categoryService= Singleton.getCategoryService();
            private Scanner scannerst=new Scanner(System.in);
            private Scanner scnint=new Scanner(System.in);
            public void createUser(UserProfile userProfile){
                    if(userRepository.getUserExist(userProfile.getEmail(),userProfile.getPassword()).getId()==0){
                            userRepository.createUser(userProfile);
                        System.out.println("Kullanıcınız oluşturulmuştur.");


                    }else{
                        System.err.println("Böyle bir kullanıcı mevcut");
                    }
            }
            public void deleteCategory(){
                Category category=new Category();;
                System.out.println("Hangi kategoriyi silmek istersiniz");
                categoryService.getAllCategory();
                   String categoryName=scannerst.nextLine();
                   category=categoryService.getCategory(categoryName);
                        categoryService.deleteCategory(category);
                System.out.println("Categori silinmiştir. Yeni liste:");
                categoryService.getAllCategory();
            }
            public void createCategory(){
                Category category=new Category();
                    System.out.println("Hangi kategoriyi eklemek istersiniz");
                    String categoryName=scannerst.nextLine();
                    category=categoryService.getCategory(categoryName);
                    if(category.getId()!=0){
                        System.err.println("Böyle bir kategori zaten mevcut");
                    }
                    else{
                        Category category1=new Category();
                        category1.setCategoryname(categoryName);
                        categoryService.createCategory(category1);
                        System.out.println("Category eklenmiştir. yeni liste:");
                        categoryService.getAllCategory();
                    }

                }
            public void updateUserFields(String email, String password){

                UserProfile userProfile=userRepository.getUserExist(email,password);
                System.out.println(userProfile.toString());

                    System.out.println("Hangi alanı güncellemek istersiniz ");
                    System.out.println("1-> Email");
                    System.out.println("2-> Username");
                    System.out.println("3-> Password");
                    System.out.println("4-> Exit");

                    int secenek=scnint.nextInt();
                UserProfile userProfile1=new UserProfile();
                userProfile1=userProfile;
                    switch (secenek){
                        case 1:
                            System.out.println("Girmek istediğiniz email");
                            String updatedEmail=scannerst.nextLine();
                            userProfile1.setEmail(updatedEmail);
                            userRepository.updateUserEmail(userProfile1);
                            System.out.println("kullanıcı email güncellenmiştir");
                            break;
                        case 2:
                            System.out.println("Girmek istediğiniz kullanıcı adı");
                            String updatedUsername=scannerst.nextLine();
                            userProfile1.setUsername(updatedUsername);
                            userRepository.updateUserUsername(userProfile1);
                            System.out.println("kullanıcı adı güncellenmiştir");
                            break;
                        case 3:
                            System.out.println("Girmek istediğiniz şifre");
                            String updatedPassword=scannerst.nextLine();
                            userProfile1.setPassword(updatedPassword);
                            userRepository.updateUserPassword(userProfile1);
                            System.out.println("kullanıcı şifresi güncellenmiştir");
                            break;
                        case 4:
                            break;
                        default:
                            System.err.println("Yanlış seçenek paşam");

                    }
                }


   public boolean userVarMi(String eMail,String password){
        UserProfile userProfile=userRepository.getUserExist(eMail,password);
        if(userProfile.getId()==0){
        return false;}
        return true;}

    public void getUsers(){
         for (UserProfile userProfile: userRepository.getUsers()){
           System.out.println(userProfile.toString()+" ");
         }
            }
    public UserProfile getByUserId(int Id){
            return userRepository.getByUserId(Id);
    }

    public void deleteUsers(){
        UserProfile userProfile=new UserProfile();
        UserService userService=new UserService();
        userService.getUsers();
        System.out.println("silinek kullanıcının id'sini girin: ");
        int userId = scnint.nextInt();
        userProfile = userRepository.getByUserId(userId);

        if (userRepository.getByUserId(userProfile.getId()).getId()!=0){
            userRepository.deleteUser(userProfile);
            System.out.println(userProfile.getName() + " silindi");
        }else {
            System.out.println("kullanıc buunamdadı");
        }
    }


}




