import java.awt.Color;
import java.awt.Graphics;

public class Wall {
	Vector origin;
	Vector extent;
	Vector normal;
	
	public Wall(Vector o, Vector e) {
		origin = o;
		extent = e;
		normal = e.getRotate(90);;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		Vector end = origin.add(extent);
		g.drawLine((int)origin.x, (int)origin.y, (int)end.x,(int)end.y);
		//Vector end2 = origin.add(normal.scaleToV(10)));
		//g.drawLine((int)origin.x, (int)origin.y, (int)end2.x,(int)end2.y);
	}
	
	public double getDist(Vector p) {
		double dist = 0;
		Vector end = this.origin.add(extent);
		double end_dist = Math.sqrt(Math.pow(end.x-p.x, 2)+Math.pow(end.y-p.y, 2));
		double origin_dist = Math.sqrt(Math.pow(this.origin.x-p.x, 2)+Math.pow(this.origin.y-p.y, 2));
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
			if ((x>end.x&&x>this.origin.x)||(x<end.x&&x<this.origin.x)) {
				dist = Math.min(end_dist,origin_dist);
			}
		}else if (this.extent.y!=0) {
			dist = origin.x-p.x;
			if ((p.y>end.y&&p.y>this.origin.y)||(p.y<end.y&&p.y<this.origin.y)) {
				dist = Math.min(end_dist,origin_dist);
			}
		}else {
			dist = origin.y-p.y;
			if ((p.x>end.x&&p.x>this.origin.x)||(p.x<end.x&&p.x<this.origin.x)) {
				dist = Math.min(end_dist,origin_dist);
			}
		};
		if (dist < 0) {
			dist = -dist;
		}
		return dist;
	}
	
	public Ray getRay(Vector incident,Vector p) {
		return null;
	}
}
