package samochody;

public class Samochod {
    private String marka;
    private String model;
    private String typNadwozia;
    private String silnik;
    private int rokProdukcji;
    private int konieMechaniczne;
    private int waga;
    private  Wyposarzenie wyposarzenie;
    private double cena;
    public Samochod(String marka,String model,String typNadwozia,String silnik,int rokProdukcji,int konieMechaniczne,int waga,Wyposarzenie wyposarzenie,double cena){
        this.marka=marka;
        this.model=model;
        this.typNadwozia=typNadwozia;
        this.silnik=silnik;
        this.rokProdukcji=rokProdukcji;
        this.konieMechaniczne=konieMechaniczne;
        this.waga= waga;
        this.wyposarzenie=wyposarzenie;
        this.cena=cena;

    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }
    public String getSilnik () { return silnik;}

    public double getCena() {
        return cena;
    }

    public String toString(){
        return marka+ " "+model+ " "+typNadwozia+" "+ silnik+" " + rokProdukcji +" "+konieMechaniczne+ " "+ waga + " "+ wyposarzenie+" "+ cena;
    }

}
