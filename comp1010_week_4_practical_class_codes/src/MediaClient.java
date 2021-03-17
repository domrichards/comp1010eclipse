
public class MediaClient {

	public static void main(String[] args) {
		Media m1 = new Media(20, 30);
		Media m2 = new Media(15, 60);
		int status = m1.compareTo(m2);
		if(status == 1) {
			System.out.println("m1 has more frames than m2");
		}
		else if(status == -1) {
			System.out.println("m2 has more frames than m1");
		}
		else {
			System.out.println("m1 has the same number of frames as m2");
		}
	}

}
