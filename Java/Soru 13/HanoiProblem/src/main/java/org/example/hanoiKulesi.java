package org.example;

public class hanoiKulesi {

    static void hanoiKulesiCozum(int n, char from_rod, char to_rod, char helper_rod)
    {
        if (n == 1)
        {
            System.out.println("1.diski " +  from_rod + ". cubuktan al ve " + to_rod + ". cubuga koy.");
            return;
        }
        hanoiKulesiCozum(n-1, from_rod, helper_rod, to_rod);
        System.out.println(n + ".diski " +  from_rod + ". cubuktan al ve " + to_rod + ". cubuga koy.");
        hanoiKulesiCozum(n-1, helper_rod, to_rod, from_rod);
    }
}
