// Scotti Scholter-Marichal 1741428

import java.awt.*;
import java.awt.geom.*;

public class Creator{
    private static Color[] greens = new Color[] {new Color(0,255,0),
				  new Color(0,200,0),
				  new Color(0,150,0),
				  new Color(0,100,0),
				  new Color(0,50,0)};
    
    private static Grundform[] alleFormen;
    /* returns a random value within the interval [a,b]
     */
    public static int randomInt(int a, int b){
	return (int)(Math.random() * (b-a+1)) + a;
    }

    /* creates a color with the same RGB values as the parameter c
       but with transparency set to paranmeter a
     */
    public static Color setTransparency (Color c, int a){
	int r = c.getRed();
	int g= c.getGreen();
	int b = c.getBlue();
	return new Color(r,g,b,a);
    }

    /* Beispielmethode fuer komplexe Form */
    public static Grundform createStern(){
	Area a = new Area();
	int[][] coords = new int[][] {{10,0},{5,10},{15,10},{0,20},{10,20},{20,20}};
	for (int i=0;i<coords.length;i++){
	    Grundform d = new Grundform(Formen.genDreieck());
	    d.setPos(coords[i][0],coords[i][1]);
	    a.add(new Area(d.createTransformedShape()));
	}
	
	int[][] coords2 = new int[][] {{0,10},{10,10},{20,10},{5,20},{15,20},{10,30}};
	for (int i=0;i<coords2.length;i++){
	    Grundform d = new Grundform(Formen.genDreieck());
	    d.setRotate(180); // Dreieck um 180 Grad drehen 
	    d.setPos(coords2[i][0],coords2[i][1]);
	    a.add(new Area(d.createTransformedShape()));
	}
	return new Grundform(a);
    }

    /* Beispielmethode fuer komplexe Form */
    public static Grundform createHaus(){
	Grundform d = new Grundform(Formen.genDreieck());
	d.setScale(5.0,3.0);
	Grundform r1 = new Grundform(Formen.genRechteck());
	r1.setScale(4.0,3.0);
	r1.setPos(5,30);
	Grundform r2 = new Grundform(Formen.genRechteck());
	r2.setScale(0.5,3.0);
	r2.setPos(35,3);
	Area a = new Area(d.createTransformedShape());
	a.add(new Area(r1.createTransformedShape()));
	a.add(new Area(r2.createTransformedShape()));
	return new Grundform(a);
    }

    public static Grundform[] createBaum() {
	Grundform[] allTriangles = new Grundform[121];
	Area a = new Area();
	int width = 10 * 21;
	int height = 10 * 11;
	int startX, startY;
	int rowCount = -1;
	int scale = 2;
	int counter = 0;

	for (int i=0; i<11; i++) {
	    rowCount = rowCount + 2;
	    // Start point of the first triangle
	    startX = ((width / 2) - i * 5);
	    startY = (height + i * 10);
	    for (int j=0; j<rowCount; j++) {
		Grundform d = new Grundform(Formen.genDreieck());
		// -70 -> just for positioning
		d.setPos(j*5*scale + startX*scale -70, startY*scale);
		d.setScale(scale, scale);
		if (j % 2 != 0) {
		    d.setRotate(180);
		}
		d.setFill(setTransparency(Color.green, Creator.randomInt(0, 255)));
		d.setBorder(Color.black);
		allTriangles[counter] = d;
		counter++;
	    }
	}
	return allTriangles;
    }

    public static Grundform createSnowMan() {
	Area a = new Area();
	double[] scale = {1.6, 2.2, 3};
	Grundform[] gF = new Grundform[3];
	for (int i=1; i<=gF.length; i++ ){
	    gF[i-1] = new Grundform(Formen.genEllipse());
	    gF[i-1].setScale(scale[i-1], scale[i-1]);
	    gF[i-1].setPos(10, 70+i*10);
	    a.add(new Area(gF[i-1].createTransformedShape()));
	}
	return new Grundform(a);
	
	
    }

