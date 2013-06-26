package parser;

/**
 * An example collection of rules for parsing and standardizing Yahoo Finance text.
 * 
 * @author jeffreymeyerson
 *
 */
public class BasicRules{

	/**
	 * Converts a line of raw text to a standardized double.
	 * @param raw
	 * @return
	 */
	public static double convertRaw(String statisticName, String rawData){
		System.out.println("Conversion of " + statisticName + " : " + rawData);
		return 0;
	}
	
}
