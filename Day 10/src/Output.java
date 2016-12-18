import java.util.ArrayList;

public class Output implements Collection {

	private int collectionNumber;
	private ArrayList<Integer> values;
	
	public Output (int collectionNumber) {
		this.collectionNumber = collectionNumber;
		values = new ArrayList<Integer>();
	}
	
	public boolean addValue(int value) {
		values.add(value);
		return true;
	}

	@Override
	public int getCollectionNumber() {
		return collectionNumber;
	}
	
	public ArrayList<Integer> getValues () {
		return values;
	}

}
