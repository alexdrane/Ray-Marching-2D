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

}
