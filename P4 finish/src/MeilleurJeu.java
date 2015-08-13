import java.util.Random;


public class MeilleurJeu {

	
	public Joueur[] tab;
	public Grille jeu;
	public int positionactive;
	public int resultat;
	public int nj;
	
	public MeilleurJeu( Joueur[] tabm,int nombrej, Grille jeum, int posact) {
		
		tab= tabm;
		jeu= jeum;
		positionactive = posact;
		resultat=this.result(nombrej);
		nj=nombrej;
	}

	
	//vérifier si le joueur peut gagner en un coup
	public int peutgagner(int ii) {
		
		int r=-1;
		int jf = 0;
		for (int k=0; k<jeu.taillel; k++) {
			jf = jeu.jouerfictif(k,tab[ii]);
			if (jf==1) {r=k;break;}
			else {}
			jeu.enlever(k);
		}
		return r;
	}

	//vérifier si un autre joueur peut gagner en un coup
	public int peutperdre (int ii, int nn) {
		
		int r=-1;
		for (int aaa=0; aaa<nn; aaa++) {
				if (aaa==ii) {}
				else { int pg=peutgagner(aaa);
					if (pg==-1) {}
					else {r=pg;}
					}
			}
		return r;
	}

	//vérifier si un coup peu faire gagner un autre joueur
	
	public int peutfairegagner(int ii, int nn) {
		
		int r=-1;
		int jf=0;
		int b=0;
		
		for (int i1=ii-1; i1>=0; i1--) {
			for (int i2=0; i2<jeu.taillel; i2++) {
				
				jf = jeu.jouerfictif(i2, tab[positionactive]);
				b = peutgagner(i1);
				if (b==-1) {}
				else {r=i2;}
				System.out.println(" i1= " + i1 + " i2 = " + i2 + " b = " + b + " r = " + r );
				jeu.enlever(i2);
			}
		}	
		
		for (int i1=nn-1; i1>ii; i1--) {
			for (int i2=0; i2<jeu.taillel; i2++) {
				
				jf = jeu.jouerfictif(i2, tab[positionactive]);
				b = peutgagner(i1);
				if (b==-1) {}
				else {r=i2;}
				System.out.println(" i1= " + i1 + " i2 = " + i2 + " b = " + b + " r = " + r );
				jeu.enlever(i2);
			}
		}
		
		return r;
	}
	//renvoyer la colonne à jouer pour gagner ou ne pas perdre, sinon aléatoire.
	
	public int result(int nnn) {
		
		int r=-1;
		int a = peutgagner(positionactive);System.out.println("peutgagner = " + a);
		int b = peutperdre(positionactive, nnn);System.out.println("peutperdre = " + b);
		int c = peutfairegagner(positionactive, nnn);System.out.println("peutfairegagner = " + c);
		if (a==-1) {
			if (b==-1) {
				if (c==-1) { r = getRandom();}
				else {r= getRandom(c);}}
			else {r=b;}}
		else {r=a;}
			
		return r;
	}

	public int getRandom() {
		
		int rr=0;
		int i=0;
		Random rd = new Random();
		while (i==0) {
		rr= rd.nextInt(jeu.taillel);
		if (jeu.grille[rr].getRemplissage()==jeu.taillec) {
			System.out.println("rr = "+ rr +" on recommence");
		}
		else {i=1;}
		}
		System.out.println("rr def = "+ rr +" rr.remplissage = "+ jeu.grille[rr].getRemplissage());
		return rr;
	}
	
	public int getRandom(int l) {
		
		int rr=0;
		int i=0;
		Random rd = new Random();
		while (i==0) {
		rr= rd.nextInt(jeu.taillel);
		if (jeu.grille[rr].getRemplissage()==jeu.taillec) {}
		else if (rr==l) {}
		else {i=1;}
		}
		return rr;
	}
}
	





