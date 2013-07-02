package visualization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A class for exporting data to a simple format that can be parsed by a Processing applet.
 * 
 * @author jeffreymeyerson
 *
 */

public class ProcessingExporter {

	public static void exportTriangle(SimilarityTriangle similarityTriangle) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("SimilarityGraphTemplate.java"));
		File targetFile = new File("visualization.SimilarityGraph.generated.preproc.SimilarityGraph.java");
		targetFile.delete();
		try {
			targetFile.createNewFile();
		//PrintWriter writer = new PrintWriter(targetFile);
		String line = scan.nextLine();
		while(scan.hasNextLine())
		{
			line = scan.nextLine();
			if(line.contains("int xy = "))
				System.out.println(line + similarityTriangle.xy+ ";");
			else if(line.contains("int xz = "))
				System.out.println(line + similarityTriangle.xz+ ";");
			else if(line.contains("int yz = "))
				System.out.println(line + similarityTriangle.yz + ";");
			else
				System.out.println(line);
		}
//		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
