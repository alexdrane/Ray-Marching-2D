import java.awt.Color;
import java.awt.Graphics;

public class Wall {
	Vector origin;
	Vector extent;
	
	public Wall(Vector o, Vector e) {
		origin = o;
		extent = e;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		Vector end = origin.add(extent);
		g.drawLine((int)origin.x, (int)origin.y, (int)end.x,(int)end.y);
	}
	
	public double getDist(Vector p,Graphics g) {
		double dist = 0;
		if (this.extent.x!=0&&this.extent.y!=0) {
			double grad = this.extent.y/this.extent.x;
			double grad2 = -(this.extent.x/this.extent.y);
			double b = this.origin.y-(grad*this.origin.x);
			//System.out.println(grad);
			//System.out.println(b);
			//System.out.println(p.y);
			//System.out.println(p.x);
			//System.out.println(grad2);
			double c = p.y-(grad2*p.x);
			//System.out.println(c);
			double x = ((c-b)/(grad-grad2));
			//System.out.println(x);
			double y = (grad*x)+b;
			//System.out.println(y);
			double x_dist_squared = Math.pow(x-p.x,2);
			double y_dist_squared = Math.pow(y-p.y,2);
			double hyp_squared = x_dist_squared+y_dist_squared;
			dist = Math.sqrt(hyp_squared);
		}else if (this.extent.y!=0) {
			dist = origin.x-p.x;
		}else {
			dist = origin.y-p.y;
		}
		return dist;
	}
}
