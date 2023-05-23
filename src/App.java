import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    /*
     * Uygulama amacımız bize gösterilen malzemeler içinde elimizde olanları seçip
     * programın bize hangi yemeği yapacağını göstermesidir
     * programımızda 8 yemek kayitli ve 38 malzeme kayitlidir
     * (daha detayli yapılabilir ama amacımız oop ve nasıl bir algoritma kurduğumuz)
     * programımızın calisma mantıği su sekilde
     * sectiğimiz malzemeleri en cok iceren yemeği oneriyor
     * Programımızın adı Yemek tarifi yömetim sistemi ya da bügün ne yapsam
     */
    public static void main(String[] args) throws Exception {
        // Malzeme sınıfımızda tüm malzemeleri içeren bir list var
        Malzeme m = new Malzeme();
        // ekleyeceğimiz malzemeler için bir list tanimladim
        List<String> malzemeEkle = new ArrayList<String>();
        // try catch kullanildi
        try (Scanner scan = new Scanner(System.in)) {
            int sayi = 0;
            int secenek = 0;
            System.out.println("Yemek Tarifi Yönetimine Hosgeldiniz");
            System.out.println("Malzemeler asagida olduğu gibidir");
            // Malzemeleri listeleyen for döngüsü
            System.out.println("----Malzemeler----");
            for (String malzeme : m.getMalzemeler()) {
                sayi++;
                System.out.println(sayi + "-" + malzeme + " ");
            }
            // listeye malzeme eklemek için index
            int malzemeSayac = 0;
            // malzeme sınıfından getireceğimiz malzemelerin indexini alacaz
            int index;
            while (true) {
                // Aciklama kismi
                System.out.println();
                System.out.println("İstediğinz malzemeleri eklemek için 1 e tiklayin");
                System.out.println();
                System.out.println("Malzemeleri sectiyseniz 99 tuşuna basin");
                secenek = scan.nextInt();
                // secenege göre switch case yapisi
                switch (secenek) {
                    case 1:
                        do {
                            System.out.print("Lütfen 1-ile 38 arasinda bir index gir: ");
                            index = scan.nextInt();
                        } while (index > 38 || index < 0);
                        malzemeEkle.add(malzemeSayac++, m.getMalzemeler()[index - 1]);

                        System.out.println("malzeme eklendi");
                        continue;
                    case 99:
                        // ekledigimiz malzemeleri for döngüsü ile gösteriyoruz
                        System.out.println();
                        System.out.println("----Malzemeleriniz----");
                        secilenMalzemeGoster(malzemeEkle);
                        break;
                }
                break;

            }
        }
        // Yemeklerin liste halinde buşunduğu sınıftan yemekleri aliyoruz
        Yemek[] yemekliste = YemekListesi.getYemekler();
        // sectigimiz malzemelerin uzunlugu
        int kacMalzeme = malzemeEkle.size();
        String[] mList = new String[kacMalzeme];
        int sayac = 0;
        // string methodunun equals sını kullancağımız için List yapisini
        // string[] dizine ceviriyoruz
        for (int i = 0; i < malzemeEkle.size(); i++) {
            mList[i] = malzemeEkle.get(i);
        }
        // System.out.println(Arrays.toString(mList));

        // en fazla icerigin tutugu yemeği anlamak için max degiskeni
        int max = 0;
        // secilen yemegin indexini almak için degisken tanımladik
        int secilenYemek = 0;
        // System.out.println(kacMalzeme);
        // System.out.println(Arrays.toString(yemekliste[0].getMalzemeler()));

        /*
         * şimdi asil algoritmamımızı kurdugumuz yapi öncelikle
         * yemekleri for ile aliyoruz
         * sonra for ile yemeklerin malzemesini alıyoruz
         * son olarak sectigimiz malzemeleri for ile alıyoruz
         * ve algorimamızı kuruyoruz
         * sectigimiz malzemeler eger yemeklerin malzemesinde var ise
         * sayacimiz bir artıllıyor
         * ve yeni yemege gecerken sayac=0 a eşitleniyor
         * ve yemek indeximiz bir artıllıyor
         * cunku sayacın her bir yemege özgü arması gerekiyor
         * ve yukarda degisken olarak tanımladığımız max 'ın algoritmasını
         * kuruyoruz sayac eger maxdan büyükse maxın yeni degeri sayac oluyor
         * boylece en fazle malzemenin yemekte oldugunu buluyoruz
         * ve secilen yemek indeximize atıyoruz
         * secilen yemegi konsolda yazdiriyoruz
         */
        int yemekİndex = 0;
        for (Yemek yemek : yemekliste) {
            for (String yMalzeme : yemek.getMalzemeler()) {
                for (String secilen : mList) {
                    if (secilen.equals(yMalzeme)) {
                        sayac++;
                        // System.out.println(sayac);
                    }
                }

            }

            if (sayac > max) {
                max = sayac;
                secilenYemek = yemekİndex;
            }
            System.out.println(max);
            sayac = 0;
            yemekİndex++;
        }

        System.out.println();
        System.out.println("----Programin önerdiği yemek Malzemeleri----");
        YemekMalzemeGoster(yemekliste[secilenYemek].getMalzemeler());
        System.out.println();
        System.out.println(
                "sectiğiniz malzemelere göre " + yemekliste[secilenYemek].getYemekAd() + " yemeğini yapabilirsin");
        System.out.println("tam " + max + " tane icerik uyustu");
    }

    public static void secilenMalzemeGoster(List<String> malzemeEkle) {
        for (String a : malzemeEkle) {
            System.out.println(a + " ");
        }
    }

    public static void YemekMalzemeGoster(String[] yMalzeme) {
        for (String a : yMalzeme) {
            System.out.println(a + " ");
        }
    }
}
