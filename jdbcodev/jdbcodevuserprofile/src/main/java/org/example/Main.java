package org.example;

import org.example.controller.UserController;
import org.example.entities.UserProfile;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController=new UserController();

        UserProfile userProfile=UserProfile.UserProfileBuilder.startBuilder().setEmail("Naime1234").setName("otyom").setPassword("1234").build();
        userController.createUser(userProfile);
        System.out.println(userProfile.toString());


          /*  UserProfile userProfile=new UserProfile();
            userProfile.setEmail("alperensu@gmail.com");
            userProfile.setPassword("alperenefsanedir");

            userController.createUser(userProfile);
            userController.canUserCreateCategory();
            userController.canUserCreateAnotherUser();*/




//Kendi postgresine bağlıydı.cubernetse bağlanıdı//UserProfile=customers,Catogarytable=category olarak değiştirildi.
//Sorgular deneme veritabanına göre değiştirildi.,
//Her sorguda email/password kontrolü yapılmıştı olar çıkarıldı. Kullanıcı doğrulama kontrolü UserControllere eklendi.
//Değişiklikler toStringler yazmıyordu- ekrana bastırmalar düzeltildi.
//kullanıcı delete sorgusu eklendi.
// UserRepostory de bulunan getNameCategory kullanılmamaktadır.. silindi.
//Main kısmı düzenlendi.
//------------------ödev-------------
// UserService classında bulunan "updateUserFields" işlemleri build yapılarak güncellerndi
//category service userserviste singletondan çağrılmıştır.
//category CREATE komutu baserepostory ile bağlantı sağlanmıştır. not: yarım kaldı

        //Scanner
        Scanner scn=new Scanner(System.in);

        int giris;
        boolean dongu=true;

        while (dongu) {
            System.out.println("----->>>>>1_Kullanıcı kayıt \n------->>>>>>2_kullanıcı giriş \n------->>>>>>3_Çıkış");
            giris = scn.nextInt();
            switch (giris) {
                case 1:
                    System.out.println("---------->>>>>>Kayıt ekranına hoşgeldiniz...<<<<<----------------");
                    userController.kullaniciKayit();
                    break;
                case 2:
                    System.out.println("---------->>>>>>Giriş ekranına hoşgeldiniz...<<<<<----------------");
                    userController.kullaniciGiris();
                    break;
                case 3:
                    dongu=false;
                    break;
                default:
                    System.out.println("Yanlış seçim yaptınız...");
            }
        }
    }
    }