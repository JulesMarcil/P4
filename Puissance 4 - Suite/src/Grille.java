import java.util.Random;

public class Grille {
	

	public Colonne[] grille;
	private int taillel;
	private int taillec;
	private int dC;
	private int dL;
	private int g;
	private int n;
	
	public Grille(int nf, int a, int b) {
		
		g=0;
		n=nf;
		taillel = a;
		taillec = b;
		grille= new Colonne[taillel];
		for (int i=0; i<taillel; i++) {
			grille[i]= new Colonne(taillec);
		}
	}
	
	public int jouer(int k, Joueur j) {
		
		grille[k].remplir(j);
		dC= k;
		dL=grille[k].remplissage-1;
		return test();
		}
	
	public int jouerFictif1(int k1, Joueur j) {
		
		int a=0;
		int h = grille[k1].getRemplissage();
							if (h==taillec) {}
							else {		grille[k1].remplir(j);
										a = test();
										grille[k1].enlever();
							      }
				return a;						
		}
	
	


    public int test() {
    	
    
    	
    		try{if (grille[dC].tab[dL].Couleur==grille[dC].tab[dL-1].Couleur &&
    						grille[dC].tab[dL].Couleur==grille[dC].tab[dL-2].Couleur &&
    							grille[dC].tab[dL].Couleur==grille[dC].tab[dL-3].Couleur)
    		
    		{g=1;}
    		
    		}
    		
    		catch(ArrayIndexOutOfBoundsException e) {}
    		
    	
    		for (int j=dC-3; j<=dC; j++) {
    		try {if (grille[j].tab[dL].Couleur==grille[j+1].tab[dL].Couleur &&
    				      grille[j].tab[dL].Couleur==grille[j+2].tab[dL].Couleur &&
    				             grille[j].tab[dL].Couleur==grille[j+3].tab[dL].Couleur ) 
    			
    		{g=1;}
    		
    		}
    		catch(ArrayIndexOutOfBoundsException e) {continue;}
    	}
    	
    	try{if (grille[dC].tab[dL].Couleur==grille[dC+1].tab[dL+1].Couleur &&
    			grille[dC].tab[dL].Couleur==grille[dC+2].tab[dL+2].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC+3].tab[dL+3].Couleur )
    	  						{g=1;}
    	   else 				{}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	 
    	try{ if (grille[dC].tab[dL].Couleur==grille[dC-1].tab[dL-1].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC+1].tab[dL+1].Couleur &&
    					grille[dC].tab[dL].Couleur==grille[dC+2].tab[dL+2].Couleur )
    				{g=1;}
    	else		{}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	
    	try {if (grille[dC].tab[dL].Couleur==grille[dC-2].tab[dL-2].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC-1].tab[dL-1].Couleur &&
    					grille[dC].tab[dL].Couleur==grille[dC+1].tab[dL+1].Couleur )
    	{g=1;}
    	else    {}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	
    	try{ if (grille[dC].tab[dL].Couleur==grille[dC-1].tab[dL-1].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC-2].tab[dL-2].Couleur &&
    					grille[dC].tab[dL].Couleur==grille[dC-3].tab[dL-3].Couleur )
    	{g=1;}
    	else {}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	
    	try{ if (grille[dC].tab[dL].Couleur==grille[dC+1].tab[dL-1].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC+2].tab[dL-2].Couleur &&
    					grille[dC].tab[dL].Couleur==grille[dC+3].tab[dL-3].Couleur )
    	{g=1;}
    	else {}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	try{ if (grille[dC].tab[dL].Couleur==grille[dC-1].tab[dL+1].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC+1].tab[dL-1].Couleur &&
    					grille[dC].tab[dL].Couleur==grille[dC+2].tab[dL-2].Couleur )
    	{g=1;}
    	else {}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	
    	try {if (grille[dC].tab[dL].Couleur==grille[dC-2].tab[dL+2].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC-1].tab[dL+1].Couleur &&
    					grille[dC].tab[dL].Couleur==grille[dC+1].tab[dL-1].Couleur )
    	{g=1;}
    	else {}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	
    	try {if (grille[dC].tab[dL].Couleur==grille[dC-1].tab[dL+1].Couleur &&
    				grille[dC].tab[dL].Couleur==grille[dC-2].tab[dL+2].Couleur &&
    					grille[dC].tab[dL].Couleur==grille[dC-3].tab[dL+3].Couleur )
    	{g=1;}
    	else {}
    	}
    	catch(ArrayIndexOutOfBoundsException e) {}
    	
    	return g;
    	
    	}

    public int meilleurJeu(int j, Joueur[] tab) {
    	
    	int r = 0; 
    	int s=-1;
    	
    	for (int i1=0; i1<taillel; i1++) {
    		if (jouerFictif1(i1, tab[j])==1) {s=i1;
    										  r=1;
    										  break;}
    		}
    			
    	
    	if (r==0) {
    		for (int i2=0; i2<taillel; i2++) {
    			for (int k2=0; k2<n; k2++) {
    			if (k2==j) {}
    			else { if (jouerFictif1(i2, tab[k2])==1) {s=i2;
    													  r=1;
    													  break;}
    				
    			}
    		}
    	}
    }
    	
    	if (r==0) {Random rd = new Random() ; 
    				s = rd.nextInt(taillel);
    				} 
    	
    	return s;
  }
}

	
