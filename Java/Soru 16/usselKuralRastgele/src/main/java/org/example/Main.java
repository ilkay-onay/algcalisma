package org.example;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
            long N = 100;
            float r = 0;
            float alpha = -2;
            float x0 = 1;
            float x1 = 10;
            long i;
            float p0 = 0, p1 = 0;
            float E = 0;
            p0 = (float)Math.pow(x0, alpha + 1);
            p1 = (float)Math.pow(x1, alpha + 1);
            System.out.println("x^(-2) fonksiyonu tayfı benzeri rastgele sayı üretimi yapiliyor.");
            System.out.println();
            for (i = 0; i < N; i++) {
                r = (float)ran.nextInt()/ Integer.MAX_VALUE;
                if (r == 0) {
                    continue;
                }
                E = (float)Math.pow(r * (p1 - p0) + p0, 1.0 / (alpha + 1.0));
                System.out.print(E + " ");
            }
    }
}