package vector;

/**
 * Various utilities for working with an AttributeVector.
 * 
 * @author jeffreymeyerson
 * 
 */

public class Utilities {

	/**
	 * Computes the dot product of two vectors.
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double dotProduct(AttributeVector v1, AttributeVector v2)
	{
		double sum = 1;
		for(String key : v1.attributeNames())
		{
			boolean incompatible = (v1.getValue(key).equals(null) || v2.getValue(key).equals(null)) ? true : false;
			if(!incompatible)
				sum += v1.getValue(key) * v2.getValue(key);
		}
		return sum;
	}
	
	/**
	 * Computes the cosine similarity between two vectors. The formula is
	 * dotProduct(v1, v2) / ||v1|| * ||v2||
	 * 
	 * @param v1
	 *            a stock's attribute vector
	 * @param v2
	 *            another stock's attribute vector
	 * @return A double from -1 to 1, where -1 is maximum dissimilarity, 1 is
	 *         maximum similarity.
	 */
	public static double cosineSimilarity(AttributeVector v1, AttributeVector v2) 
	{
		return dotProduct(v1, v2) / (v1.magnitude() * v2.magnitude());
	}

}
