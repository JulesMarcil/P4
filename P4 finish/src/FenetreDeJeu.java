import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;


public class FenetreDeJeu  extends JFrame implements ActionListener  {
	
	public JButton[] B;
	public Grille jeu;
	public Joueur[] tab;
	public int[] scores;
	public int n;
	public int taillel;
	public int taillec;
	public int positionactive;
	public CaseDeJeu[][] grilleGraph;
	public TextField fen;
	public int etat;
	public FenetreDeChoix cfen;
	public MeilleurJeu meiljeu;
	
	
	public FenetreDeJeu (int nf, Joueur[] tabf, FenetreDeChoix FC) {
		
		//Création de la fenêtre
		
		this.setTitle("Puissance 4 multijoueur");
		if (nf==2) { this.setSize(600, 500); }
		else if (nf==3) { this.setSize(700, 600); }
		else if (nf==4) { this.setSize(800, 700); }
		else if (nf==5) { this.setSize(900, 800); }
		else { this.setSize(900, 800); }
        this.setLocationRelativeTo(null);    
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (nf==2) { taillel= 7; taillec=6; }
		else if (nf==3) { taillel= 10; taillec=9; }
		else if (nf==4) { taillel= 13; taillec=12; }
		else if (nf==5) { taillel= 16; taillec=15; }
		else { taillel= 19; taillec=18; }
		
		jeu = new Grille(nf, taillel, taillec);
		
		B = new JButton[taillel];
		for (int ii=0; ii<taillel; ii++) {
			B[ii] = new JButton ("jouer");
		}
		
		//importation des données de la FenêtreDeChoix
		
		n=nf;
		tab = tabf;
		positionactive = 0;
		etat=0;
		scores = new int[n];
		for (int ii=0; ii<n; ii++) {scores[ii] = 0;}
		cfen=FC;
		
		grilleGraph = new CaseDeJeu[taillec][taillel];
		for (int a = 1; a<= taillec; a++) {
			for (int b = 1; b<= taillel; b++) {
		grilleGraph[a-1][b-1] = new CaseDeJeu(Color.white);
		}}
		
		fen = new TextField();
		fen.setEditable(false);
		Font policeEcran7 = new Font("Dialog",Font.PLAIN, 18);
		fen.setFont(policeEcran7);
		
		Panel pa = new Panel();
		pa.add(fen);
		add(pa, BorderLayout.NORTH);
		
		Panel pb = new Panel();
		pb.setLayout(new GridLayout(taillec, taillel));
		add(pb, BorderLayout.CENTER);
		for (int a = 1; a<= taillec; a++) {
			for (int b = 0; b< taillel; b++) {
		pb.add(grilleGraph[taillec-a][b]);
		}}
		
		Panel pc = new Panel();
		pc.setLayout (new GridLayout(1,taillel));
		for(int kk=0; kk<taillel; kk++) {
			pc.add(B[kk]);}
		add(pc, BorderLayout.SOUTH);
	
		for (int j = 0; j<taillel; j++) {
		B[j].addActionListener(this);
		}
	
		this.ViderGrille();
	    fen.setText(tab[positionactive].nom + " à vous de jouer !");
	}
	
