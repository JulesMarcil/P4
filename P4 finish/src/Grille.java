
public class Grille {
	

	public Colonne[] grille;
	public int taillel;
	public int taillec;
	public int dC;
	public int dL;
	
	public Grille(int n, int a, int b) {
		
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
	
	public int jouerfictif(int kk, Joueur jj) {
		
		int a=0;
		
		int h = grille[kk].getRemplissage();
			if (h==taillec) {}
			else { a=jouer(kk,jj);
					}
		return a;
		
	}
			
	public void enlever (int kk) {
		
		grille[kk].enlever();
	}

    public int test() {
    	
    		int g=0;
    		
    		int x=0;
    		for (int z=0; z<taillel; z++) {
    			if (grille[z].getRemplissage()==taillec) {x++;}
    		}
    		if (x==taillel) {g=2;}
    	
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
    

    }



	
