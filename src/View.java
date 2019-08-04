import java.awt.Color;
import java.awt.Graphics;

public class View {
	Vector position;
	public View(Vector pos) {
		position = pos;
	}
	
	public void updatePos(Vector n) {
		position = n;
	}
	
	public void render(Graphics g, World w) {
		int a = 360;
		double r1 = (360/a);
		Vector[] endpoints = new Vector[a];
		Vector v = new Vector(1,0);
		v.rotate(0.1);
		for (var i = 0; i < a; i++) {
			Ray r = new Ray(position);
			r.render(g, w, v.add(position));
			endpoints[i] = r.getEnd(w, v.add(position));
			//System.out.println(endpoints[i].x);
			//System.out.println(endpoints[i].y);
			v.rotate(r1);
		}
		int[] xArr = new int[a];
		int[] yArr = new int[a];
		for (var i = 0; i < endpoints.length; i++) {
			xArr[i] = (int) endpoints[i].x;
			yArr[i] = (int) endpoints[i].y;
		}
		//draw(g,xArr,yArr);
	}
	
	public void draw(Graphics g, int[] x, int[] y) {
		g.setColor(Color.YELLOW);
		g.fillPolygon(x,y, x.length);
		g.setColor(Color.BLACK);
		//System.out.println("Drew");
	}

}
