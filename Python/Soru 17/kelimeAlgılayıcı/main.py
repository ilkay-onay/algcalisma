import nltk
import random
import string

nltk.download('words')
kelime_listesi = set(word.lower() for word in nltk.corpus.words.words())

def rasgele_dizi_olustur(uzunluk):
    return ''.join(random.choices(string.ascii_lowercase, k=uzunluk))

def gecerli_kelimeleri_bul(rasgele_dizi):
    gecerli_kelimeler = []
    n = len(rasgele_dizi)
    for i in range(n):
        for j in range(i + 3, n + 1):
            kelime = rasgele_dizi[i:j]
            if kelime in kelime_listesi:
                gecerli_kelimeler.append(kelime)
    return gecerli_kelimeler

gecerli_kelime_sayisi = int(input("Kaç geçerli kelime bulmak istiyorsunuz? "))
gecerli_ingilizce_kelime_sayisi = 0
dizi_uzunluk_toplami = 0

while gecerli_ingilizce_kelime_sayisi < gecerli_kelime_sayisi:
    rasgele_dizi = rasgele_dizi_olustur(50)
    gecerli_kelimeler = gecerli_kelimeleri_bul(rasgele_dizi)
    gecerli_ingilizce_kelimeler = [kelime for kelime in gecerli_kelimeler if kelime in kelime_listesi]
    gecerli_ingilizce_kelime_sayisi += len(gecerli_ingilizce_kelimeler)
    dizi_uzunluk_toplami += len(rasgele_dizi)

oran = gecerli_ingilizce_kelime_sayisi / dizi_uzunluk_toplami
print("Bulunan geçerli İngilizce kelimelerin sayısı: ", gecerli_ingilizce_kelime_sayisi)
print("Oluşturulan dizilerin uzunluk toplamı: ", dizi_uzunluk_toplami)
print("Geçerli İngilizce kelimelerin sayısının oluşturulan dizilerin uzunluk toplamına oranı: ", oran)
