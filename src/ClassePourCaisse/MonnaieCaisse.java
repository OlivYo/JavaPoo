package ClassePourCaisse;

public class MonnaieCaisse {
	private float valeur ;
	private int quantite;
	private float nbrRendu;
	
	public MonnaieCaisse() {
	}

	public MonnaieCaisse(float valeur, int quantite, float nbrRendu) {
		this.valeur = valeur;
		this.quantite = quantite;
		this.nbrRendu = nbrRendu;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getNbrRendu() {
		return nbrRendu;
	}

	public void setNbrRendu(float nbrRendu) {
		this.nbrRendu = nbrRendu;
	}
	
	

}
