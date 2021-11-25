import java.text.DecimalFormat;
import java.util.Scanner;

public class TpCaisse {
	
	public static void CalculRendu(float a, float b) {
		float rendu;
		rendu = a - b;
		float n200 = 0, n100 = 0, n50 = 0, n20 = 0, n10 = 0, n5 = 0, n2 = 0, n1 = 0, c50 = 0, c20 = 0, c10 = 0, c5 = 0, c2 = 0, c1 = 0;
		String reponse = "";
		float[][] fondCaisse = new float[14][3];
		fondCaisse[0][0] = 200f;
		fondCaisse[0][1] = 2f;
		fondCaisse[0][2] = n200;
		fondCaisse[1][0] = 100f;
		fondCaisse[1][1] = 2f;
		fondCaisse[1][2] = n100;
		fondCaisse[2][0] = 50f;
		fondCaisse[2][1] = 4f;
		fondCaisse[2][2] = n50;
		fondCaisse[3][0] = 20f;
		fondCaisse[3][1] = 10f;
		fondCaisse[3][2] = n20;
		fondCaisse[4][0] = 10f;
		fondCaisse[4][1] = 10f;
		fondCaisse[4][2] = n10;
		fondCaisse[5][0] = 5f;
		fondCaisse[5][1] = 10f;
		fondCaisse[5][2] = n5;
		fondCaisse[6][0] = 2f;
		fondCaisse[6][1] = 20f;
		fondCaisse[6][2] = n2;
		fondCaisse[7][0] = 1f;
		fondCaisse[7][1] = 20f;
		fondCaisse[7][2] = n1;
		fondCaisse[8][0] = 0.5f;
		fondCaisse[8][1] = 20f;
		fondCaisse[8][2] = c50;

		fondCaisse[9][0] = 0.2f;
		fondCaisse[9][1] = 20f;
		fondCaisse[9][2] = c20;

		fondCaisse[10][0] = 0.1f;
		fondCaisse[10][1] = 20f;
		fondCaisse[10][2] = c10;

		fondCaisse[11][0] = 0.05f;
		fondCaisse[11][1] = 20f;
		fondCaisse[11][2] = c5;
		fondCaisse[12][0] = 0.02f;
		fondCaisse[12][1] = 20f;
		fondCaisse[12][2] = c2;

		fondCaisse[13][0] = 0.01f;
		fondCaisse[13][1] = 20f;
		fondCaisse[13][2] = c1;
		
		for(int i = 0 ; i < fondCaisse.length; i ++) {
			if(rendu >= 1) {
				if(rendu >= fondCaisse[i][0]) {
					fondCaisse[i][2] = (int) rendu/fondCaisse[i][0];
					fondCaisse[i][2] =  (fondCaisse[i][1] < fondCaisse[i][2]) ? (int) fondCaisse[i][1]: (int) fondCaisse[i][2];
					rendu = rendu - fondCaisse[i][2]*fondCaisse[i][0];
					String s = (rendu == 0) ? "." : ", ";
					
					if(fondCaisse[i][0] > 2) {
						if((int) fondCaisse[i][2] > 1) {
							reponse = reponse + fondCaisse[i][2] + " billets de " + fondCaisse[i][0] + s;
						} else {
							reponse = reponse + fondCaisse[i][2] + " billet de " + fondCaisse[i][0] + s;
						}
					}
					if(fondCaisse[i][0] <= 2) {
						if((int) fondCaisse[i][2] > 1) {
							reponse = reponse + fondCaisse[i][2] + " pieces de " + fondCaisse[i][0] + s;
						} else {
							reponse = reponse + fondCaisse[i][2] + " piece de " + fondCaisse[i][0] + s;
						}
					}
				}
			} else {
				if(rendu >= fondCaisse[i][0]) {
					System.out.println("------" + rendu + "-------");
					fondCaisse[i][2] = rendu/fondCaisse[i][0];
					System.out.println("------" + fondCaisse[i][2] + "-------");
					fondCaisse[i][2] =  (fondCaisse[i][1] < fondCaisse[i][2]) ? (int) fondCaisse[i][1]: (int) fondCaisse[i][2];
					rendu = rendu - fondCaisse[i][2]*fondCaisse[i][0];
					String s = (rendu < 0.01) ? "." : ", ";
					if((int) fondCaisse[i][2] > 1) {
						reponse = reponse + fondCaisse[i][2] + " pieces de " + fondCaisse[i][0] + s;
					} else {
						reponse = reponse + fondCaisse[i][2] + " piece de " + fondCaisse[i][0] + s;
					}	
				}
			}
		}
		System.out.println(reponse);
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bonjour, bienvenue sur le marketplace de MSDev");
		
		String[][] produits = new String[10][3];
		float total = 0.00f;
		
		produits[0][0] = "1";
		produits[0][1] = "5.30";
		produits[0][2] = "Biere";
		
		produits[1][0] = "2";
		produits[1][1] = "1.10";
		produits[1][2] = "Pain";
		
		produits[2][0] = "3";
		produits[2][1] = "15.30";
		produits[2][2] = "Saucisses";
		
		produits[3][0] = "4";
		produits[3][1] = "4.00";
		produits[3][2] = "Frites";
		
		produits[4][0] = "5";
		produits[4][1] = "29.00";
		produits[4][2] = "Rhum";
		
		produits[5][0] = "6";
		produits[5][1] = "55.80";
		produits[5][2] = "Souris";
		
		produits[6][0] = "7";
		produits[6][1] = "1.50";
		produits[6][2] = "Stylo noir";
		
		produits[7][0] = "8";
		produits[7][1] = "15.30";
		produits[7][2] = "Sac";
		
		produits[8][0] = "9";
		produits[8][1] = "4.00";
		produits[8][2] = "Cahier";
		
		produits[9][0] = "10";
		produits[9][1] = "3.00";
		produits[9][2] = "Pommes";
		
		int code = 1;
		int qte = 1;
		
		System.out.println("Choisissez un produit");
		Scanner in = new Scanner(System.in);
		
		while (code != 0) {
			code = in.nextInt();
			if ( code != 0 ) {
				System.out.println("Combien de " + produits[code - 1][2]);
				qte = in.nextInt();
				for (int i = 0; i < 10; i++) {
					if( code == i + 1) {
						System.out.println("code : " + produits[i][0] + " -  intitule : " + produits[i][2] + " -  prix : " + produits[i][1]);
						total = total + qte * Float.parseFloat(produits[i][1]);
					}
				}
			}
		}
		
		if(code == 0) {
			System.out.println("Le total de vos achats se monte � : ");
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println(df.format(total));
			System.out.println();	
		}
	
	//	DecimalFormat df = new DecimalFormat("#.##");
	//	System.out.println(df.format(total));	
		
		//Ajouter le rendu monnaie
		
		System.out.println("Paiement en esp�ces : ");
		float montant = in.nextFloat();
		//float rendu = 0;
		
		CalculRendu(montant, total);
		
		in.close();
		
	}
}
