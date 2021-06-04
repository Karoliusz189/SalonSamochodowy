package serwis;

import pracownicy.Klient;
import samochody.Samochod;
import samochody.Wyposarzenie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serwis {
    private List<Samochod> samochody = new ArrayList<>();
    private List<Klient> klienci = new ArrayList<>();

    public Serwis() {
        obiektySamochod();
        obiektyKlienci();
    }

    public void menu() {

        int wybor = wyborSkannerInt("Dzień dobry\n Witamy w naszym salonie samochodowym, jesteśmy dealerem najpopularniejszych " +
                "marek samochodowych w Polsce. \n W czym możemy pomóc? \n 1.Pokaż dostępne samochody. \n 2.Wyjście");
        switch (wybor) {
            case 1:
                menuCase1();
                break;
            case 2:
                System.out.println("Dziękujemy za odwiedzenie salonu");
        }
    }

    private void menuCase1() {
        Samochod samochod = sprawdzenieSamochodu();
        boolean czyKupic = wyborScanerBoolean("Czy chce Pan kupić ten samochód (true/false)");
        if (czyKupic) {
            Klient klient = kupowanieAuta();
            if (klient.getPieniadze() > samochod.getCena()) {
                klient.setPieniadze(klient.getPieniadze() - samochod.getCena());
            } else {
                System.out.println("Brak wystarczającej ilości środków");
            }
        } else {
            System.out.println("Dziękujemy za odwiedzenie naszego salonu");
        }
    }

    public Samochod sprawdzenieSamochodu() {
        Samochod samochod;
        int wybor = wyborSkannerInt("Czy życzy sobie Pan sprawdzenia samochodów po: \n 1.Marce \n 2.Cenie \n 3.Silniku ");
        switch (wybor) {
            case 1:
                samochod = wybranySamochodPoMarce(wyborSkanerString("Wybierz markę samochodu"));
                break;
            case 2:
                samochod = wyborSamochoduPoCenie();
                break;
            case 3:
                samochod = wyborSamochoduPoSilniku(wyborSkanerString("Wybierz rodzaj silnika"));
                break;
            default:
                samochod = samochody.get(1);
        }
        return samochod;
    }

    public Klient kupowanieAuta() {
        boolean czyJestZalogowany = wyborScanerBoolean("Czy jest Pan naszym klientem (True/false)?");
        if (czyJestZalogowany) {
            return logowanieUzytkownika();
        } else {
            return tworzenieNowegoUzytkownika();
        }
    }

    public Klient tworzenieNowegoUzytkownika() {
        return new Klient(wyborSkanerString("Podaj imię"), wyborSkanerString("Podaj nazwisko"),
                wyborSkannerInt("Podaj gotówkę"), wyborSkanerString("Podaj hasło"), wyborSkanerString("podaj login"));

    }

    public Klient logowanieUzytkownika() {
        String login = wyborSkanerString("Prosze podać login");
        String haslo = wyborSkanerString("Prosze podać hasło");
        for (Klient klient : klienci) {
            if (klient.getLogin().equals(login)) {
                if (klient.getHaslo().equals(haslo)) {
                    System.out.println("poprawnie zalogowany");
                    return klient;
                } else {
                    System.out.println("Złe hasło");
                }
            }
        }
        return null;
    }

    private void pokazDostepneSamochody() {
        for (Samochod samochod : samochody) {
            System.out.println(samochod.getMarka() + " " + samochod.getModel());
        }
    }

    private Samochod wybranySamochodPoMarce(String wybor) {
        for (Samochod samochod : samochody) {
            if (samochod.getMarka().toLowerCase().trim().equals(wybor.toLowerCase().trim())) {
                System.out.println(samochod);
                return samochod;
            }
        }
        return null;
    }

    private String wyborSkanerString(String pytanie) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(pytanie);
        return scanner.nextLine();
    }

    private int wyborSkannerInt(String pytanie) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(pytanie);
        return scanner.nextInt();
    }

    private boolean wyborScanerBoolean(String pytanie) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(pytanie);
        return scanner.nextBoolean();
    }


    public Samochod wyborSamochoduPoSilniku(String silnik) {
        for (Samochod samochod : samochody) {
            if (samochod.getSilnik().toLowerCase().trim().equals(silnik.toLowerCase().trim())) {
                System.out.println(samochod);
                return samochod;
            }
        }
        return null;
    }

    public Samochod wyborSamochoduPoCenie() {
        int cena = wyborSkannerInt("Jaką cene możesz zapłacić za auto");
        for (Samochod samochod : samochody) {
            if (samochod.getCena() <= cena) {
                System.out.println(samochod);
                return samochod;
            }
        }
        return null;
    }

    private List<Samochod> obiektySamochod() {
        samochody.add(new Samochod("Mazda", "cx3", "sedan", "1.6TDI", 2021, 150, 1300, Wyposarzenie.SPORT, 45000));
        samochody.add(new Samochod("Ford", "fiesta", "hatchback", "1.4 TDCi", 2021, 95, 1200, Wyposarzenie.ACTIVE, 32000));
        samochody.add(new Samochod("Toyota", "yaris", "sedan", "1.4", 2021, 104, 800, Wyposarzenie.PRESTIGE, 30000));
        samochody.add(new Samochod("Alfa Romeo", "giulietta", "hatchback", "1.5", 2021, 120, 1100, Wyposarzenie.SPORT, 55000));
        samochody.add(new Samochod("Fiat", "Tipo Range", "kombi", "1.4", 2021, 100, 1000, Wyposarzenie.ACTIVE, 20000));
        samochody.add(new Samochod("Suzuki", "Baleno", "Hatchbach", "1.5", 2021, 120, 1400, Wyposarzenie.AMBITION, 30000));
        return samochody;
    }

    private List<Klient> obiektyKlienci() {
        klienci.add(new Klient("Kamil", "Gancarczyk", 40000, "Gancarczyk5", "Kamil2"));
        klienci.add(new Klient("Mariusz", "Florek", 60000, "Mariusz2", "Mariusz26"));
        klienci.add(new Klient("Eugeniusz", "Kłopotek", 120000, "Kłopotek2", "Eugeniusz2"));
        klienci.add(new Klient("Maciej", "Rajski", 80000, "Rajski2", "Maciej2"));
        return klienci;
    }
}
