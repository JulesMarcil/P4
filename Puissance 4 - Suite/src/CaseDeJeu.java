import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
 
public class CaseDeJeu extends JPanel {
	
	private Color couleurcase;
	
	public CaseDeJeu( Color c) {
		
		couleurcase = c;
	}
 
	public void changerCouleurCase (Color co) {
		
		couleurcase = co;
	}
    
	public void paintComponent(Graphics g){
        		
        	int w=getSize().width;
        	int h=getSize().height;
        	
        	g.setColor(Color.blue);
        	g.fillRect(0,0,w,h);
        	g.setColor(couleurcase);
        	g.fillOval(0, 0, 9*w/10, 9*h/10);
        	g.setColor(Color.black);
        	g.drawOval(0, 0, 9*w/10, 9*h/10);
          
        }               
}
