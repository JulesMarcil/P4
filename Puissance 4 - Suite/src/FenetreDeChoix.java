import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

 
public class FenetreDeChoix extends JFrame implements ActionListener {
	
	private JButton b1, b2, b3, b4, b5, b6, b11, b22, b33, b44, b55, b66, b7, b8, b9;
	private int n;
	private Joueur[] jtab;
	private Joueur[] tab;
	private TextField e1, e2, e3, e4, e5, e6, e7;
	
	
	public FenetreDeChoix (String titre) {
		
		
		super(titre);
		
		this.setSize(550,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		b1 = new JButton ("Ajouter joueur1");
		b2 = new JButton ("Ajouter joueur2");
		b3 = new JButton ("Ajouter joueur3");
		b4 = new JButton ("Ajouter joueur4");
		b5 = new JButton ("Ajouter joueur5");
		b6 = new JButton ("Ajouter joueur6");
		b11 = new JButton ("Supprimer joueur1");
		b22 = new JButton ("Supprimer joueur2");
		b33 = new JButton ("Supprimer joueur3");
		b44 = new JButton ("Supprimer joueur4");
		b55 = new JButton ("Supprimer joueur5");
		b66 = new JButton ("Supprimer joueur6");
		b7 = new JButton ("Commencer la partie");
		b8 = new JButton ("Règles");
		b9 = new JButton ("Quitter");
		
		n=0;
		
		e1 = new TextField();
		e1.setEditable(false);
		Font policeEcran = new Font("Dialog",Font.PLAIN, 18);
		e1.setFont(policeEcran);
		e2 = new TextField();
		e2.setEditable(false);
		e2.setFont(policeEcran);
		e3 = new TextField();
		e3.setEditable(false);
		e3.setFont(policeEcran);
		e4 = new TextField();
		e4.setEditable(false);
		e4.setFont(policeEcran);
		e5 = new TextField();
		e5.setEditable(false);
		e5.setFont(policeEcran);
		e6 = new TextField();
		e6.setEditable(false);
		e6.setFont(policeEcran);
		e7 = new TextField();
		e7.setEditable(false);
		e7.setFont(policeEcran);
		
		
		jtab = new Joueur[6];
		e7.setText( "nombre de joueurs : " + n);
		
		Panel nord = new Panel();
		nord.add(e7);
		add(nord, BorderLayout.NORTH);
		
		Panel ouest = new Panel();
		ouest.setLayout(new GridLayout(6,1));
		ouest.add(b1);
		ouest.add(b2);
		ouest.add(b3);
		ouest.add(b4);
		ouest.add(b5);
		ouest.add(b6);
		add(ouest, BorderLayout.WEST);
		
		Panel est = new Panel();
		est.setLayout (new GridLayout(6,1));
		est.add(b11);
		est.add(b22);
		est.add(b33);
		est.add(b44);
		est.add(b55);
		est.add(b66);
		add(est, BorderLayout.EAST);
		

		
		Panel sud = new Panel();
		sud.setLayout(new GridLayout(1,3));
		sud.add(b7);
		sud.add(b8);
		sud.add(b9);
		add(sud, BorderLayout.SOUTH);
		
		Panel centre = new Panel();
		centre.setLayout(new GridLayout(6,1));
		centre.add(e1);
		centre.add(e2);
		centre.add(e3);
		centre.add(e4);
		centre.add(e5);
		centre.add(e6);
		add(centre);

		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b11.addActionListener(this);
		b22.addActionListener(this);
		b33.addActionListener(this);
		b44.addActionListener(this);
		b55.addActionListener(this);
		b66.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		

	}
	
	   public static void main(String[] args) {
		   
			FenetreDeChoix fenetre = new FenetreDeChoix("Puissance 4");
			
	   }

public int TestCouleurs(Joueur[] tab, int nn) {
	
	int r=0;
	for ( int x = 0; x<nn-1; x++) {
		for ( int y = x+1; y<n; y++ ) {
			if (tab[x].couleur==tab[y].couleur){r = 1;}
		}
	}
	return r;
}
 
 public void actionPerformed (ActionEvent arg0) {
	 
	 if (arg0.getSource() == b1) {
		 if (jtab[0]==null) {jtab[0] = CreationJoueur.CreationJoueurPanel();
		 n++;
		 try { e1.setText(jtab[0].nom + "  " + jtab[0].couleurstring + "  " + jtab[0].typestring);}
		 catch(NullPointerException e) {n--;}
		 e7.setText( "nombre de joueurs : " + n);
	 }
	 }
		
	 if (arg0.getSource() == b2) {
		 if (jtab[1]==null) {jtab[1] = CreationJoueur.CreationJoueurPanel();
		 n++;
		 try { e2.setText(jtab[1].nom + "  " + jtab[1].couleurstring + "  " + jtab[1].typestring); }
		 catch(NullPointerException e) {n--;}
		 e7.setText( "nombre de joueurs : " + n);
	 }
	 }

	 if (arg0.getSource() == b3) {
		 if (jtab[2]==null) { jtab[2] = CreationJoueur.CreationJoueurPanel();
		 n++;
		 try { e3.setText(jtab[2].nom + "  " + jtab[2].couleurstring + "  " + jtab[2].typestring);}
		 catch(NullPointerException e) {n--;}
		 e7.setText( "nombre de joueurs : " + n);
	 }
	 }
	 
	 if (arg0.getSource() == b4) {
		 if (jtab[3]==null) {jtab[3] = CreationJoueur.CreationJoueurPanel();
		 n++;
		 try {e4.setText(jtab[3].nom + "  " + jtab[3].couleurstring + "  " + jtab[3].typestring);}
		 catch(NullPointerException e) {n--;}
		 e7.setText( "nombre de joueurs : " + n);
	 }
 	 }

	 if (arg0.getSource() == b5) {
		 if (jtab[4]==null) { jtab[4] = CreationJoueur.CreationJoueurPanel();
		 n++;
		 try {e5.setText(jtab[4].nom + "  " + jtab[4].couleurstring + "  " + jtab[4].typestring);}
		 catch(NullPointerException e) {n--;}
		 e7.setText( "nombre de joueurs : " + n);
	 }
	 }	 

	 if (arg0.getSource() == b6) {
		 if (jtab[5]==null) { jtab[5] = CreationJoueur.CreationJoueurPanel();
	 	 n++;
	 	 try {e6.setText(jtab[5].nom + "  " + jtab[5].couleurstring + "  " + jtab[5].typestring);}
	 	 catch(NullPointerException e) {n--;}
	 	 e7.setText( "nombre de joueurs : " + n);
	 }
	 }

	 if (arg0.getSource() == b11) {
		 if (jtab[0]==null)  {}
		 else {jtab[0] = null;
		 		n--;
		 		e1.setText(" ");
		 		e7.setText( "nombre de joueurs : " + n);
		 		}
	 }

	 if (arg0.getSource() == b22) {
		 if (jtab[1]==null)  {}
		 else {jtab[1] = null;
		 		n--;
		 		e2.setText(" ");
		 		e7.setText( "nombre de joueurs : " + n);
		 	}
	 }	 

	 if (arg0.getSource() == b33) {
		 if (jtab[2]==null)  {}
		 else {jtab[2] = null;
		 		n--;
		 		e3.setText(" ");
		 		e7.setText( "nombre de joueurs : " + n);
		 }
	}

	 if (arg0.getSource() == b44) {
		 if (jtab[3]==null)  {}
		 else {jtab[3] = null;
		 		n--;
		 		e4.setText(" ");
		 		e7.setText( "nombre de joueurs : " + n);
		 }
	}

	 if (arg0.getSource() == b55) {
		 if (jtab[4]==null)  {}
		 else {jtab[4] = null;
		 		n--;
		 		e5.setText(" ");
		 		e7.setText( "nombre de joueurs : " + n);
		 }
	}

	if (arg0.getSource() == b66) {
		 if (jtab[5]==null)  {}
		 else {jtab[5] = null;
		 		n--;
		 		e6.setText(" ");
		 		e7.setText( "nombre de joueurs : " + n);
		 }
	}

	if (arg0.getSource() == b7) {
		
		tab = new Joueur[n];
		int alpha = 0;
		for (int j = 0; j<6; j++) {
							if (jtab[j]==null) {}
							else {tab[alpha]=jtab[j];
							alpha++;}
							}
		
		if ( n>=2 && this.TestCouleurs(tab, n)==0 ) {				
		
			FenetreDeJeu z1 = new FenetreDeJeu(n, tab, this);
			this.setVisible(false);
			}
		}

	if (arg0.getSource() == b8) {
	
	}
	
	if (arg0.getSource() == b9) {
		dispose();
	}
   }
}
  
