package org.example;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("n elemanı olan A dizisi veriliyor, A dizisinin sayilari rastgele uretilecek. n sayisini lutfen giriniz:");
        Scanner sc= new Scanner(System.in);
        int girilme = sc.nextInt();
        System.out.println("Rastgele sayilariniz minimum kaca kadar olmali? lutfen giriniz:");
        int dusuk = sc.nextInt();
        System.out.println("Rastgele sayilariniz maximum kaca kadar olmali? lutfen giriniz:");
        int yuksek = sc.nextInt();
        int [] benimDizim = new int[girilme];
        rastgeleArray randomSayi = new rastgeleArray();
        randomSayi.rastgeleSayiOlustur(benimDizim,dusuk,yuksek);
        System.out.println("A dizisinin rastgele olusturulan sayilari: ");
        for (int i = 0; i < benimDizim.length; i++) {
            System.out.print(benimDizim[i] + " ");
        }
        ikiliBulma ikili = new ikiliBulma();
        int ikiliSayiSayisi = ikili.ikiliSayisi(benimDizim);
        System.out.println();
        System.out.println("A dizisindeki ikili sayi sayisi: ");
        System.out.print(ikiliSayiSayisi);
    }
}