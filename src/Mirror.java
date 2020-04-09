import java.awt.Color;
import java.awt.Graphics;

public class Mirror extends Wall{

	public Mirror(Vector or, Vector dir) {
		super(or, dir);
	}
	public Ray getRay(Vector incident,Vector p) {
		double difference = incident.getRadian()-this.normal.getRadian();
		double ang = Math.PI+(this.normal.getRadian()-difference);
		Vector dir  = new Vector(Math.cos(ang),Math.sin(ang));
		//System.out.println(difference);
		return new Ray(p,dir);
	}
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		Vector end = origin.add(extent);
		g.drawLine((int)origin.x, (int)origin.y, (int)end.x,(int)end.y);
		//Vector end2 = origin.add(normal.scaleToV(10));
		//g.drawLine((int)origin.x, (int)origin.y, (int)end2.x,(int)end2.y);
	}
}
