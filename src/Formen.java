// Scotti Scholter-Marichal 1741428

import java.awt.*;
import java.awt.geom.*;


public class Formen {
    public static final int w = 10; // Breite (der Bounding Box) fuer die Grundformen
    public static final Shape rechteck = new Rectangle2D.Double(0,0,w,w);
    public static final Shape ellipse = new Ellipse2D.Double(0,0,w,w); 
    public static final Shape dreieck = new Polygon(new int[] {w/2,w,0}, new int[] {0,w,w}, 3);


    // liefert eine Kopie von rechteck
    public static Shape genRechteck(){
	return new AffineTransform().createTransformedShape(rechteck);
    }

    // liefert eine Kopie von ellipse
    public static Shape genEllipse(){
	return new AffineTransform().createTransformedShape(ellipse);
    }

    // liefert eine Kopie von dreieck
    public static Shape genDreieck(){
	return new AffineTransform().createTransformedShape(dreieck);
    }
}
