package restaurant;
import java.util.Scanner;

public class Plat {
    Scanner sc = new Scanner(System.in);
    protected String code;
    protected String nom;
    protected double prix;
    protected int quantiteC; // Quantité commandée globale de ce plat

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteC() {
        return quantiteC;
    }

    public void setQuantiteC(int quantiteC) {
        this.quantiteC = quantiteC;
    }

    public Plat(String code) {
        
        this.code = code; // Correction: Initialisation du code
        System.out.println("Donner le nom du plat");
        this.nom = sc.next();
        System.out.println("Donner le prix du plat");
        this.prix = sc.nextDouble();
        this.quantiteC = 0;
    }

    @Override
    public String toString() {
        return "Plat [Le code=" + code + ", Le nom=" + nom + ", Le prix=" + prix + ", Quantité commandée=" + quantiteC + "]";
    }
}
