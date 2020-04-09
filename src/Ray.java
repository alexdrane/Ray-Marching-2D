import java.awt.Color;
import java.awt.Graphics;

public class Ray {
	Vector origin;
	Vector direction;
	
	public Ray(Vector o,Vector d) {
		origin = o;
		direction = d;
	}
	
	public void update_direction(Vector d) {
		direction = d;
	}
	
	public Vector getEnd(World w) {
		Point pt = new Point(origin);
		//pt.render(g, w);
		direction = direction.sub(origin).scaleToV(pt.getDist(w));
		Vector prevP = direction;
		boolean b = false;
		for (var i = 0; (b == false && i < 1000&&prevP.getLength() < 10000); i++) {
			Vector nV = origin.add(prevP);
			pt = new Point(nV);
			double s = pt.getDist(w);
			if (s < 0.1) {
				b = true;
			}
			prevP = prevP.add(direction.scaleToV(s));
		}
		return origin.add(prevP);
	}
	
	public void render(Graphics g, World w,int raynum) {
		g.setColor(Color.YELLOW);
		Point pt = new Point(origin);
		Vector prevP;
		if (raynum > 20) {
			return;
		} else if (raynum > 0) {
			prevP = direction.scaleToV(pt.getDist(w)+0.1);
		} else {
			prevP = direction.scaleToV(pt.getDist(w));
		}
		//pt.render(g, w);
		boolean b = false;
		for (var i = 0; (b == false && i < 100&&prevP.getLength()< 10000); i++) {
			Vector nV = origin.add(prevP);
			pt = new Point(nV);
			double s = pt.getDist(w);
			if (s < 0.1) {
				Ray newRay = w.getRay(pt, direction);
				if (newRay != null) {
					//newRay.origin.print();
					newRay.render(g, w,raynum+1);
				}
				b = true;
			}
			//System.out.println(prevP.getLength());
			prevP = prevP.add(direction.scaleToV(s));
			//pt.render(g, w);
		}
		g.drawLine((int)origin.x, (int)origin.y, (int)pt.pos.x, (int)pt.pos.y);
	}
	
}
