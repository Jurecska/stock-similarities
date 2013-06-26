package parser;

import java.util.Collection;

import pojos.AttributeMap;

import vector.AttributeVector;

/**
 * A singleton class for creating an AttributeVector out of an AttributeMap.
 * 
 * @author jeffreymeyerson
 * 
 */
public class ParserVectorizer {

	public static AttributeVector generateAttributeVector(AttributeMap rawAttributes) {
		AttributeVector result = new AttributeVector();
		Collection<String> attributes = rawAttributes.keySet();
		for(String attribute : attributes)
		{
			String rawData = rawAttributes.get(attribute);
			result.add(attribute, BasicRules.convertRaw(attribute, rawData));
		}
		System.out.println(attributes.toString());
		return result;
	}

}
