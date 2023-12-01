package org.example;

import org.example.controller.CategoryController;
import org.example.controller.UserController;
import org.example.entities.UserProfile;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scint=new Scanner(System.in);
        Scanner scn=new Scanner(System.in);


        UserController userController=new UserController();
        CategoryController categoryController=new CategoryController();


        //builder
        UserProfile userProfile=UserProfile.UserProfileBuilder.startBuilder().setEmail("Naime1234").setName("otyom").setPassword("1234").build();
        userController.createUser(userProfile);
        System.out.println(userProfile.toString());



//*********************************************************************YAPILAN DEĞİŞİKLİKLER********************************************************************************************************************//

//Kendi postgresine bağlıydı.cubernetse bağlanıdı//UserProfile=customers,Catogarytable=category olarak değiştirildi.
//Sorgular deneme veritabanına göre değiştirildi.,
//Her sorguda email/password kontrolü yapılmıştı olar çıkarıldı. Kullanıcı doğrulama kontrolü UserControllere eklendi.
//Değişiklikler toStringler yazmıyordu- ekrana bastırmalar düzeltildi.
//kullanıcı delete sorgusu eklendi.
// UserRepostory de bulunan getNameCategory kullanılmamaktadır.. silindi.
//Main kısmı düzenlendi.


//------------------ödev-------------
// Mainde build ile yeni bir kullanıcı oluşturuldu.
//Category ve User servisler singleton ile çağrılmıştır.
//categoryRepostory,userrepository create/delete komutu baserepostory ile bağlantı sağlanmıştır.
//User service'de repo consructor ile yenilenmiştir.




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
                    if (userController.kullaniciKontrol()==true){
                        boolean anaDongu = true;
                        while (anaDongu) {
                            System.out.println("\n----->>>>>1_Category ekle \n----->>>>>2_Category sil  \n----->>>>>3_Kullanıcı Ekle  \n----->>>>>4_Profilinizi güncelleyin \n----->>>>>5_Kullanıcıları listele \n----->>>>>6_Kullanıcı sil \n----->>>>>7_Çıkış");
                            int secenek = scint.nextInt();
                            switch (secenek) {
                                case 1:
                                    categoryController.createCategory();
                                    break;
                                case 2:
                                  categoryController.deleteCategory();
                                    break;
                                case 3:
                                    userController.kullaniciKayit();
                                    break;
                                case 4:
                                   userController.updateUserFields();
                                    break;
                                case 5:
                                   userController.getUsers();
                                    break;
                                case 6:
                                    userController.deleteUser();
                                    break;
                                case 7:
                                    anaDongu = false;
                                    break;
                                default:
                                    System.out.println("Yanlış seçim yaptın paşam (alpernenin yazım şekline göre yazıldı:)))");
                            }
                        }
                    }
                    else{
                        System.out.println("Kullanıcı Bulunamadı.");
                    }
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