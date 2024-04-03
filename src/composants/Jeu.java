package composants;
import composants.Jeu;
import enums.Couleur;
import enums.Effets;

import java.util.Scanner;

import affichage.JournalDeBord;
import caseSpeciale.CaseEffetHP;
import caseSpeciale.CaseEffetPosition;

public class Jeu {
    //Déclaration du plateau
    private Plateau plateau;
    private Pirate j1;
    private Pirate j2;
    private Pion p1;
    private Pion p2;
    private De de;
    //Déclaration de l'affichage
    private JournalDeBord journal;
    static int pirateEnTete = 1;
    static int lastPirateEnTete = 1;

    public Jeu() {
        this.journal = new JournalDeBord();
        this.plateau = new Plateau();
        this.p1 = new Pion(Couleur.BLEU);
        this.p2 = new Pion(Couleur.ROUGE);
        this.j1 = new Pirate("Jack", p1, 5);
        this.j2 = new Pirate("Bill", p2, 5);
        this.de = new De();
    }

    public void initialiserJeu() {
        //Initialisation des positions des joueurs
        j1.setPosition(1);
        j2.setPosition(1);
        journal.affStart(j1, j2);
        //Initialisation des cases spéciales
        plateau.initialiserCasesSpeciales();
        journal.affPlateau(plateau);
    }

    public void tourPirate(Pirate p) {
        // Vérifier si le pirate est en prison
        if (p.estEnPrison()) {
            journal.affPrison(p);
            p.setEnPrison(false);
            return; // Sortir de la méthode sans effectuer de déplacement
        }

        // Attendre que le joueur appuie sur Entrée pour lancer les dés
        System.out.println("Appuyez sur Entrée pour lancer les dés.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Lancement des dés
        de.lancerDe();
        journal.affLancerDe(de.getValeur());

        int posSuiv = p.getPosition() + de.getValeur() ;
        //Déplacement du pion
        if (posSuiv <= 28 || posSuiv == 30) {
            p.setPosition(posSuiv);
        } else if (posSuiv == 29) {
            //Case espoir
            journal.affEspoir();
        } else if (posSuiv > 30) {
           journal.affDepassementCase30(p);
           p.setPosition(30-(posSuiv-30));
        }
        journal.affChangePos(p);
        //Affectation des effets des cases spéciales
        Case case_actuelle = plateau.getCases(p.getPosition() - 1);
        if (case_actuelle.getCaseSpecial()) {
            if (case_actuelle instanceof CaseEffetHP) {
                CaseEffetHP c = ((CaseEffetHP) case_actuelle);
                c.getEffet().appliquerEffect(p);
            } else {
                CaseEffetPosition c = ((CaseEffetPosition) case_actuelle);
                if(c.getEffet() == Effets.SWITCH){
					c.getEffet().appliquerEffect(j1, j2);
				}else{
        			c.getEffet().appliquerEffect(p);
				}
            }
        }
    }

    public void lancerPartie() {
        int nbTour = 0;
        Pirate gagnant = null;
        //Boucle du jeu tant qu'il n'y a pas de gagnant
        while (plateau.existeGagnant(j1, j2) == null) {
            //Alternation du tour de chaque joueur
            if (nbTour % 2 == 0) {
                tourPirate(j1);
                journal.affFinTour(j1);
                if (nbTour > 0) { // Vérifier le dépassement à partir du deuxième tour de j1
                    checkDepassement();
                }
                nbTour++;
            } else {
                tourPirate(j2);
                nbTour++;
                checkDepassement();
                journal.affFinTour(j2);
            }
        }
        gagnant=plateau.existeGagnant(j1, j2);
        journal.affGagnant(gagnant, nbTour);
    }

    public void checkDepassement() {
        int posJ1 = j1.getPosition(), posJ2 = j2.getPosition();

        //Vérification de dépassement
        if (posJ1 > posJ2) {
            pirateEnTete = 1;
            if (lastPirateEnTete != pirateEnTete) {
                j2.setPointsDeVie(j2.getPointsDeVie() - 1);
                lastPirateEnTete = pirateEnTete;
                journal.affDepassement(j1, j2);
            }
        } else if (posJ1 < posJ2) {
            pirateEnTete = 2;
            if (lastPirateEnTete != pirateEnTete) {
                j1.setPointsDeVie(j1.getPointsDeVie() - 1);
                lastPirateEnTete = pirateEnTete;
                journal.affDepassement(j2, j1);
            }
        } else {
            pirateEnTete = 0;
        }
    }

   
}
