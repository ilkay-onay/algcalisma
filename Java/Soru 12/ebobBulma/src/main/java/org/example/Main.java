package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Birinci sayinizi giriniz:");
        int n1 = input.nextInt();
        System.out.println("Ikinci sayinizi giriniz:");
        int n2 = input.nextInt();
        Ebob ebobBul = new Ebob();
        int ebob = ebobBul.ebob(n1, n2);

        System.out.printf("Girdiginiz %d ve %d sayisinin ebobu : %d.", n1, n2, ebob);
    }
}