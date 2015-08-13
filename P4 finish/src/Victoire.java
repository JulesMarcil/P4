import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class Victoire extends JFrame implements ActionListener {
	
	private JButton Quitter, Rejouer;
	private TextField[] T;
	private int[] scores;
	private int n;
	private Joueur[] jtab;
	private FenetreDeJeu jfen;
	private FenetreDeChoix cfen;
	
	public Victoire (Joueur j, int nf, Joueur[] tab, int[] s, FenetreDeChoix FC, FenetreDeJeu FJ) {
		
		this.setTitle("Victoire ! ! !");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);    
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        n=nf;
        scores =s;
        jtab = tab;
        jfen = FJ;
        cfen = FC;
        
        T = new TextField[n+1];
        Rejouer = new JButton("Rejouer");
        Quitter = new JButton("Quitter");
        
        
        Panel pa = new Panel();
        pa.setLayout (new GridLayout(n+1, 1));
		add(pa, BorderLayout.CENTER);
		
		T[0] = new TextField();
		T[0].setEditable(false);
		Font policeEcran7 = new Font("Dialog",Font.BOLD, 18);
		T[0].setFont(policeEcran7);
		pa.add(T[0]);
		
        for (int i = 1; i<=n; i++ ) {
        T[i] = new TextField();	
		T[i].setEditable(true);
		Font policeEcran8 = new Font("Dialog",Font.PLAIN, 18);
		T[i].setFont(policeEcran8);
		pa.add(T[i]);
        }
        
        Panel pb = new Panel();
        pb.setLayout ( new GridLayout(1, 2));
        add( pb, BorderLayout.SOUTH);
        pb.add(Rejouer);
        pb.add(Quitter);
        
        T[0].setText(j.nom + " remporte la partie !");
        
        for (int k = 1; k<=n; k++) {
        	T[k].setText(jtab[k-1].nom + " : " + scores[k-1]);
        }
        
        Rejouer.addActionListener(this);
        Quitter.addActionListener(this);
	}
	
	
	public void actionPerformed (ActionEvent arg0) {
		
		if (arg0.getSource() == Rejouer) {
		
			jfen.ViderGrille();
			dispose();
			}
		
		if (arg0.getSource() == Quitter) {
			
			jfen.dispose();
			cfen.setVisible(true);
			dispose();
			}
		
		}
	
}