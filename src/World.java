import java.awt.Graphics;

public class World {
	
	Circle[] circs;
	
	public World(Circle[] c) {
		circs = c;
	}
	
	public void render(Graphics g) {
		for (var i = 0; i < circs.length; i++) {
			circs[i].draw(g);
		}
	}

}
