import java.awt.Graphics;

public class World {
	
	Circle[] circs;
	Wall[] walls;
	
	public World(Circle[] c, Wall[] w) {
		circs = c;
		walls = w;
	}
	
	public void render(Graphics g) {
		for (var i = 0; i < circs.length; i++) {
			circs[i].draw(g);
		}for (var i = 0; i < walls.length; i++) {
			walls[i].render(g);
		}
	}
	
	public Ray getRay(Point pt,Vector incident){
		for (var i = 0; i<circs.length;i++) {
			if (circs[i].getDist(pt.pos)<0.1) {
				return circs[i].getRay(incident,pt.pos);
			}
		}for (var i = 0; i<walls.length;i++) {
			if (walls[i].getDist(pt.pos)<0.1) {
				return walls[i].getRay(incident,pt.pos);
			}
		}
		return null;
	}

}
