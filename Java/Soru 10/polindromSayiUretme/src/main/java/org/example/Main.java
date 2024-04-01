package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Kaca kadar polindrom sayi bulmak istersiniz?");
        int n = sc.nextInt();
        Polindromsayiuretme sayiuret = new Polindromsayiuretme();
        System.out.println("Bulunan polindrom sayilar:");
        sayiuret.Polindromuret(n);
    }
}