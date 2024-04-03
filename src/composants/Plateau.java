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
	//Déclaration du plateau de taille modifiable
	public int taille = 30;
	public Case[] cases = new Case[taille];
	
	//Constructeur
	public Plateau() {
		super();
		//Initialisation des numéros des cases
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
	    int nbCasesSpeciales = 14; // Nombre total de cases sp�ciales

	    // Ensemble pour stocker les positions des cases sp�ciales g�n�r�es
	    Set<Integer> positionsSpeciales = new HashSet<>();

	    // G�n�ration al�atoire des positions des cases sp�ciales entre 2 et 28
	    Random random = new Random();
	    while (positionsSpeciales.size() < nbCasesSpeciales) {
	        int position = random.nextInt(27) + 2; // G�n�rer entre 2 et 28
	        positionsSpeciales.add(position);
	    }

	    // Tableau des effets � appliquer sur les cases sp�ciales
	    Effets[] effetsSpeciaux = {
	            Effets.COUP_DE_FEU, Effets.COUP_DE_FEU, Effets.COUP_DE_FEU, Effets.COUP_DE_FEU,
	            Effets.HOPITAL, Effets.HOPITAL, Effets.HOPITAL, Effets.HOPITAL,
	            Effets.PIEGE, Effets.PIEGE,
	            Effets.SWITCH, Effets.SWITCH,
	            Effets.PRISON, Effets.PRISON
	    };

	    // Liste des positions sp�ciales
	    List<Integer> positionsList = new ArrayList<>(positionsSpeciales);
	    Collections.shuffle(positionsList); // M�langer les positions pour un placement al�atoire

	    // Boucle affectant chaque case sp�ciale � un effet
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

	    // Affichage des cases sp�ciales
	    JournalDeBord.affCasesSpe1(cases);
	}

}
