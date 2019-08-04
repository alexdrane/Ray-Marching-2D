import java.awt.Color;
import java.awt.Graphics;

public class Ray {
	Vector origin;
	
	public Ray(Vector o) {
		origin = o;
	}
	
	public Vector getEnd(World w, Vector p) {
		Point pt = new Point(origin);
		//pt.render(g, w);
		p = p.sub(origin).scaleToV(pt.getDist(w));
		Vector prevP = p;
		boolean b = false;
		for (var i = 0; (b == false && i < 100&&prevP.getLength() < 2000); i++) {
			Vector nV = origin.add(prevP);
			pt = new Point(nV);
			double s = pt.getDist(w);
			if (s < 0.1) {
				b = true;
			}
			prevP = prevP.add(p.scaleToV(s));
		}
		return origin.add(prevP);
	}
	
	public void render(Graphics g, World w, Vector p) {
		Point pt = new Point(origin);
		//pt.render(g, w);
		p = p.sub(origin).scaleToV(pt.getDist(w));
		Vector prevP = p;
		boolean b = false;
		for (var i = 0; (b == false && i < 100&&prevP.getLength()< 2000); i++) {
			Vector nV = origin.add(prevP);
			pt = new Point(nV);
			double s = pt.getDist(w);
			if (s < 0.01) {
				b = true;
			}
			//System.out.println(prevP.getLength());
			prevP = prevP.add(p.scaleToV(s));
			//pt.render(g, w);
		}
		g.setColor(Color.YELLOW);
		g.drawLine((int)origin.x, (int)origin.y, (int)pt.pos.x, (int)pt.pos.y);
	}
	
}
