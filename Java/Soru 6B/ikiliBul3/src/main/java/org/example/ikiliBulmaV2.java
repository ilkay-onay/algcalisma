package org.example;

public class ikiliBulmaV2 {
    public void ikiliSayisi(int [] benimDizim) {
        int ikilisayi = 0;
        System.out.println();
        System.out.println("Tekrar eden sayilar:");
        for (int i = 0; i < benimDizim.length - 1; i++)
            if (benimDizim[i] == benimDizim[i + 1]) {
                System.out.print(benimDizim[i] + " ");
                ikilisayi = ikilisayi + 1;
            }
        System.out.println();
        System.out.println("Ikililerin sayısı:");
        System.out.println(ikilisayi);
    }

}

