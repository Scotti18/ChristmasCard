// Scotti Scholter-Marichal 1741428

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.event.*;
//import java.io.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class A2_GUI extends JFrame {
    private static final long serialVersionUID = 1L;

    // Breiten und Hoehen fuer die einzelnen Panel
    private int  w = 600, h = 400;
    
    DrawingPane2 karte;

    public A2_GUI(){
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.createComponents();
	this.createMenu();
	this.setLocation(50,50);
	this.setSize(600, 1500);
	this.pack();
    }

    private void createComponents(){
	Container c = this.getContentPane();
	JPanel p1 = this.createKartenPanel();

	for (JPanel p : new JPanel[] {p1}){
	    p.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	}

	c.add(p1,BorderLayout.CENTER);
    }

    private void createMenu(){
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("File");
	JMenuItem item = new JMenuItem("Karte speichern");
	menu.add(item);
	menubar.add(menu);
	this.setJMenuBar(menubar);
	item.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    BufferedImage img = new BufferedImage(A2_GUI.this.karte.getWidth(),
							  A2_GUI.this.karte.getHeight(),
							  BufferedImage.TYPE_INT_ARGB);
		    A2_GUI.this.karte.paintToImage(img);
		    JFileChooser filechooser = new JFileChooser();
		    if (filechooser.showSaveDialog(A2_GUI.this) == 
			JFileChooser.APPROVE_OPTION){
			try {
			    ImageIO.write(img,"png",filechooser.getSelectedFile());
			} catch (IOException e1) {
			    e1.printStackTrace();
			}
		    };
		}
	    });
    }

    class ColorChanger extends MouseMotionAdapter {
	public void mouseMoved(MouseEvent e) {
	    Creator.changeAllColors();
	    karte.repaint();
	}
    }

    private JPanel createKartenPanel() {
	//	this.karte = new DrawingPane2(new Color(220,220,220));
	ColorChanger cL = new ColorChanger();
	this.karte = new DrawingPane2(new Color(0,0,0));
	Grundform[] formen = Creator.createAll();
	for (Grundform f : formen){
	    karte.addForm(f);
	}
	// Schrift
	karte.addMouseMotionListener(cL);
	karte.setPreferredSize(new Dimension(w,h));
	

	return karte;
    }

    public static void main(String[] args){
	A2_GUI gui = new A2_GUI();
	gui.setSize(620, 550);
	gui.setVisible(true);
    }
}
