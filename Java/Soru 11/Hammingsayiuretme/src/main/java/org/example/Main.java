package org.example;

public class Main {
    public static void main(String[] args) {
        hummingUretme hummingsayi = new hummingUretme();
        System.out.print("Ilk yirmi hamming sayilari =");
        for (int i = 1; i < 21; i++)
            System.out.print(" " + hummingsayi.hamming(i));
    }
    }