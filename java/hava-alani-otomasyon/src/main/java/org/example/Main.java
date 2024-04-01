import java.util.PriorityQueue;

class Ucus implements Comparable<Ucus> {
    private int zamanPeriyodu;

    public Ucus(int zamanPeriyodu) {
        this.zamanPeriyodu = zamanPeriyodu;
    }

    public int getZamanPeriyodu() {
        return zamanPeriyodu;
    }

    @Override
    public int compareTo(Ucus digerUcus) {
        return Integer.compare(this.zamanPeriyodu, digerUcus.getZamanPeriyodu());
    }
}

class HavalimaniOtomasyonu {
    private PriorityQueue<Ucus> ucusKuyrugu;

    public HavalimaniOtomasyonu() {
        ucusKuyrugu = new PriorityQueue<>();
    }

    public void ucusEkle(int zamanPeriyodu) {
        Ucus ucus = new Ucus(zamanPeriyodu);
        ucusKuyrugu.add(ucus);
        System.out.println("Uçuş eklendi: " + ucus.getZamanPeriyodu());
    }

    public int sonrakiOlayinZamanPeriyodu() {
        if (!ucusKuyrugu.isEmpty()) {
            Ucus sonrakiUcus = ucusKuyrugu.poll();
            return sonrakiUcus.getZamanPeriyodu();
        }
        return -1;
    }
}

class AnaSinif {
    public static void main(String[] args) {
        HavalimaniOtomasyonu otomasyon = new HavalimaniOtomasyonu();

        otomasyon.ucusEkle(10);
        otomasyon.ucusEkle(5);
        otomasyon.ucusEkle(15);

        int sonrakiOlayZamanPeriyodu = otomasyon.sonrakiOlayinZamanPeriyodu();
        System.out.println("Sonraki olayın zaman periyodu: " + sonrakiOlayZamanPeriyodu);
    }
}

