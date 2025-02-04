package restaurant; // No need to import classes from the same package

import java.util.Scanner;

public class RESTAU {
    public static void main(String[] args) {
        Gestionnaire Gest = new Gestionnaire();
        Scanner sc = new Scanner(System.in);
        int k = 0;
        int action;

        System.out.println("********MENU*******\n");
        System.out.println("1. Rechercher un plat\n" +
                "2. Ajouter un plat\n" +
                "3. Modifier les détails d'un plat\n" +
                "4. Afficher un plat\n" +
                "5. Créer une commande\n" +
                "6. Afficher une commande\n" +
                "7. Clôturer une commande\n" +
                "8. Afficher une recette journalière\n" +
                "9. Afficher la recette journalière d'une période et le chiffre d'affaire de cette période\n" +
                "10. Afficher le plat le plus commandé\n" +
                "11. Quitter");

        do {
            if (k == 0) {
                System.out.println("Choisir une instruction : ");
            } else {
                System.out.println("Rechoisir une instruction : ");
            }
            action = sc.nextInt();
            k++;

            switch (action) {
                case 1:
                    System.out.println("Entrez le code du plat à rechercher");
                    String code = sc.next();
                    if (Gest.Rech_Plat(code) == null) {
                        System.out.println("Ce plat n'existe pas!");
                    } else {
                        System.out.println("Ce plat existe!");
                    }
                    break;

                case 2:
                    Gest.AjoutPlat();
                    break;

                case 3:
                    Gest.Modifier();
                    break;

                case 4:
                    Gest.AffichagePlat();
                    break;

                case 5:
                    Gest.CreerCmd();
                    break;

                case 6:
                    Gest.AffichageCmd();
                    break;

                case 7:
                    Gest.Cloturer();
                    break;

                case 8:
                    Gest.recetteJ();
                    break;

                case 9:
                    Gest.recetteP_chiffre();
                    break;

                case 10:
                    Gest.AffichagePC();
                    break;

                case 11:
                    System.out.println("Merci, Bye !");
                    break;

                default:
                    System.out.println("Instruction invalide\n");
            }
        } while (action != 11);
        
        sc.close(); // Close Scanner to prevent resource leak
    }
}
