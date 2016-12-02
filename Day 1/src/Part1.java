import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;

public class Part1 {
	public static void main (String args[]) {
		LinkedList<String> instructions = readFile("input.in");
		
		
		int x = 0, y = 0, heading = 0;
		while(instructions.size()>0) {
			String currentInstruction = instructions.pollLast();
			if(currentInstruction.substring(0, 1).equals("L")) 
				heading = Math.floorMod(heading-90,360);
			else
				heading = Math.floorMod(heading+90,360);
			
			int numSteps = Integer.parseInt(currentInstruction.substring(1));
			if(heading == 0)
				y+=numSteps;
			else if(heading == 90)
				x+=numSteps;
			else if(heading == 180)
				y-=numSteps;
			else if(heading == 270)
				x-=numSteps;
			//System.out.println(currentInstruction + " " + x + " " + y + " " + heading);
		}
		System.out.println(Math.abs(x)+Math.abs(y));
	}
	
	private static LinkedList<String> readFile (String filename) {
		LinkedList<String> instructions = new LinkedList<String>();
		try {
			Scanner s = new Scanner(new File(filename)).useDelimiter(",\\s");
			
			while (s.hasNext()) {
				instructions.push(s.next());
			}
			
			s.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return instructions;
	}
}
