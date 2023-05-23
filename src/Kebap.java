public class Kebap extends Yemek {

    public Kebap() {

        yemekAd = "kebap";
    }

    final String[] malzemeler = {
            "kiyma",
            "sogan",
            "kuyruk yagi",
            "sarimsak",
            "biber",
            "tuz",
            "karabiber",
            "pulbiber"
    };

    public String[] getMalzemeler() {
        return malzemeler;
    }

}
