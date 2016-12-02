import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;

public class Part2 {
	public static void main (String args[]) {
		LinkedList<String> instructions = readFile("input.in");
		
		int[][] map = new int[1000][1000];
		
		int x = 0, y = 0, heading = 0;
		while(instructions.size()>0) {
			String currentInstruction = instructions.pollLast();
			if(currentInstruction.substring(0, 1).equals("L")) 
				heading = Math.floorMod(heading-90,360);
			else
				heading = Math.floorMod(heading+90,360);
			
			int numSteps = Integer.parseInt(currentInstruction.substring(1));
			while(numSteps>0) {
				if(heading == 0)
					y+=1;
				else if(heading == 90)
					x+=1;
				else if(heading == 180)
					y-=1;
				else if(heading == 270)
					x-=1;
				map[500+y][500+x]++;
			
				if(map[500+y][500+x]>1)
					System.out.println("Coordinates "+x+","+y+" visited "+map[500+y][500+x]+" times - Distance: "+(Math.abs(x)+Math.abs(y)));
				
				numSteps--;
			}
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
