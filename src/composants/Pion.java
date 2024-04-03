package composants;

import enums.Couleur;

public class Pion {
	
	Couleur color;
	Case c = new Case();
	
	public Pion(Couleur color) {
		super();
		this.color = color;
	}
	
	public int getPosition() {
		return c.getNumCase();
	}

	public void setPosition(int position) {
		this.c.numCase = position;
	}
	
	public Couleur getColor() {
		return color;
	}
}
