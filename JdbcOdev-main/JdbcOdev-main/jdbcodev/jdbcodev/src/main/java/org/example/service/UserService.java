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



    private static UserRepository userRepository;
    public static UserRepository getInstance(){
        if (userRepository==null){
            return new UserRepository();
        }else {
            return userRepository;
        }
    }




    UserRepository yeniRepo=getInstance();
    private Scanner scannerst=new Scanner(System.in);
    private Scanner scnint=new Scanner(System.in);








    public void createUser(UserProfile userProfile){
        if(yeniRepo.getUserExist(userProfile.getEmail(),userProfile.getPassword()).getId()==0){
            yeniRepo.create(userProfile);
            System.out.println("Kullanıcınız oluşturulmuştur.");


        }else{
            System.err.println("Böyle bir kullanıcı mevcut");
        }
    }

    public void updateUserFields(String email, String password){

        UserProfile userProfile=yeniRepo.getUserExist(email,password);
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
                yeniRepo.updateUserEmail(userProfile1);
                System.out.println("kullanıcı email güncellenmiştir");
                break;
            case 2:
                System.out.println("Girmek istediğiniz kullanıcı adı");
                String updatedUsername=scannerst.nextLine();
                userProfile1.setUsername(updatedUsername);
                yeniRepo.updateUserUsername(userProfile1);
                System.out.println("kullanıcı adı güncellenmiştir");
                break;
            case 3:
                System.out.println("Girmek istediğiniz şifre");
                String updatedPassword=scannerst.nextLine();
                userProfile1.setPassword(updatedPassword);
                yeniRepo.updateUserPassword(userProfile1);
                System.out.println("kullanıcı şifresi güncellenmiştir");
                break;
            case 4:
                break;
            default:
                System.err.println("Yanlış seçenek paşam");

        }
    }


    public boolean userVarMi(String eMail,String password){
        UserProfile userProfile=yeniRepo.getUserExist(eMail,password);
        if(userProfile.getId()==0){
            return false;}
        return true;}

    public void getUsers(){
        for (UserProfile userProfile: yeniRepo.getUsers()){
            System.out.println(userProfile.toString()+" ");
        }
    }

    public void deleteUsers(){
        UserProfile userProfile=new UserProfile();
        UserService userService=new UserService();
        userService.getUsers();
        System.out.println("silinek kullanıcının id'sini girin: ");
        int userId = scnint.nextInt();
        userProfile = yeniRepo.getByUserId(userId);

        if (yeniRepo.getByUserId(userProfile.getId()).getId()!=0){
            yeniRepo.delete(userProfile);
            System.out.println(userProfile.getName() + " silindi");
        }else {
            System.out.println("kullanıc buunamdadı");
        }
    }


}




