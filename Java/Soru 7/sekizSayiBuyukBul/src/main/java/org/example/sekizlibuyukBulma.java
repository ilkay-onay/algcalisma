package org.example;

public class sekizlibuyukBulma {

    public void sekizlibuyukBul(int [] sekizliDizi){
        int enBuyukSayi=sekizliDizi[0];
        int enBuyukIkinciSayi=sekizliDizi[0];
        for(int i=0;i<8;i++){
            if((sekizliDizi[i] > enBuyukIkinciSayi) && (sekizliDizi[i] != enBuyukIkinciSayi)) {
                enBuyukIkinciSayi = enBuyukSayi;
                enBuyukSayi = sekizliDizi[i];
            }
            if(enBuyukSayi < enBuyukIkinciSayi){
                int temp = enBuyukSayi;
                enBuyukSayi = enBuyukIkinciSayi;
                enBuyukIkinciSayi = temp;

            }

        }
        System.out.println("En buyuk sayi:");
        System.out.println(enBuyukSayi);
        System.out.println("En buyuk ikinci sayi:");
        System.out.println(enBuyukIkinciSayi);
    }
}
