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

	public static boolean restrictedParsing = false;

	/**
	 * Parses the raw attributes mapped to an AttributeMap, formats them for
	 * AttributeVector.
	 * 
	 * TODO: Most attributes are currently not parsed correctly
	 * 
	 * @param rawAttributes
	 * @return
	 */
	public static AttributeVector generateAttributeVector(
			AttributeMap rawAttributes) {
		AttributeVector result = new AttributeVector();
		Collection<String> attributes = rawAttributes.getAttributeNames();
		for (String attribute : attributes) {
			String rawData = rawAttributes.getAttributeValue(attribute);
			Double convertedData = restrictedParsing ? RestrictedRules
					.convertRaw(attribute, rawData) : BasicRules.convertRaw(
					attribute, rawData);
			if (!convertedData.equals(0.0))
				result.add(attribute, convertedData);
		}
		result.print();
		return result;
	}

}
