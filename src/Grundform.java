// Scotti Scholter-Marichal 1741428

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

public class Grundform {
    private Color fuellfarbe = Color.white;
    private Color randfarbe = Color.black;          
    private Point2D pos = new Point2D.Double(0,0);  // Positionsparameter (Verschiebungsvektor)
    private double scaleX = 1.0, scaleY = 1.0;      // Groessenparameter (Skalierung des Objekts)
    private double winkel = 0;  // Rotationswinkel (um den Mittelpunkt der BoundingBox) Angabe 
                                // in Math.PI / k also (180 Grad / k)
    private Shape form;         // Grundform (sollte am besten in eine BoundingBox der Groesse 10x10 passen)

    public Grundform(Shape s){
	this.form = s;
    }

    /* liefert Zentrum der BoundingBox, die form umschliesst */
    private Point2D getCenter(Shape s){
	Rectangle2D r = s.getBounds2D();
	return new Point2D.Double(r.getX() + r.getWidth() / 2, r.getY() + r.getHeight() / 2);
    }
 
    public void setPos(int x, int y){
	this.pos = new Point2D.Double(x,y);
    }

    public void setScale(double scaleX, double scaleY){
	this.scaleX = scaleX;
	this.scaleY = scaleY;
    }

    public void setRotate(double w){
	double k = 180.0 / w;
	winkel = Math.PI / k;
    }
   
    public void setFill(Color c) {
	this.fuellfarbe = c;
    }

    public void setBorder(Color c){
	this.randfarbe = c;
    }

    public void paint(Graphics g){
	/*   Aufgabenteil (a)   */
	Graphics2D g2 = (Graphics2D) g;
	Shape shape = this.createTransformedShape();
	g2.setColor(this.fuellfarbe);
	g2.fill(shape);
	g2.setColor(this.randfarbe);
	g2.draw(shape);
	
    }

    public Shape createTransformedShape(){
	/*   Aufgabenteil (a)   */
	AffineTransform at = new AffineTransform();
	at.translate(this.pos.getX(), this.pos.getY());

	at.scale(this.scaleX, this.scaleY);

	at.rotate(this.winkel,this.getCenter(this.form).getX(), this.getCenter(this.form).getY());
	
	return at.createTransformedShape(this.form); //
    }

}
