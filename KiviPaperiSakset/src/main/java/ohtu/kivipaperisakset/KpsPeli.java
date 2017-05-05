package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KpsPeli {

    private static final Scanner scanner = new Scanner(System.in);
    private String pelimuoto;
    NormiTekoaly tekoaly;

    public void pelaa() {
        String tokanSiirto = null;
        String ekanSiirto = null;        

        Tuomari tuomari = new Tuomari();
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            ekanSiirto = pelaajanSiirto("Ensimmäisen pelaajan siirto: ");
            if ("tekoaly".equals(pelimuoto)) {
                tokanSiirto = tietokoneenSiirto(ekanSiirto);
            } else {
                tokanSiirto = pelaajanSiirto("Toisen pelaajan siirto: ");
            }

            kirjaa(tuomari, ekanSiirto, tokanSiirto);
        }

        lopeta(tuomari);

    }

    private String tietokoneenSiirto(String tokanSiirto) {
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }

    private String pelaajanSiirto(String string) {
        System.out.print(string);
        String siirto = scanner.nextLine();

        return siirto;
    }

    private void kirjaa(Tuomari tuomari, String ekanSiirto, String tokanSiirto) {
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        System.out.println(tuomari);
        System.out.println();
    }

    private void lopeta(Tuomari tuomari) {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
