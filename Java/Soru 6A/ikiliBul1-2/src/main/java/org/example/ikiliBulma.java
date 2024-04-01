package org.example;

public class ikiliBulma {
    public int ikiliSayisi(int [] benimDizim) {
        int esitSayi = 0;

        for (int i = 0; i < benimDizim.length; i++)
        {
            int index = benimDizim[i] % benimDizim.length;
            benimDizim[index] += benimDizim.length;
        }

        for (int i = 0; i < benimDizim.length; i++)
        {
            if ((benimDizim[i] / benimDizim.length) >= 2)
                esitSayi++;
        }

        return esitSayi;
    }
}

