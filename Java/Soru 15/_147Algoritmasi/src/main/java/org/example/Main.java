package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("147 formatindaki girmek istediginiz floati giriniz:");
        Scanner input = new Scanner(System.in);
        float sayim = input.nextFloat();
        _147problem coz147 = new _147problem();
        sayim = coz147.sayiUret(sayim);
        System.out.println(sayim);
    }
}