package vector;
import java.util.HashMap;

/**
 * The AttributeVector class. An AttributeVector maps attribute names to a
 * Double.
 * 
 * @author jeffreymeyerson
 * 
 */
public class AttributeVector {

	private HashMap<String, Double> vector;

	public AttributeVector() {
		vector = new HashMap<String, Double>();
	}

	public void add(String attribute, Double value) {
		vector.put(attribute, value);
	}

}
