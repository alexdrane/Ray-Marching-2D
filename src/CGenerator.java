
public class CGenerator {
	public static Circle[] getCircs() {
		Circle[] cList = new Circle[20];
		for(int i = 0; i<cList.length; i++) {
			cList[i] = new Circle(new Vector((int)(Math.random() * (1000)),(int)(Math.random() * (600))),(int)(Math.random() * (100)));
		}
		return cList;
	}
}
