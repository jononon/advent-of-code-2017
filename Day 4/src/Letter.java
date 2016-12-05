public class Letter implements Comparable {
	private char letter;
	private int frequency;
	
	public Letter(int i) {
		letter = (char)(i+97);
		frequency = 0;
	}
	
	public void clearFrequency() {
		frequency = 0;
	}
	
	public void incrementFrequency() {
		frequency++;
	}

	public int getFrequency() {
		return frequency;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public int compareTo(Object o) {
		Letter l = (Letter) o;
		if (l.getFrequency()==frequency)
			return letter-l.getLetter();
		else
			return l.getFrequency()-frequency;
	}
	
	public String toString () {
		return ""+letter+"-"+frequency;
	}
}