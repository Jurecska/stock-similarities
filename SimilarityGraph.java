import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class SimilarityGraph extends PApplet {

public void setup(){ 
	size(600,600); 
} 
 
public void draw(){
	
	int borderMin = 30;
	int borderMax = 500; 
	
	//length of lines (similarity)
	int xy = 50;
	int xz = 50;
	int yz = 100;
	
	// length and width of nodes
	int x = 100;
	int y = 100;
	int z = 100;
	
	// Pythag
	int i = x / 2 + xz + z / 2;
	int j = borderMin + x / 2 + z / 2;
	int pythagXZ = (int)sqrt(i * i - j * j);
	
	int p1x = borderMin + x/2;
	int p1y = borderMin;
	int p2x = borderMin + x + xy;
	int p2y = borderMin;
	//int p3x =
	//int p3y =
	
	ellipse(borderMin, borderMin, x, x);
	fill(255, 0, 0);
	ellipse(borderMin, borderMin, x/4, x/4);
	fill(255, 255, 255);
	line(p1x, p1y, p2x, p2y);
	ellipse(borderMin + x + xy + y / 2, borderMin, y, y);
	fill(255, 0, 0);
	ellipse(borderMin + x + xy + y / 2, borderMin, y / 2, y / 2);
	fill(255, 255, 255);
	//ellipse(borderMin + x / 2 + xy / 2, borderMin + pythagXZ, z, z);
	//line(borderMin + x/2, borderMin, borderMin + x / 2 + xy / 2, borderMin + pythagXZ);
	
} 
    static public void main(String args[]) {
        PApplet.main(new String[] { "--bgcolor=#ECE9D8", "SimilarityGraph" });
    }
}
