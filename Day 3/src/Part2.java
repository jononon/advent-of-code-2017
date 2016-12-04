import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
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
				int[][] nextThreeRows = new int[3][3];
				for(int i = 0; i<nextThreeRows.length; i++)
					for(int j = 0; j<nextThreeRows[i].length; j++)
						nextThreeRows[i][j] = s.nextInt();
				
				for(int i = 0; i<3; i++) {
					int[] triangle = new int[3];
					triangle [0] = nextThreeRows[0][i];
					triangle [1] = nextThreeRows[1][i];
					triangle [2] = nextThreeRows[2][i];
					triangles.add(triangle);
				}
			}
			
			s.close();
			return triangles;
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}
}
