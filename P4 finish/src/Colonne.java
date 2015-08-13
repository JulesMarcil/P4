import java.awt.Color;

public class Colonne {
		
	    public int remplissage;
		public int taillecol;
		public Case[] tab;
		
		public Colonne(int t) {
			
			remplissage = 0;
			tab = new Case[t];
			taillecol=t;
			for (int i=0; i<taillecol; i++) {
				tab[i]= new Case(Color.white);}
			
			}
	
		public void remplir(Joueur b) {
			
			tab[remplissage].changerCouleur(b.couleur); 
			remplissage++;
			
		    }
		
		public void enlever() {
			
			remplissage--;
			tab[remplissage].changerCouleur(Color.white);
		}
		
		public int getRemplissage() {
			
			return remplissage;
		}
			
			
			
		}

