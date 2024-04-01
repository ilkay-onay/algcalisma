package org.example;

public class rastgeleArray {

    public int [] rastgeleSayiOlustur(int [] benimDizim, int min, int max)

        {
            int n = benimDizim.length;
            for (int i = 0; i < n; ++i) {
                benimDizim[i] = (int) Math.floor(Math.random() * ((max/2) - (min/2) + 1) + (min/2));
                benimDizim[i] = benimDizim[i]*2;
            }
            return benimDizim;
        }
}