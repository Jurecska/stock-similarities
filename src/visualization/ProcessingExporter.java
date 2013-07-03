package visualization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A class for exporting data to a simple format that can be parsed by a
 * Processing applet.
 * 
 * @author jeffreymeyerson
 * 
 */

public class ProcessingExporter {

	public static void exportTriangle(SimilarityTriangle similarityTriangle)
			throws FileNotFoundException {
		int x = similarityTriangle.xSize;
		int y = similarityTriangle.ySize;
		int z = similarityTriangle.zSize;
		String ticker1 = "\"" + similarityTriangle.xName + "\"";
		String ticker2 = "\"" + similarityTriangle.yName + "\"";
		String ticker3 = "\"" + similarityTriangle.zName + "\"";
		
		Scanner scan = new Scanner(new File("SimilarityGraphTemplate"));
		// TODO: stream the output straight to a file
		// File targetFile = new
		// File("visualization.SimilarityGraph.generated.preproc.SimilarityGraph.java");
		// targetFile.delete();
		// try {
		// targetFile.createNewFile();
		// PrintWriter writer = new PrintWriter(targetFile);
		String line = "";
		//TODO clean up this slop
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.contains("int xy = "))
				System.out.println(line + similarityTriangle.xy + ";");
			else if (line.contains("int xz = "))
				System.out.println(line + similarityTriangle.xz + ";");
			else if (line.contains("int yz = "))
				System.out.println(line + similarityTriangle.yz + ";");
			else if (line.contains("int x = "))
				System.out.println(line.replace("= ", "= " + x + ";"));
			else if (line.contains("int y = "))
				System.out.println(line.replace("= ","= " + y + ";"));
			else if (line.contains("int z = "))
				System.out.println(line.replace("= ","= "+  z+ ";"));
			else if (line.contains("$ticker1"))
				System.out.println(line.replace("$ticker1", ticker1));
			else if (line.contains("$ticker2"))
				System.out.println(line.replace("$ticker2", ticker2));
			else if (line.contains("$ticker3"))
				System.out.println(line.replace("$ticker3", ticker3));

			else
				System.out.println(line);
		}
		// writer.close();
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
	}

}
