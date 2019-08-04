
public class Vector {
	double x, y;
	
	public Vector(double nx, double ny) {
		x = nx;
		y = ny;
	}
	
	public double getLength() {
		return Math.sqrt((Math.pow(x, 2)+Math.pow(y, 2)));
	}
	
	public void scale(double s) {
		x = x*s;
		y = y*s;
	}
	
	public void rotate(double r) {
		double a = (r/180)*Math.PI;
		x = x*Math.cos(a)-y*Math.sin(a);
		y  = y*Math.cos(a)+x*Math.sin(a);
	}
	
	public void scaleTo(double l) {
		double s = l/getLength();
		scale(s);
	}
	public Vector scaleToV(double l) {
		double s = l/getLength();
		scale(s);
		//System.out.println(getLength());
		return new Vector(x,y);
	}
	
	public Vector sub(Vector v) {
		return new Vector(x-v.x, y-v.y);
	}
	public Vector add(Vector v) {
		return new Vector(x+v.x, y+v.y);
	}

}
