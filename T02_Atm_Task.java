package task01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T02_Atm_Task {


    public static void main(String[] args)
    {


        /*
         * ATM uygulaması yapınız.
         *
         * 1. Adım : Bankamızdaki müşterilerin musteriNumarasi ve 4 haneli şifresini tutan bir HashMap oluşturalım.
         *             Ve şu müşterileri biz ekleyelim.
         *           Integer, Integer
         *
         *           Müşteri No  -- Şifre
         *           12345678      1876
         *           22222222      1234
         *           98765432      1453
         *           55554444      2020
         *
         * 2. Adım : Bankamızdaki müşterilerin hesaplarındaki para miktarini tutan bir tane HashMap oluşturalım.
         *             Ve şu miktarları müşteri numarasıyla birlikte ekleyelim
         *           Integer,Float
         *
         *           Müşteri No  -- Para
         *           12345678      120.0
         *           22222222      3000.0
         *           98765432      7000.0
         *           55554444      50.0
         *
         * 3. Adım : Giriş ekranı oluşturalım. Müşteri buradan giriş yapsın.
         *            Kullanıcı adı ve şifre isteyelim, doğru ise giriş yapsın.
         *
         * 4. Adım : Doğru müşteri numarası ve şifre kontrol eden methodlar yazalım.
         *            musteriNumarasiDogruMu(int no)
         *              Hashmap listemizde varsa, doğru müşteri numarasıdır.
         *
         *           sifreDogruMu (int no, int sifre)
         *              HashMap'teki şifre ile uyuşuyorsa doğru şifredir.
         *
         * 5. Adım : Girş yaptıktan sonra karşısına 3 tane seçenek çıksın :
         *            Bunları da menuGoster() methodu ile yapalım.
         *            1- Para Çek         // 300
         *            2- Para Yükle       // 500 + 100
         *            3- Toplam Paramı Gör  // 200
         *            4- Çıkış Yap
         *
         * 6. Adım : Çıkış methodu oluşturalım.
         *            Giriş yapan müşteri çıkış yapmak isterse, toplamPara ve girisYapanMusteriNo'yu sıfırlayalım.
         *            Tekrar giriş ekranına yöndendirelim.
         *
         * 6. Adım : Toplam parami gor methodu oluşturalım. toplamParamiGor()
         *
         * 7. Adım : 1- Para Çekme Methodu Oluşturalım
         *            Hesaba giriş yapan müşteriye hesabındaki toplam parayı gösterelim.
         *            Kullanıcıdan çekmek istediği tutarı öğrenelim.
         *            Hesabında yeterli para varsa, para çeksin yoksa uyarı verelim.
         *            Çektiği tutarı, toplam parasından düşelim ve kaydedelim.
         *        Başka işlem yapmak isteyip istemediğini soralım, isterse yaptıralım, yoksa çıkış işlemi gerçekleştirelim.
         *
         * 8. Adım : 1- Para Yükleme Methodu Oluşturalım
         *            Hesaba giriş yapan müşteriye hesabındaki toplam parayı gösterelim.
         *            Kullanıcıdan yüklemek istediği tutarı öğrenelim.
         *            Yüklediği tutarı, toplam parasına ekleyelim ve gösterelim.
         *            Başka işlem yapmak isteyip istemediğini soralım, isterse yaptıralım, yoksa çıkış işlemi gerçekleştirelim.
         *
         * *************************************************************************************************/
        //Müşteri No ve Şifreyi tutmak için HashMap oluşturduk.

        //son task metodları asagıda olusturuldu. static olan hashmapleri, bakiye ve metodlarda kullanmak icin scanneri da asagıda olusturdum.
        musteriBilgileri.put(12345678, 1876);
        musteriBilgileri.put(22222222, 1234);
        musteriBilgileri.put(98765432, 1453);
        musteriBilgileri.put(55554444, 2020);
        toplamParaMiktarlari.put(12345678, 120.0f);
        toplamParaMiktarlari.put(22222222, 1000.0f);
        toplamParaMiktarlari.put(98765432, 5.0f);
        toplamParaMiktarlari.put(55554444, 255.0f);

        String kullaniciAdi = "admin";
        String kullaniciSifre = "123";
        boolean istrue = true;

        while (istrue)
        {
            System.out.println("Lütfen Kullanıcı Adını giriniz...");
            String kullanici = input.next();
            System.out.println("Lütfen Kullanıcı şifrenizi giriniz...");
            String sifre = input.next();

            if (kullaniciAdi.equals(kullanici) && kullaniciSifre.equals(sifre))
            {
                while (istrue)
                {
                    System.out.println("Lütfen Müşteri numarasını giriniz...");
                    int musteriNo = input.nextInt();
                    System.out.println("Lütfen Müşteri sifresini giriniz...");
                    int musteriSifre = input.nextInt();

                    if (musteriNumarasiDogruMu(musteriNo) && musteriSifresiDogruMu(musteriSifre))
                    {
                        for (Map.Entry<Integer, Float> w : toplamParaMiktarlari.entrySet())
                        {
                            int key = w.getKey();
                            float value = w.getValue();
                            if (key == musteriNo)
                            {
                                bakiye = value;
                            }
                        }
                        System.out.println("Müsterinin toplam bakiyesi = " + bakiye);
                        menuGoster();
                        toplamParaMiktarlari.replace(musteriNo,bakiye);
                        System.out.println("Son işlemden sonra yeni Banka hesap listesi ---->"+toplamParaMiktarlari);
                        istrue = false;
                    }
                    else System.out.println("Gecerli bir müsteri numarası ve sifresi girmediniz... ");
                }
            }
            else System.out.println("Hatalı giriş yaptınız...");
        }
    }

    static Map<Integer, Integer> musteriBilgileri = new HashMap<>();
    static Map<Integer, Float> toplamParaMiktarlari = new HashMap<>();
    static float bakiye = 0;
    static Scanner input = new Scanner(System.in);

    public static boolean musteriNumarasiDogruMu(int no)
    {
        for (Map.Entry<Integer, Integer> w : musteriBilgileri.entrySet())
        {
            int key = w.getKey();//musteri nosu
            if (key == no)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean musteriSifresiDogruMu(int no)
    {

        for (Map.Entry<Integer, Integer> w : musteriBilgileri.entrySet())
        {
            int value1 = w.getValue();
            if (value1 == no)
            {
                return true;
            }
        }
        return false;
    }

    public static void menuGoster()
    {

        boolean istrue = true;
        while (istrue)
        {
            System.out.println("Lütfen Yapmak istediğiniz işlemi giriniz...");
            System.out.println("1-Para çekme\n2-Para yükle\n3-Hesabım\n4-Menüden Çıkış");
            int islem = input.nextInt();

            switch (islem)
            {
                case 1:
                    paraCekmeMetodu();
                    break;
                case 2:
                    paraYatirmaMetodu();
                    break;
                case 3:
                    System.out.println("Toplam bakiyem = " + bakiye);
                    break;
                case 4:
                    cikis();
                    istrue = false;
                    break;
                default:
                    System.out.println("hatalı giriş...");

            }
        }
    }

    public static void paraCekmeMetodu()
    {
        System.out.println("Lütfen para cekme tutarını giriniz...");
        int tutar = input.nextInt();

        if (tutar < bakiye)
        {
            bakiye -= tutar;
            System.out.println("Toplam bakiyeniz = " + bakiye + " kaldı");
        }
        else System.out.println("Yeterli bakiyeniz bulunmamaktadır...");
    }

    public static void paraYatirmaMetodu()
    {
        System.out.println("Toplam bakiyeniz = " + bakiye);
        System.out.println("Lütfen para yatırılacak tutarı giriniz...");
        int tutar = input.nextInt();

        bakiye += tutar;
        System.out.println("Toplam bakiyeniz = " + bakiye + " oldu..");
    }

    public static void cikis()
    {
        System.out.println("Çıkış Yaptınız...");
        System.out.println("Iyi gunler dileriz");
    }
    // islem bitti.

}

