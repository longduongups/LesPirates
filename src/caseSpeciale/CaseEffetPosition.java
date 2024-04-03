package caseSpeciale;

import composants.Case;
import composants.Pirate;
import enums.Effets;

public class CaseEffetPosition extends Case{
	Effets effet;
	
	public CaseEffetPosition(Effets effet, int i) {
		super();
		this.caseSpecial = true;
		this.effet = effet;
		super.setNumCase(i);
	}

	public static void casePiege(Pirate p) {
		p.setPosition(1);
		System.out.println("|Piege| : Retour a la case depart ");
	}
	
	public static void caseSwitch(Pirate p1, Pirate p2) {
	    System.out.println("|Switch|");

	    //  les positions initiales
	    System.out.println("Positions avant l'échange :");
	    System.out.println(p1.getNom() + " : " + p1.getPosition());
	    System.out.println(p2.getNom() + " : " + p2.getPosition());

	    // echange 
	    int temp = p1.getPosition();
	    p1.setPosition(p2.getPosition());
	    p2.setPosition(temp);

	    //  les positions après 
	    System.out.println("Positions après l'échange :");
	    System.out.println(p1.getNom() + " : " + p1.getPosition());
	    System.out.println(p2.getNom() + " : " + p2.getPosition());
	    System.out.println("Les pions ont été échangés.");
	}
	
	public static void casePrison(Pirate p) {
		  System.out.println("Le pirate " + p.getNom() + " est bloqué en prison.\n");
		    // Mettre à jour l'état du pirate pour le marquer comme étant en prison
		    p.setEnPrison(true);
	}
	
	public static void espoir(Pirate p) {
//		System.out.println("\t\t\tEspoir");
	}
	
	public Effets getEffet() {
		return effet;
	}
}
