package composants;
public class Case {
	public int numCase;
	public boolean caseSpecial;

	public Case() {
		this.numCase = 0;
		this.caseSpecial = false;
	}

	public void setNumCase(int numCase) {
		this.numCase = numCase;
	}

	public int getNumCase() {
		return numCase;
	}
	

	public boolean getCaseSpecial() {
		return caseSpecial;
	}
}
