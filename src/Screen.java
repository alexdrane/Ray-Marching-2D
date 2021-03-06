import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Screen extends JPanel implements MouseMotionListener{
	
	private static final long serialVersionUID = -616365487435413161L;
	static int W = 1800, H = 900;
	Circle[] cList = CGenerator.getCircs(W,H,2);
	Wall[] wList = CGenerator.getWalls(W,H,20);
	World world = new World(cList,wList);
	Ray ray = new Ray(new Vector(0,0),new Vector(-1,-1));
	//View view = new View(new Vector(500,300));
	static JFrame frame;
	int x,y;
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
	    ray.update_direction(new Vector(x-ray.origin.x,y-ray.origin.y));
		ray.render(g, world,0);
		//view.render(g, world);
		//view.updatePos(new Vector(x,y));
		world.render(g);
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x =  e.getXOnScreen();
		y = e.getYOnScreen();
	}
	
}
