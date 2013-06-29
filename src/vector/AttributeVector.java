package vector;
import java.util.HashMap;
import java.util.Set;

/**
 * The AttributeVector class. An AttributeVector maps Stock attribute names to a
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
	
	public String toString(){
		return vector.toString();
	}

	public void print() {
		for(String attributeName : vector.keySet())
			System.out.println(attributeName + " : " + vector.get(attributeName));
	}

	public Set<String> attributeNames() {
		return vector.keySet();
	}

	public Double getValue(String key) {
		return vector.get(key);
	}

	public double magnitude() {
		Double sum = 0.0;
		for(Double value : vector.values())
			sum += value * value;
		return Math.sqrt(sum);
	}

}