    public static Grundform createNase() {
	Grundform nase = new Grundform(Formen.genDreieck());
	nase.setScale(2.3, 0.5);
	nase.setRotate(30);
	return nase;
    }

    public static Grundform createButtons() {
	Area a = new Area();
	Grundform[] gF = new Grundform[3];
	for (int i=1; i<=gF.length; i++ ){
	    gF[i-1] = new Grundform(Formen.genEllipse());
	    gF[i-1].setScale(0.6, 0.6);
	    gF[i-1].setPos(10+i*6, i*23);
	    a.add(new Area(gF[i-1].createTransformedShape()));
	}
	return new Grundform(a);
    }
    
    public static Grundform[] createAll(){
	// Beispielcode: Haeusergruppe erstellen
	Grundform h1 = createHaus();
	h1.setPos(190,200);
	h1.setScale(2.0,2.0);
	h1.setFill(Color.gray);
	h1.setBorder(Color.white);
	Grundform h2 = createHaus();
	h2.setPos(260,230);
	h2.setScale(1.5,1.5);
	h2.setFill(Color.gray);
	h2.setBorder(Color.white);
	Grundform h3 = createHaus();
	h3.setPos(300,170);
	h3.setScale(2.5,2.5);
	h3.setFill(Color.gray);
	h3.setBorder(Color.white);
	Grundform h4 = createHaus();
	h4.setPos(400,215);
	h4.setScale(1.75,1.75);
	h4.setFill(Color.gray);
	h4.setBorder(Color.white);
        Grundform snowMan = createSnowMan();
	snowMan.setPos(455, 120);
	snowMan.setFill(Color.white);
	snowMan.setScale(2.75, 2.75);
	Grundform[] triangles = createBaum();
	Grundform eye1 = createStern();
	eye1.setFill(Color.yellow);
	eye1.setPos(492, 350);
	eye1.setScale(0.2, 0.2);
	Grundform eye2 = createStern();
	eye2.setFill(Color.yellow);
	eye2.setPos(507, 350);
	eye2.setScale(0.2, 0.2);
	Grundform nase = createNase();
	nase.setFill(Color.orange);
	nase.setBorder(Color.red);
	nase.setPos(488, 360);
	Grundform buttons = createButtons();
	buttons.setFill(Color.black);
	buttons.setBorder(Color.black);
	buttons.setPos(492, 370);
	
	// roter Stern
	Grundform s_rot = createStern();
	s_rot.setFill(Color.red);
	s_rot.setPos(350,200);

	// Sterne am "Himmerl"
	Grundform[] sterne = new Grundform[20];
	for (int i=0;i<sterne.length;i++){
	    sterne[i] = createStern();
	    sterne[i].setFill(Color.yellow);
	    double r = Math.random();
	    sterne[i].setScale(r,r);
	    sterne[i].setPos((int)(Math.random()*600),(int)(Math.random()*100));
	}
	

	
	Grundform[] formen = new Grundform[sterne.length + 10 + triangles.length];
	int i=0;
	for (i=0;i<sterne.length; i++){
	    formen[i] =  sterne[i];  
	}
	formen[i] = h3;
	formen[i+1] = h2;
	formen[i+2] = h1;
	formen[i+3] = h4;
	formen[i+4] = s_rot;
	formen[i+5] = snowMan;
	formen[i+6] = eye1;
	formen[i+7] = eye2;
	formen[i+8] = nase;
	formen[i+9] = buttons;
	for (int j=0; j<triangles.length; j++) {
	    formen[i+10+j] = triangles[j];
	}
	//formen[i+5] = b1;
	Creator.alleFormen = formen;
	return formen; 
    }

    public static void changeAllColors() {
	for (Grundform g : Creator.alleFormen) {
	    Color c = Creator.randomColor();
	    g.setFill(c);
	}
    }

    public static Color randomColor(){
	return new Color(randomInt(0, 255),randomInt(0, 255),randomInt(0, 255), randomInt(0, 255));
    }
}
