package org.example.controller;

import org.example.entities.UserProfile;
import org.example.service.UserService;
import org.example.utility.Singleton;

import java.util.Scanner;

public class UserController {
    UserService userService= Singleton.getUserService();
    String email;
    String password;





    public void createUser(UserProfile userProfile){
        userService.createUser(userProfile);
    }

    public void kullaniciKayit(){
        Scanner scn=new Scanner(System.in);
        //Kullanıcı oluşturma
        System.out.println("Adınızı girin: ");
        String ad=scn.nextLine();
        System.out.println("Soyadınızı girin: ");
        String soyad=scn.nextLine();
        System.out.println("E-postanızı girin: ");
        String email=scn.nextLine();
        System.out.println("Kullanıcı adınızı girin: ");
        String username=scn.nextLine();
        System.out.println("Şifrenizi girin: ");
        String password=scn.nextLine();
        UserProfile user=new UserProfile(email,username,password,ad,soyad);
        UserController userController=new UserController();
        userController.createUser(user);
    }
    public boolean kullaniciGiris() {
        Scanner scn=new Scanner(System.in);
        System.out.println("E-mailinizi giriniz: ");
         email =scn.nextLine();
        System.out.println("Şifrenizi giriniz");
       password=scn.nextLine();
        userService.userVarMi(email, password);
        return true;
    }

    public void deleteUser(){
        userService.deleteUsers();
    }
    public void getUsers(){
        userService.getUsers();
    }

    public void updateUserFields(){
String email=null,password=null;
        userService.updateUserFields(email,password);
    }
    public boolean kullaniciKontrol(){
    if (userService.userVarMi(email,password)==true) {
        return true;
    }return false;
    }




}
