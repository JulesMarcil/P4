import javax.swing.JOptionPane;
import java.awt.Color;

public class CreationJoueur {
	
	static Joueur CreationJoueurPanel() {
		

		String nomj = JOptionPane.showInputDialog(null, "Veuillez entrer le nom du joueur", "Création du joueur", JOptionPane.QUESTION_MESSAGE);
	
		String[] couleurtab = {"rouge", "bleu", "vert", "jaune", "noir", "rose"};

		String c = (String)JOptionPane.showInputDialog(null, 
										"Veuillez choisir votre couleur",
										"Création du joueur",
										JOptionPane.QUESTION_MESSAGE,
										null,
										couleurtab,
										couleurtab[0]);
		
		 Color couleurj;
		 if (c=="rouge") { couleurj=Color.red;}
		 else if (c=="bleu") { couleurj=Color.blue;}
		 else if (c=="vert") { couleurj=Color.green;}
		 else if (c=="jaune") { couleurj=Color.yellow;}
		 else if (c=="noir") { couleurj=Color.black;}
		 else { couleurj=Color.pink;}
		 
		String[] typetab = {"humain", "ordinateur"};
		String t = (String)JOptionPane.showInputDialog(null, 
											"Veuillez choisir votre type",
											"Création du joueur",
											JOptionPane.QUESTION_MESSAGE,
											null,
											typetab,
											typetab[0]);
		
		int typej;
		if (t=="humain") { typej=1; }
		else { typej=2; }
		
		Joueur j;
		if (t==null) {j=null;}
		else if (c==null) {j=null;}
		else if (nomj==null) {j=null;}
		else {j = new Joueur( nomj, couleurj, typej);}
		return j;

	}

	}

