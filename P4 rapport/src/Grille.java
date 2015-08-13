
public class Grille {
	

	public Colonne[] grille;
	private int taillel;
	private int taillec;
	private int dC;
	private int dL;
	private int g;
	
	public Grille(int n, int a, int b) {
		
		g=0;
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


}
	
