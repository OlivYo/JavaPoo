import java.text.DecimalFormat;
import java.util.Scanner;

import ClassePourCaisse.MonnaieCaisse;
import ClassePourCaisse.Produit;

public class CaisseObjet {
	
	static DecimalFormat df = new DecimalFormat("#.##");
	
	
	public static void CalculRendu(float a, float b, MonnaieCaisse[] fondCaisse) {
		df.setMinimumFractionDigits(2);
		float rendu;
		rendu = a - b;
		String reponse = "";
		
		for(int i = 0 ; i < fondCaisse.length; i ++) {
			if(rendu >= 1) {
				if(rendu >= fondCaisse[i].getValeur()) {
					fondCaisse[i].setNbrRendu( (int) (rendu/fondCaisse[i].getValeur()));
					fondCaisse[i].setNbrRendu(  (fondCaisse[i].getQuantite() < fondCaisse[i].getNbrRendu()) ? (int) fondCaisse[i].getQuantite(): (int) fondCaisse[i].getNbrRendu());
					rendu = rendu - fondCaisse[i].getNbrRendu()*fondCaisse[i].getValeur();
					String s = (rendu == 0) ? "€." : "€, ";
					
					if(fondCaisse[i].getValeur() > 2) {
						if((int) fondCaisse[i].getNbrRendu() > 1) {
							reponse = reponse + (int)fondCaisse[i].getNbrRendu() + " billets de " + df.format(fondCaisse[i].getValeur()) + s;
						} else {
							reponse = reponse + (int)fondCaisse[i].getNbrRendu() + " billet de " + df.format(fondCaisse[i].getValeur()) + s;
						}
					}
					if(fondCaisse[i].getValeur() <= 2) {
						if((int) fondCaisse[i].getNbrRendu() > 1) {
							reponse = reponse + (int)fondCaisse[i].getNbrRendu() + " pieces de " + df.format(fondCaisse[i].getValeur()) + s;
						} else {
							reponse = reponse + (int)fondCaisse[i].getNbrRendu() + " piece de " + df.format(fondCaisse[i].getValeur()) + s;
						}
					}
				}
			} else {
				if(rendu >= fondCaisse[i].getValeur()) {
					fondCaisse[i].setNbrRendu(rendu/fondCaisse[i].getValeur());
					fondCaisse[i].setNbrRendu(  (fondCaisse[i].getQuantite() < fondCaisse[i].getNbrRendu()) ? (int) fondCaisse[i].getQuantite(): (int) fondCaisse[i].getNbrRendu());
					rendu = rendu - fondCaisse[i].getNbrRendu()*fondCaisse[i].getValeur();
					String s = (rendu < 0.01) ? "€." : "€, ";
					if((int) fondCaisse[i].getNbrRendu() > 1) {
						reponse = reponse + (int)fondCaisse[i].getNbrRendu() + " pieces de " + df.format(fondCaisse[i].getValeur()) + s;
					} else {
						reponse = reponse + (int)fondCaisse[i].getNbrRendu() + " piece de " + df.format(fondCaisse[i].getValeur()) + s;
					}	
				}
			}
		}
		System.out.println(reponse);	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bonjour, bienvenue sur le marketplace de MSDev");
		float total = 0.00f;
		int code = 1;
		int qte = 1; 
		df.setMinimumFractionDigits(2);
		
		Produit p1 = new Produit(1, "bieres", 5.30f);
		Produit p2 = new Produit(2, "pain", 1.10f);
		Produit p3 = new Produit(3, "saucisses", 15.30f);
		Produit p4 = new Produit(4, "frites", 4.00f);
		Produit p5 = new Produit(5, "rhum", 29.99f);
		Produit p6 = new Produit(6, "souris", 55.80f);
		Produit p7 = new Produit(7, "stylo", 1.80f);
		Produit p8 = new Produit(8, "sac", 0.30f);
		Produit p9 = new Produit(9, "pommes", 3.05f);
		Produit[] magasin = { p1, p2,p3, p4, p5, p6, p7, p8 ,p9 };
		
		float n200 = 0, n100 = 0, n50 = 0, n20 = 0, n10 = 0, n5 = 0, n2 = 0, n1 = 0, c50 = 0, c20 = 0, c10 = 0, c5 = 0, c2 = 0, c1 = 0;
		MonnaieCaisse m1 = new MonnaieCaisse(200, 5, n200);
		MonnaieCaisse m2 = new MonnaieCaisse(100, 5, n100);
		MonnaieCaisse m3 = new MonnaieCaisse(50, 10, n50);
		MonnaieCaisse m4 = new MonnaieCaisse(20, 10, n20);
		MonnaieCaisse m5 = new MonnaieCaisse(10, 10, n10);
		MonnaieCaisse m6 = new MonnaieCaisse(5, 20, n5);
		MonnaieCaisse m7 = new MonnaieCaisse(2, 20, n2);
		MonnaieCaisse m8 = new MonnaieCaisse(1, 20, n1);
		MonnaieCaisse m9 = new MonnaieCaisse(0.50f, 20, c50);
		MonnaieCaisse m10 = new MonnaieCaisse(0.20f, 20, c20);
		MonnaieCaisse m11 = new MonnaieCaisse(0.10f, 20, c10);
		MonnaieCaisse m12 = new MonnaieCaisse(0.05f, 20, c5);
		MonnaieCaisse m13 = new MonnaieCaisse(0.02f, 20, c2);
		MonnaieCaisse m14 = new MonnaieCaisse(0.01f, 20, c1);
		MonnaieCaisse[] fondCaisse = { m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14};
		
		System.out.println("Choisissez un produit");
		Scanner in = new Scanner(System.in);
		
		while (code != 0) {
			code = in.nextInt();
			if ( code != 0 ) {
				System.out.println("Combien de " + magasin[code - 1].getNom());
				qte = in.nextInt();
				for (int i = 0; i < 10; i++) {
					if( code == i + 1) {
						System.out.println("code : " + magasin[i].getCode() + " -  intitule : " + magasin[i].getNom() + " -  prix : " + df.format(magasin[i].getPrix()) + "€");
						total = total + qte * magasin[i].getPrix();
					}
				}
			}
		}
		
		if(code == 0) {
			System.out.println("Le total de vos achats se monte a : ");
			System.out.println(df.format(total) + "€");
			System.out.println();	
		}
	
		System.out.println("Paiement en especes : ");
		float montant = in.nextFloat();
		in.close();
		
		CalculRendu(montant, total, fondCaisse);

	}
}
