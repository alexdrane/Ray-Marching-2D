import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	int r;
	Vector pos;
	
	public Circle(Vector p, int rad) {
		pos = p;
		r = rad;
	}
	
	public double getDist(Vector p) {
		Vector rel = pos.sub(p);
		return rel.getLength()-r;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int)pos.x-r, (int)pos.y-r, r*2, r*2);
	}
	public Ray getRay(Vector incident,Vector p) {
		return null;
	}
	
}
