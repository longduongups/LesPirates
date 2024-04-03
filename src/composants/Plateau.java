package composants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import affichage.JournalDeBord;
import caseSpeciale.CaseEffetHP;
import caseSpeciale.CaseEffetPosition;
import enums.Effets;

public class Plateau {
	//DÃ©claration du plateau de taille modifiable
	public int taille = 30;
	public Case[] cases = new Case[taille];
	
	//Constructeur
	public Plateau() {
		super();
		//Initialisation des numÃ©ros des cases
		for(int i=0; i<taille; i++) {
			cases[i] = new Case();
			cases[i].setNumCase(i+1);
		}
	}
	
	public Pirate existeGagnant(Pirate j1, Pirate j2) {
		Pirate winner = null;
		
		int posJ1 = j1.getPosition();
		int posJ2 = j2.getPosition();
		
		if(posJ1 >= 30  || j2.getPointsDeVie()<=0) {
			winner = j1;
		}else if(posJ2 >= 30 || j1.getPointsDeVie()<=0) {
			winner = j2;
		}else {
			winner = null;
		}
		return winner;
	}
	
	public Case getCases(int numCase) {
		return cases[numCase];
	}
	
	public void initialiserCasesSpeciales() {
	    int nbCasesSpeciales = 14; // Nombre total de cases spéciales

	    // Ensemble pour stocker les positions des cases spéciales générées
	    Set<Integer> positionsSpeciales = new HashSet<>();

	    // Génération aléatoire des positions des cases spéciales entre 2 et 28
	    Random random = new Random();
	    while (positionsSpeciales.size() < nbCasesSpeciales) {
	        int position = random.nextInt(27) + 2; // Générer entre 2 et 28
	        positionsSpeciales.add(position);
	    }

	    // Tableau des effets à appliquer sur les cases spéciales
	    Effets[] effetsSpeciaux = {
	            Effets.COUP_DE_FEU, Effets.COUP_DE_FEU, Effets.COUP_DE_FEU, Effets.COUP_DE_FEU,
	            Effets.HOPITAL, Effets.HOPITAL, Effets.HOPITAL, Effets.HOPITAL,
	            Effets.PIEGE, Effets.PIEGE,
	            Effets.SWITCH, Effets.SWITCH,
	            Effets.PRISON, Effets.PRISON
	    };

	    // Liste des positions spéciales
	    List<Integer> positionsList = new ArrayList<>(positionsSpeciales);
	    Collections.shuffle(positionsList); // Mélanger les positions pour un placement aléatoire

	    // Boucle affectant chaque case spéciale à un effet
	    for (int i = 0; i < nbCasesSpeciales; i++) {
	        int position = positionsList.get(i);
	        Effets effet = effetsSpeciaux[i];
	        // Si l'effet est HP, utilisez CaseEffetHP, sinon utilisez CaseEffetPosition
	        if (effet == Effets.HOPITAL || effet == Effets.COUP_DE_FEU) {
	            cases[position - 1] = new CaseEffetHP(effet, position);
	        } else {
	            cases[position - 1] = new CaseEffetPosition(effet, position);
	        }
	    }

	    // La case 29 est la case Espoir
	    cases[28] = new CaseEffetPosition(Effets.ESPOIR, 29);

	    // Affichage des cases spéciales
	    JournalDeBord.affCasesSpe1(cases);
	}

}
