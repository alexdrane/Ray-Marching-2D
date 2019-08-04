import java.awt.Graphics;

public class Point {
	Vector pos;
	public Point(Vector p) {
		pos = p;
	}
	
	public void render(Graphics g, World w) {
		double dist = getDist(w);
		g.drawOval((int)(pos.x-dist), (int)(pos.y-dist), (int)dist*2, (int)dist*2);
		g.fillOval((int)pos.x-2, (int)pos.y-2, 4, 4);
	}
	
	public double getDist(World w) {
		double[] dists = new double[w.circs.length];
		for (var i = 0; i < w.circs.length; i++) {
			Circle circ = w.circs[i];
			double dist = circ.getDist(pos);
			dists[i] = dist;
		}
		double dist = Sort.getMin(dists);
		return dist;
	}
	
	public void updatePos(Vector v) {
		pos = v;
	}
	
}
