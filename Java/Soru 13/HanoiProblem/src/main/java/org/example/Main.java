package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("hanoı kulenızde ne kadar dısk var? gırınız.");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        hanoiKulesi hanoiKulesiYeni = new hanoiKulesi();
        hanoiKulesiYeni.hanoiKulesiCozum(n,'A','C', 'B');
    }
}