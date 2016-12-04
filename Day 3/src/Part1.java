import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part1 {
	public static void main (String args[]) {
		ArrayList<int[]> triangles = readFile("input.in");
		
		int count = 0;
		for(int[] triangle : triangles ) {
			Arrays.sort(triangle);
			if((triangle[0]+triangle[1])>triangle[2])
				count++;
		}
		System.out.println(count);
		
	}
	
	public static ArrayList<int[]> readFile (String filename) {
		try {
			ArrayList<int[]> triangles = new ArrayList<int[]>();
			Scanner s = new Scanner(new File(filename));
			
			while(s.hasNextLine()) {
				int[] triangle = new int[3];
				triangle [0] = s.nextInt();
				triangle [1] = s.nextInt();
				triangle [2] = s.nextInt();
				triangles.add(triangle);
			}
			
			s.close();
			return triangles;
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}
}
