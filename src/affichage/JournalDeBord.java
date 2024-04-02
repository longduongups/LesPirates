package affichage;

import java.text.DecimalFormat;

public class JournalDeBord implements Affichage{
	static DecimalFormat nf = new DecimalFormat("00");
	// DÃ©claration de numCase (indice du tableau Case cases[])
	public void affStart(Pirate j1, Pirate j2) {
		System.out.println("Debut de la partie :");
		System.out.println("\tPion 1 : " + j1.getNom());
		System.out.println("\t\tPosition : " + j1.getPosition());
		System.out.println("\t\tCouleur : " + j1.getCouleur());
		System.out.println("\tPion 2 : " + j2.getNom());
		System.out.println("\t\tPosition : " + j2.getPosition());
		System.out.println("\t\tCouleur : " + j2.getCouleur());
		System.out.println("_________________________________________");
		System.out.println("");
	}

	public void affPlateau(Plateau plateau) {
	    System.out.println("Plateau :");

	    int[][] plateauMatrice = new int[5][6]; // Matrice 5x6 pour représenter le plateau
	    int row = 0, col = 0; // Indices de la ligne et de la colonne dans la matrice
	    int direction = 0; // 0: vers la droite, 1: vers le bas, 2: vers la gauche, 3: vers le haut

	    // Remplissage de la matrice avec les numéros de case
	    for (int numCase = 1; numCase <= 30; numCase++) {
	        plateauMatrice[row][col] = numCase;

	        // Détermination de la prochaine position dans la matrice en fonction de la direction
	        if (direction == 0) { // Vers la droite
	            if (col + 1 < 6 && plateauMatrice[row][col + 1] == 0) {
	                col++;
	            } else {
	                direction = 1; // Changer de direction
	                row++;
	            }
	        } else if (direction == 1) { // Vers le bas
	            if (row + 1 < 5 && plateauMatrice[row + 1][col] == 0) {
	                row++;
	            } else {
	                direction = 2; // Changer de direction
	                col--;
	            }
	        } else if (direction == 2) { // Vers la gauche
	            if (col - 1 >= 0 && plateauMatrice[row][col - 1] == 0) {
	                col--;
	            } else {
	                direction = 3; // Changer de direction
	                row--;
	            }
	        } else if (direction == 3) { // Vers le haut
	            if (row - 1 >= 0 && plateauMatrice[row - 1][col] == 0) {
	                row--;
	            } else {
	                direction = 0; // Changer de direction
	                col++;
	            }
	        }
	    }

	    // Affichage du plateau en spiral avec les numéros et les effets au milieu de chaque case
	    for (int i = 0; i < 5; i++) {
	        for (int j = 0; j < 6; j++) {
	            int numCase = plateauMatrice[i][j];
	            if (numCase != 0) {
	                Case currentCase = plateau.getCases(numCase - 1);
	                String caseStr;
	                if (currentCase instanceof CaseEffetHP) {
	                    caseStr = nf.format(numCase) + "(" + ((CaseEffetHP) currentCase).getEffet().getName() + ")";
	                } else if (currentCase instanceof CaseEffetPosition) {
	                    caseStr = nf.format(numCase) + "(" + ((CaseEffetPosition) currentCase).getEffet().getName() + ")";
	                } else {
	                    caseStr = nf.format(numCase);
	                }
	                // Ajouter des espaces pour aligner les numéros et les effets au milieu de chaque case
	                int nbEspaces = 16 - caseStr.length();
	                int avant = nbEspaces / 2;
	                int apres = nbEspaces - avant;
	                System.out.print("|" + " ".repeat(avant) + caseStr + " ".repeat(apres));
	            } else {
	                // Ajouter une case vide pour aligner les lignes
	                System.out.print("|" + " ".repeat(16));
	            }
	        }
	        System.out.println("|");
	    }

	    System.out.println("_________________________________________");
	    System.out.println("");
	}
	public void affLancerDe(int de) {
		System.out.print("Valeur de de : ");
			System.out.println(de);
	}

	public void affChangePos(Pirate j) {
		System.out.println(j.getNom() + " : ");
		System.out.println("\tPosition actuelle : " + (j.getPosition()) + "\tHP : " + j.getPointsDeVie()+"\n");
	}

	public void affGagnant(Pirate winner, int nbTour) {
		System.out.println("Fin en " + nbTour + " tours\n");
		System.out.println("VICTOIRE DE : " + winner.getNom());
		System.out.println("________________________________________________________");
		System.out.println("");
	}

	public static void affCasesSpe1(Case[] c) {
		System.out.println("Cases Speciales : ");
		for(int i=0; i<c.length; i++){
			if(c[i] instanceof CaseEffetHP){
				System.out.println("\t" + ((CaseEffetHP)c[i]).getEffet().getName() + " : " + c[i].getNumCase());
			}else if(c[i] instanceof CaseEffetPosition){
				System.out.println("\t" + ((CaseEffetPosition)c[i]).getEffet().getName() + " : " + c[i].getNumCase());
			}
		}

		System.out.println("_________________________________________");
		System.out.println("");
	}
	public  void affCasesSpe(Case[] c) {
		System.out.println("Cases Speciales : ");
		for(int i=0; i<c.length; i++){
			if(c[i] instanceof CaseEffetHP){
				System.out.println("\t" + ((CaseEffetHP)c[i]).getEffet().getName() + " : " + c[i].getNumCase());
			}else if(c[i] instanceof CaseEffetPosition){
				System.out.println("\t" + ((CaseEffetPosition)c[i]).getEffet().getName() + " : " + c[i].getNumCase());
			}
		}

		System.out.println("_________________________________________");
		System.out.println("");
	}

	public void affDepassement(Pirate pTete, Pirate pQueue) {
		System.out.println("Le pirate " + pTete.getNom() + " prend la tete");
		System.out.println("Le pirate "+ pQueue.getNom() + " perd 1HP !\n");

	}

	public void affFinTour(Pirate p) {
		System.out.println("\tLe joueur " + p.getNom() + " a fini son tour\n");
	}

	public void affEspoir() {
		System.out.println("|Espoir|: Recul de valeur de de obtenu cases");
	}
	public void affPrison(Pirate p) {
		System.out.println("Le pirate " + p.getNom() + " est en prison et ne peut pas se déplacer.\n");
	}


}

