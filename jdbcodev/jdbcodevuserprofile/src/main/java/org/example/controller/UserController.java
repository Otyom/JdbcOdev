package org.example.controller;

import org.example.entities.UserProfile;
import org.example.service.UserService;

import java.util.Scanner;

public class UserController {

    UserService userService=new UserService();
    private  Scanner scannerint=new Scanner(System.in);
    public void createUser(UserProfile userProfile){
        userService.createUser(userProfile);
    }

    //example builder

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
    public void kullaniciGiris() {
        Scanner scannerst = new Scanner(System.in);
        String email = "alperen@gmail.com";
        String password = "Cirtil";

        System.out.println("E-mailinizi giriniz");
        email = scannerst.nextLine();
        System.out.println("Şifrenizi giriniz");
        password = scannerst.nextLine();
        userService.userVarMi(email, password);
        if (userService.userVarMi(email, password) == true) {
            boolean anaDongu=true;
            while (anaDongu) {
                System.out.println("\n----->>>>>1_Category ekle \n----->>>>>2_Category sil  \n----->>>>>3_Kullanıcı Ekle  \n----->>>>>4_Profilinizi güncelleyin \n----->>>>>5_Kullanıcıları listele \n----->>>>>6_Kullanıcı sil \n----->>>>>7_Çıkış");
                int secenek=scannerint.nextInt();
                switch (secenek) {
                    case 1:
                        userService.createCategory();
                        break;
                    case 2:
                        userService.deleteCategory();
                        break;
                    case 3:
                        Scanner scn=new Scanner(System.in);
                        //Kullanıcı oluşturma
                        System.out.println("Adınızı girin: ");
                        String ad=scn.nextLine();
                        System.out.println("Soyadınızı girin: ");
                        String soyad=scn.nextLine();
                        System.out.println("E-postanızı girin: ");
                        String emaill=scn.nextLine();
                        System.out.println("Kullanıcı adınızı girin: ");
                        String username=scn.nextLine();
                        System.out.println("Şifrenizi girin: ");
                        String passwordd=scn.nextLine();
                        UserProfile user=new UserProfile(emaill,username,passwordd,ad,soyad);
                        UserController userController=new UserController();
                        userController.createUser(user);
                        break;
                    case 4:
                        userService.updateUserFields(email,password);
                        break;
                    case 5:
                        userService.getUsers();
                        break;
                    case 6:
                 userService.deleteUsers();
                 break;
                    case 7:
                        anaDongu=false;
                        break;
                    default:
                        System.out.println("Yanlış seçim yaptın paşam (alpernenin yazım şekline göre yazıldı:)))");
                }
            }
        }
        else{
            System.out.println("Kullanıcı Bulunamadı.");
        }
    }





}
