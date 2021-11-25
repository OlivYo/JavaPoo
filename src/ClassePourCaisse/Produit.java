package ClassePourCaisse;

public class Produit {
	private int code;
	private String nom;
	private float prix;
	
	public Produit(){};
	
	public Produit(int c, String n, float p) {
		this.code = c;
		this.nom = n;
		this.prix = p;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int c) {
		this.code = c;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

}
