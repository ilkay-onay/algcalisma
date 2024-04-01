package org.example;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Buyukten kucuge siralanacak olan rastgele sayi sayiniz ne kadar olmali? lutfen giriniz:");
        Scanner sc= new Scanner(System.in);
        int girilme = sc.nextInt();
        System.out.println("Rastgele sayilariniz minimum kaca kadar olmali? lutfen giriniz:");
        int dusuk = sc.nextInt();
        System.out.println("Rastgele sayilariniz maximum kaca kadar olmali? lutfen giriniz:");
        int yuksek = sc.nextInt();
        int [] benimDizim = new int[girilme];
        rastgeleArray randomSayi = new rastgeleArray();
        randomSayi.rastgeleSayiOlustur(benimDizim,dusuk,yuksek);
        insertionSort Sirala = new insertionSort();
        Sirala.sort(benimDizim);
        for (int i = 0; i < benimDizim.length; i++) {
            System.out.print(benimDizim[i] + " "); // print the modified values of the array
        }
    }
}