import java.awt.Color;

public class Joueur {
	
	public String nom;
	public Color couleur;
	public int type;
	public String couleurstring;
	public String typestring;
	
	public Joueur(String a, Color b, int c) {
		nom = a;
		couleur = b;
		type = c;
		if (b==Color.red) {couleurstring="rouge";} 
		else if (b==Color.blue) {couleurstring="bleu";}
		else if (b==Color.green) {couleurstring="vert";}
		else if (b==Color.yellow) {couleurstring="jaune";}
		else if (b==Color.black) {couleurstring="noir";}
		else {couleurstring="rose";}
	
	    if (type==1) {typestring= "humain";}
	    else { typestring="ordinateur";}
	}
	}
