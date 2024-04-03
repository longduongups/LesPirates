package caseSpeciale;

import composants.Case;
import composants.Pirate;
import enums.Effets;

public class CaseEffetHP extends Case{
	Effets effet;
	
	public CaseEffetHP(Effets effet, int i) {
		super();
		this.caseSpecial = true;
		this.effet = effet;
		
		super.setNumCase(i);;
	}

	public static void hopital(Pirate p) {
//		System.out.println("\t\t\tHopital");
		if(p.getPointsDeVie()<5) {
			p.setPointsDeVie(p.getPointsDeVie()+1);
			
			System.out.println(" |Hopital| : +1HP\n");
		}else {
			System.out.println("Hopital :Vous avez deja toute votre vie !\n");
		}
		System.out.println("Votre vie actuelle:"+p.getPointsDeVie());
	}
	
	public static void coupDeFeu(Pirate p) {
		System.out.println("|Coup de feu|");
		p.setPointsDeVie(p.getPointsDeVie()-1);
		System.out.println("Vous perdez 1 point de vie (-1 HP)");
	}
	
	public Effets getEffet() {
		return effet;
	}
}