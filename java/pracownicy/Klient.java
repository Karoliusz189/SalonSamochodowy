package pracownicy;

import samochody.Samochod;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imie;
    private String nazwisko;
    private double pieniadze;
    private String login;
    private String haslo;
    private List<Samochod> samochody;
    public Klient(String imie, String nazwisko, double pieniadze,String haslo,String login){
        this.imie= imie;
        this.nazwisko=nazwisko;
        this.pieniadze=pieniadze;
        this.haslo= haslo;
        this.login= login;
        samochody= new ArrayList<>();
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getPieniadze() {
        return pieniadze;
    }

    public void setPieniadze(double pieniadze) {
        this.pieniadze = pieniadze;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getLogin() {
        return login;
    }

    public List<Samochod> getSamochody() {
        return samochody;
    }

    public String toString(){
        return imie+ " " + nazwisko + " "+ pieniadze;
    }
}
