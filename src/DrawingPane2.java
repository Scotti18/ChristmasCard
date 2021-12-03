// Scotti Scholter-Marichal 1741428

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class DrawingPane2 extends JPanel{
    ArrayList<Grundform> sListe = new ArrayList<Grundform>();
    Color bgColor;
    
    public DrawingPane2(Color bg){
	this.bgColor = bg;
    }

    public void addForm(Grundform form){
	sListe.add(form);
    }

    public void paint(Graphics g){
	int w = this.getWidth();
	int h = this.getHeight();
	Graphics2D g2 = (Graphics2D) g;
	// antialiasing, um glatte Linien zu erhalten
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 	    
	g2.clearRect(0,0,w,h);
	g2.setColor(this.bgColor);
	g2.fillRect(0,0,w,h);

	Iterator<Grundform> it = sListe.iterator();
	while (it.hasNext()){
	    Grundform f = it.next();
	    f.paint(g);
	}	
    }

    public void paintToImage(BufferedImage img){
	Graphics g = img.getGraphics();
	this.paint(g);
    }
}
