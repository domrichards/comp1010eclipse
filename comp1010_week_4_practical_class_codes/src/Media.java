
public class Media {
	public double length; //in seconds
	public int frameRate; //in frames per second
	
	/**
	 * 
	 * @param len: for length
	 * @param fps: for frameRate
	 */
	public Media(double len, int fps) {
		this.length=len;
		this.frameRate=fps;
	}
	
	/**
	 * 
	 * @return the total number of pixels in the calling object
	 * For example, for a 20 second media recorded at 30 frames per second,
	 * total frames is 600.
	 */
	public int totalFrameCount() {
	/*	int totalFrameCount = 0;
		totalFrameCount = (int)length * frameRate;
		
		return totalFrameCount; */
		
		return (int)this.length*this.frameRate;
		
	}
	
	/**
	 * 
	 * @param other
	 * @return 1 if calling object is "more than" parameter object
	 * -1 if calling object is "less than" parameter object
	 * 0 if calling object is "equal to" parameter object
	 * 
	 * comparison criteria: totalFrameCount
	 */
	public int compareTo(Media other) {
		if(this.totalFrameCount() > other.totalFrameCount()) {
			return 1;
		}
		
		if(this.totalFrameCount() < other.totalFrameCount()) {
			return -1;
		}
		return 0;
	}
}
