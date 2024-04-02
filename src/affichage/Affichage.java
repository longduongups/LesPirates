package affichage;

import composants.Case;
import composants.Pirate;
import composants.Plateau;

public interface Affichage {
	public void affStart(Pirate j1, Pirate j2);
	public void affPlateau(Plateau plateau);
	public void affLancerDe(int de);
	public void affChangePos(Pirate j);
	public void affCasesSpe(Case[] c);
	public void affDepassement(Pirate pTete, Pirate pQueue);
	public void affFinTour(Pirate p);
}