	public void ViderGrille() {
		
		jeu = new Grille(n, taillel, taillec);
		etat = 0;
		for (int aa = 1; aa<= taillec; aa++) {
			for (int bb = 0; bb< taillel; bb++) {
		grilleGraph[taillec-aa][bb].changerCouleurCase(Color.white);
		grilleGraph[taillec-aa][bb].repaint();
		}}
		
		//faire jouer l'ordinateur tant qu'il faut, on retrouve ce code en (*) ! ! ! ! ! ! ! ! ! ! ! ! ! !
		
		for (int zzz=0; zzz<taillel*taillec; zzz++) {			
			
			if (tab[positionactive].type==1) {}
				else{if (etat==1) {}
						else {
		
				
				//1) trouver le meilleur jeu
				
				meiljeu = new MeilleurJeu(tab,n,jeu,positionactive);
				System.out.println("meiljeu = "+ meiljeu.resultat);
				//2) le jouer
				
				int h1 = jeu.grille[meiljeu.resultat].getRemplissage();
				if (h1==taillec) { fen.setText( "Colonne pleine, " + tab[positionactive].nom + " recommencez !");
									}
				else 	{etat = jeu.jouer(meiljeu.resultat,tab[positionactive]);
						grilleGraph[h1][meiljeu.resultat].changerCouleurCase(tab[positionactive].couleur);
						grilleGraph[h1][meiljeu.resultat].repaint();
						
						if (etat==1) { fen.setText("C'est gagné ! ! !");
						               scores[positionactive]++;
						               
						               Victoire v1 = new Victoire(tab[positionactive], n, tab, scores, cfen, this);
						               
						
						}
						
						else if (etat==2) {
							
										fen.setText("Match nul . . .");
										Victoire v1 = new Victoire(tab[positionactive], n, tab, scores, cfen, this);
						}
						
						else {}
						
						if (positionactive==n-1) {positionactive=0;}
					       else                     {positionactive++;}
						   
				
			}
			}		
			}			
			}	
				//Annoncer le prochain joueur humain		
						
			fen.setText(tab[positionactive].nom + " à vous de jouer :");
		
	}
	
	public void actionPerformed (ActionEvent arg0) {
		

		for (int k=0; k<taillel; k++) {
		if (arg0.getSource() == B[k]) {
			
			int h = jeu.grille[k].getRemplissage();
			if (h==taillec) { fen.setText( "Colonne pleine, " + tab[positionactive].nom + " recommencez !");
								}
			else 	{etat = jeu.jouer(k,tab[positionactive]);
					grilleGraph[h][k].changerCouleurCase(tab[positionactive].couleur);
					grilleGraph[h][k].repaint();
					
					if (etat==1) { fen.setText("C'est gagné ! ! !");
					               scores[positionactive]++;
					               
					               Victoire v1 = new Victoire(tab[positionactive], n, tab, scores, cfen, this);
					               
					
					}
					
					else if (etat==2) {
						
						fen.setText("Match nul . . .");
						Victoire v1 = new Victoire(tab[positionactive], n, tab, scores, cfen, this);
		}
					
					else {}
					
					if (positionactive==n-1) {positionactive=0;}
				       else                     {positionactive++;}
					   
					
		//(*) début du jeu de l'ordinateur	après un coup humain ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! !		
		
		for (int zz=0; zz<n; zz++) {			
					
		if (tab[positionactive].type==1) {}
			else{if (etat==1) {}
					else {
	
			
			//1) trouver le meilleur jeu
			
			meiljeu = new MeilleurJeu(tab,n,jeu,positionactive);
			System.out.println( "meiljeu = " + meiljeu.resultat);
			
			//2) le jouer
			
			h = jeu.grille[meiljeu.resultat].getRemplissage();
			if (h==taillec) { fen.setText( "Colonne pleine, " + tab[positionactive].nom + " recommencez !");
								}
			else 	{etat = jeu.jouer(meiljeu.resultat,tab[positionactive]);
					grilleGraph[h][meiljeu.resultat].changerCouleurCase(tab[positionactive].couleur);
					grilleGraph[h][meiljeu.resultat].repaint();
					
					if (etat==1) { fen.setText("C'est gagné ! ! !");
					               scores[positionactive]++;
					               
					               Victoire v1 = new Victoire(tab[positionactive], n, tab, scores, cfen, this);
					               
					
					}
					
					else if (etat==2) {
						
						fen.setText("Match nul . . .");
						Victoire v1 = new Victoire(tab[positionactive], n, tab, scores, cfen, this);
		}
					
					else {}
					
					if (positionactive==n-1) {positionactive=0;}
				       else                     {positionactive++;}
					   
			
		}
		}		
		}			
		}	
			//Annoncer le prochain joueur humain		
					
		fen.setText(tab[positionactive].nom + " à vous de jouer :");
					}
		
				}
			}
		}
	}
	


