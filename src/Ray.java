import java.awt.Color;
import java.awt.Graphics;

public class Ray {
	Vector origin;
	
	public Ray(Vector o) {
		origin = o;
	}
	
	public Vector getEnd(World w, Vector p,Graphics g) {
		Point pt = new Point(origin);
		//pt.render(g, w);
		p = p.sub(origin).scaleToV(pt.getDist(w,g));
		Vector prevP = p;
		boolean b = false;
		for (var i = 0; (b == false && i < 1000&&prevP.getLength() < 10000); i++) {
			Vector nV = origin.add(prevP);
			pt = new Point(nV);
			double s = pt.getDist(w,g);
			if (s < 0.1) {
				b = true;
			}
			prevP = prevP.add(p.scaleToV(s));
		}
		return origin.add(prevP);
	}
	
	public void render(Graphics g, World w, Vector p) {
		g.setColor(Color.YELLOW);
		Point pt = new Point(origin);
		pt.render(g, w);
		p = p.sub(origin).scaleToV(pt.getDist(w,g));
		Vector prevP = p;
		boolean b = false;
		for (var i = 0; (b == false && i < 1000&&prevP.getLength()< 10000); i++) {
			Vector nV = origin.add(prevP);
			pt = new Point(nV);
			double s = pt.getDist(w,g);
			if (s < 0.01) {
				b = true;
			}
			//System.out.println(prevP.getLength());
			prevP = prevP.add(p.scaleToV(s));
			pt.render(g, w);
		}
		g.drawLine((int)origin.x, (int)origin.y, (int)pt.pos.x, (int)pt.pos.y);
	}
	
}
