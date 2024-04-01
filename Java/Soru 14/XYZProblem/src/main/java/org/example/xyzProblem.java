package org.example;

public class xyzProblem {
    public int harfSay(String cumle) {

        int count = 0;
        for (int i = 0; i < cumle.length(); i++) {
            if (Character.isLetter(cumle.charAt(i)))
                count++;
        }
        return count;
    }

    public void xyzProblemCoz() {
        String cumle1;
        String cumle2;
        String kelimeharf ="on dokuz";
        System.out.println("Cumlede 19 harf vardir");
        int kelime = 19;
        int kelimesayi = 0;
        String soncumle;
        NumberWordConverter sayidonustur = new NumberWordConverter();
        while(kelimesayi!=kelime) {
            kelimesayi = kelime;
            cumle1 = "Cumlede ";
            cumle2 = " harf vardir.";
            soncumle = cumle1 + kelimeharf + cumle2;
            kelime = harfSay(soncumle);
            kelimeharf = sayidonustur.convert(kelime);
            System.out.println(soncumle);
        }
    }
}