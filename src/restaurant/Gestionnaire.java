package restaurant;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Gestionnaire {
    Scanner sc = new Scanner(System.in);
    int code = 1; // Code de commande auto-incrémenté
    
    private ArrayList<Plat> listPlat;
    private ArrayList<Commande> listCmd;

    public Gestionnaire() {
        listPlat = new ArrayList<>();
        listCmd = new ArrayList<>();
    }

    public Plat Rech_Plat(String code) {
        for (Plat plat : listPlat) {
            if (code.equals(plat.getCode())) {
                return plat;
            }
        }
        return null;
    }

    public void AjoutPlat() {
        System.out.printf("Donner le code du plat: ");
        String code = sc.next();
        
        if (Rech_Plat(code) == null) {
            int choix;
            do {
                System.out.printf("Voulez-vous ajouter?\n 1- Si entrée\n 2- Si suite\n 3- Si dessert\n");
                choix = sc.nextInt();
            } while (!(choix == 1 || choix == 2 || choix == 3));

            switch (choix) {
                case 1:
                    listPlat.add(new Entree(code));
                    break;
                case 2:
                    listPlat.add(new Suite(code));
                    break;
                case 3:
                    listPlat.add(new Dessert(code));
                    break;
            }
            System.out.println("✅ Plat ajouté avec succès !");
        } else {
            System.out.println("⚠ Ce code du plat existe déjà !");
        }
    }

    public void AffichagePlat() {
        System.out.println("Entrée:");
        for (Plat plat : listPlat) {
            if (plat instanceof Entree) System.out.println(plat);
        }
        
        System.out.println("Suite:");
        for (Plat plat : listPlat) {
            if (plat instanceof Suite) System.out.println(plat);
        }
        
        System.out.println("Dessert:");
        for (Plat plat : listPlat) {
            if (plat instanceof Dessert) System.out.println(plat);
        }
    }
    public void Modifier() {
        System.out.println("Entrez le code du plat: ");
        String cd = sc.next();
        Plat plat = Rech_Plat(cd);

        if (plat != null) {
            int choix;
            do {
                System.out.println("Que voulez-vous modifier?\n 1 - Code\n 2 - Nom\n 3 - Prix\n");
                choix = sc.nextInt();
            } while (!(choix == 1 || choix == 2 || choix == 3));

            switch (choix) {
                case 1:
                    System.out.println("Entrez le nouveau code: ");
                    String code = sc.next();
                    if (Rech_Plat(code) == null) {
                        plat.setCode(code);
                    } else {
                        System.out.println("Ce code est déjà utilisé !");
                    }
                    break;
                case 2:
                    System.out.println("Entrez le nouveau nom: ");
                    plat.setNom(sc.next());
                    break;
                case 3:
                    System.out.println("Entrez le nouveau prix: ");
                    plat.setPrix(sc.nextDouble());
                    break;
            }
        } else {
            System.out.println("Ce plat n'existe pas !");
        }
    }
    public Commande Rech_Cmd(int code) {
        System.out.println("🔍 Recherche de la commande avec le code: " + code);
        
        for (Commande cmd : listCmd) {
            System.out.println("📝 Vérification: Commande ID dans la liste: " + cmd.getCodeCmd());
            if (cmd.getCodeCmd() == code) {
                System.out.println("✅ Commande trouvée !");
                return cmd;
            }
        }
    
        System.out.println("⚠ Commande non trouvée !");
        return null;
    }
    
    public void CreerCmd() {
        ArrayList<LigneCmd> list = new ArrayList<>();
        int numTab;
    
        do {
            System.out.println("Donner le numéro de la table:");
            numTab = sc.nextInt();
        } while (!dispo(numTab));
    
        int choix;
        String codeP;
        int q;
    
        do {
            System.out.println("Donner le code du plat à commander:");
            codeP = sc.next();
    
            Plat plat = Rech_Plat(codeP);
            if (plat != null) {
                System.out.println("Donner le nombre d'assiettes:");
                q = sc.nextInt();
                list.add(new LigneCmd(plat, q));
                plat.setQuantiteC(q + plat.getQuantiteC());
            } else {
                System.out.println("⚠ Ce plat n'existe pas !");
            }
    
            System.out.println("Voulez-vous ajouter une autre ligne ? 1:Oui 2:Non");
            choix = sc.nextInt();
        } while (choix == 1);
    
        String mode;
        do {
            System.out.println("Mode de paiement (cheque, espece, CB):");
            mode = sc.next();
        } while (!(mode.equalsIgnoreCase("cheque") || mode.equalsIgnoreCase("CB") || mode.equalsIgnoreCase("espece")));
    
        // Assurer que le code de la commande est bien attribué
        Commande cmd = new Commande(this.code, numTab, list, mode);
        listCmd.add(cmd);
    
        System.out.println("✅ Commande créée avec succès ! Numéro de commande: " + this.code);
    
        // Vérification après ajout
        System.out.println("🚀 Liste des commandes après ajout :");
        for (Commande c : listCmd) {
            System.out.println("Commande ID: " + c.getCodeCmd() + ", Table: " + c.getNumTab());
        }
    
        this.code++; // S'assurer que le code s'incrémente
    }
    
    
    public void AffichageCmd() {
        System.out.println("Donner le code de la commande:");
        int code = sc.nextInt();
    
        Commande cmd = Rech_Cmd(code);
        if (cmd != null) {
            System.out.println("🛎 Détails de la commande:");
            System.out.println(cmd);
        } else {
            System.out.println("❌ Commande introuvable !");
        }
    }
    

    public void Cloturer() {
        System.out.println("Donner le code de la commande à clôturer:");
        int code = sc.nextInt();
    
        Commande cmd = Rech_Cmd(code);
        if (cmd != null) {
            if (!cmd.isCloturee()) {
                cmd.setCloturee(true);
                System.out.println("✅ Commande clôturée avec succès !");
            } else {
                System.out.println("⚠ Cette commande est déjà clôturée.");
            }
        } else {
            System.out.println("❌ Commande non trouvée !");
        }
    }
    


    public void recetteJ() {
        LocalDate date = LocalDate.now();
        System.out.println("📅 La recette journalière = " + recette(date));
    }

    public double recette(LocalDate date) {
        double total = 0.0;
        for (Commande cmd : listCmd) {
            if (cmd.getDate().isEqual(date)) {
                total += cmd.Total();
            }
        }
        return total;
    }

    public void AffichagePC() {
        if (listPlat.isEmpty()) {
            System.out.println("⚠ Aucun plat n'a été commandé.");
            return;
        }

        Plat max = null;
        int maxQuantite = 0;

        for (Plat plat : listPlat) {
            if (plat.getQuantiteC() > maxQuantite) {
                max = plat;
                maxQuantite = plat.getQuantiteC();
            }
        }

        if (max != null && maxQuantite > 0) {
            System.out.println("🍽 Le plat le plus commandé est :");
            System.out.println(max + " avec " + maxQuantite + " commandes.");
        } else {
            System.out.println("⚠ Aucun plat n'a encore été commandé.");
        }
    }

    public boolean dispo(int num) {
        for (Commande cmd : listCmd) {
            if (cmd.getNumTab() == num && !cmd.isCloturee()) {
                return false;
            }
        }
        return true;
    }
    public void recetteP_chiffre() {
        double c = 0.0;
        System.out.println("Donner la date début et la date fin:");
        
        String dateD = sc.next();
        String dateF = sc.next();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date_debut = LocalDate.parse(dateD, formatter);
        LocalDate date_fin = LocalDate.parse(dateF, formatter);

        for (LocalDate date = date_debut; !date.isAfter(date_fin); date = date.plusDays(1)) {
            c += recette(date);
            System.out.println("La recette journalière (" + date.format(formatter) + ") = " + recette(date));
        }
        
        System.out.println("Le chiffre d'affaire (" + dateD + " - " + dateF + ") = " + c);
    }
}
    

