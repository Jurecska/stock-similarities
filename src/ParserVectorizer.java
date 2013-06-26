import java.util.Collection;

/**
 * A singleton class for creating an AttributeVector out of an AttributeMap.
 * 
 * @author jeffreymeyerson
 * 
 */
public class ParserVectorizer {

	public static AttributeVector generateAttributeVector(AttributeMap rawAttributes) {
		Collection<String> attributes = rawAttributes.keySet();
		System.out.println(attributes.toString());
		return null;
	}

}
