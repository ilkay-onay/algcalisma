package org.example;

public class rastgeleArray {

    public int [] rastgeleSayiOlustur(int [] benimDizim, int min, int max)

        {
            int n = benimDizim.length;
            for (int i = 0; i < n; ++i) {
                benimDizim[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
            }
            return benimDizim;
        }
}