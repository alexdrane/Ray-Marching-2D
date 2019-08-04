import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Screen extends JPanel implements MouseMotionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -616365487435413161L;
	static int W = 1000, H = 600;
	Circle[] cList = CGenerator.getCircs();
	World world = new World(cList);
	//Ray ray = new Ray(new Vector(W,H));
	View view = new View(new Vector(500,300));
	static JFrame frame;
	
	public Screen() {
		setSize(new Dimension(W,H));
		setPreferredSize(new Dimension(W,H));
		addMouseMotionListener((MouseMotionListener) this);
		setFocusable(true);
	}
	public static void main(String[] args) {	
		Screen screen = new Screen();	
		frame = new JFrame("My Drawing");
		frame.add(screen);
		frame.pack();
    	frame.setVisible(true);
	};
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 2000, 2000);
		int x = MouseInfo.getPointerInfo().getLocation().x-frame.getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y-frame.getLocation().y;
		//ray.render(g, world, new Vector(x,y));
		view.render(g, world);
		view.updatePos(new Vector(x,y));
		world.render(g);
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
