import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;



public class Regles extends JFrame implements ActionListener {
	
	private TextField T;
	private JButton Quitter;
	private FenetreDeChoix cfen;
	private JLabel texte;
	
	public Regles(FenetreDeChoix FC) {
		
		this.setTitle("Règles du jeu");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);    
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        cfen=FC;
        
        Quitter = new JButton("Quitter");
        Quitter.addActionListener(this);
        
        Panel P = new Panel();
        P.setLayout (new GridLayout(2, 1));
		add(P, BorderLayout.CENTER);
		
        T = new TextField();
		T.setEditable(false);
		Font policeEcran7 = new Font("Dialog",Font.PLAIN, 18);
		T.setFont(policeEcran7);
		T.setSize(500,300);
		Quitter.setSize(500,100);
		
		
		texte = new JLabel("<html>Originellement ce jeu se joue à deux joueurs, " +
				"à tour de rôle ils placent leur pion dans une des colonnes, ce pion " +
				"descendant dans cette colonne. Le but est d'être le premier à réaliser " +
				"un alignement de 4 pions de sa couleur. Cet alignement peut être horizontal, " +
				"vertical ou encore diagonal.<br> Dans cette version il est possible de jouer " +
				"de 2 à 6 joueurs, les règles restant inchangées." +
				"<br><br> 2 joueurs = 7x6<br> 3 joueurs = 10x9<br> 4 joueurs = 13x12<br>" +
				" 5 joueurs = 16x15<br> 6 joueurs = 19x18</html>");
		
		
		P.add(texte);
		P.add(Quitter);
		

		
		
		
	}
	
	public void actionPerformed (ActionEvent arg0) {
		
		if (arg0.getSource() == Quitter) {
			
		
			cfen.setVisible(true);
			dispose();
			}
	}

}
