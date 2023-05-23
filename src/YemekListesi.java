public class YemekListesi {

    public static Yemek[] getYemekler() {
        Karniyarik karniyarik = new Karniyarik();
        Buryan buryan = new Buryan();
        Iclikofte iclikofte = new Iclikofte();
        Kebap kebap = new Kebap();
        Kurufasulye kurufasulye = new Kurufasulye();
        Manti manti = new Manti();
        Sarma sarma = new Sarma();
        Tavuksote tavuksote = new Tavuksote();
        Yemek[] yemekler = { karniyarik, buryan, iclikofte, kebap, kurufasulye, manti, sarma, tavuksote };
        return yemekler;
    }
}
