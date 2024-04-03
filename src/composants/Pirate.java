package composants;

import enums.Couleur;

public class Pirate {
    private String nom;
    private int pointsDeVie;
    private int position;
    private Pion pion;
    private Couleur couleur;
    private boolean enPrison;

  	
  	//Constructeur
  	public Pirate(String name, Pion pion, int PointDeVie) {
  		this.nom = name;
  		this.couleur = pion.getColor();
  		pointsDeVie = PointDeVie;
  		this.enPrison = false;
  	}
  	
  	public int getPosition() {
  		return position;
  	}

  	public void setPosition(int position) {
  		this.position = position;
  	}
  	
  	public String getNom() {
  		return nom;
  	}
  	public Pion getPion() {
  		return pion;
  	}
  	public int getPointsDeVie() {
  		return pointsDeVie;
  	}
  	
  	public void setPointsDeVie(int hp) {
  		pointsDeVie = hp;
  	}

  	public Couleur getCouleur() {
  		return couleur;
  	}
  	 public boolean estEnPrison() {
         return enPrison;
     }
  	public void setEnPrison(boolean enPrison) {
        this.enPrison = enPrison;
    }

}
