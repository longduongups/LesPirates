package enums;

import caseSpeciale.CaseEffetHP;
import caseSpeciale.CaseEffetPosition;
import composants.Pirate;

public enum Effets{
	HOPITAL("Hopital"){
        @Override
        public void appliquerEffect(Pirate p) {
            CaseEffetHP.hopital(p);
        }
        @Override
        public void appliquerEffect(Pirate p1, Pirate p2) {}
	},
	COUP_DE_FEU("Coup de feu"){
        @Override
        public void appliquerEffect(Pirate p) {
            CaseEffetHP.coupDeFeu(p);
        }
        @Override
        public void appliquerEffect(Pirate p1, Pirate p2) {}
	},
	PIEGE("Piege"){
        @Override
        public void appliquerEffect(Pirate p) {
            CaseEffetPosition.casePiege(p);
        }
        @Override
        public void appliquerEffect(Pirate p1, Pirate p2) {}
	},
	SWITCH("Switch"){
       
        @Override
        public void appliquerEffect(Pirate p1, Pirate p2) {
            CaseEffetPosition.caseSwitch(p1, p2);
        }

		@Override
		public void appliquerEffect(Pirate p) {
		}
	},
	PRISON("Prison"){
        @Override
        public void appliquerEffect(Pirate p) {
            CaseEffetPosition.casePrison(p);
        }
        @Override
        public void appliquerEffect(Pirate p1, Pirate p2) {}
	},
	ESPOIR("Espoir"){
        @Override
        public void appliquerEffect(Pirate p) {
            CaseEffetPosition.espoir(p);
        }
        @Override
        public void appliquerEffect(Pirate p1, Pirate p2) {}
	};
	
	private String nom;
	
	private Effets(String nom) {
		this.nom = nom;
	}
	
	public String getName() {
		return nom;
	}
	
	// Methode abstraite pour effectuer l'effet
    public abstract void appliquerEffect(Pirate p);
    public abstract void appliquerEffect(Pirate p1, Pirate p2);
}