import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;


public class FenetreDeJeu  extends JFrame implements ActionListener  {
	
	private JButton[] B;
	private Grille jeu;
	private Joueur[] tab;
	private int[] scores;
	private int n;
	private int taillel;
	private int taillec;
	private int positionactive;
	private CaseDeJeu[][] grilleGraph;
	private TextField fen;
	private int etat;
	private FenetreDeChoix cfen;
	
	
	public FenetreDeJeu (int nf, Joueur[] tabf, FenetreDeChoix FC) {
		
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
		else if (nf==5) { taillel= 17; taillec=15; }
		else { taillel= 19; taillec=18; }
		
		jeu = new Grille(nf, taillel, taillec);
		
		B = new JButton[taillel];
		for (int ii=0; ii<taillel; ii++) {
			B[ii] = new JButton ("jouer");
		}
		
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
	
	    fen.setText(tab[positionactive].nom + " à vous de jouer !");
	}
	
	public void ViderGrille() {
		
		jeu = new Grille(n, taillel, taillec);
		for (int aa = 1; aa<= taillec; aa++) {
			for (int bb = 0; bb< taillel; bb++) {
		grilleGraph[taillec-aa][bb].changerCouleurCase(Color.white);
		grilleGraph[taillec-aa][bb].repaint();
		}}
		
		
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
					
					else {}
					
					if (positionactive==n-1) {positionactive=0;}
				       else                     {positionactive++;}
					   fen.setText(tab[positionactive].nom + " à vous de jouer :");
					}
		
				}
			}
		}
	}
	


