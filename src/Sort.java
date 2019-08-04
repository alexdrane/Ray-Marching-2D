
public class Sort {
	public static double getMin(double[] arr) {
		double min = arr[0];
		for (var i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
}
