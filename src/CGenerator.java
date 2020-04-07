
public class CGenerator {
	public static Circle[] getCircs(int W,int H,int n) {
		Circle[] cList = new Circle[n];
		for(int i = 0; i<cList.length; i++) {
			cList[i] = new Circle(new Vector((int)(Math.random() * (W)),(int)(Math.random() * (H))),(int)(Math.random() * (100)));
		}
		return cList;
	}
}
