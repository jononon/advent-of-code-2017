import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Part1 {

	public static void main (String args[]) {
		ArrayList<String> instructions = readFile("input.in");
			
//		ArrayList<String> instructions = new ArrayList<String>();
//		instructions.add("rect 3x2");
//		instructions.add("rotate column x=1 by 1");
//		instructions.add("rotate row y=0 by 4");
//		instructions.add("rotate column x=1 by 1");
		
		
		boolean[][] screen = new boolean[6][50];
		
		for(String instruction:instructions) {
			Scanner s = new Scanner(instruction);
			
			if(s.next().equals("rect")) {
				String dimensions = s.next();
				for(int i = 0; i<Integer.parseInt(dimensions.substring(dimensions.indexOf("x")+1)); i++)
					for(int j = 0; j<Integer.parseInt(dimensions.substring(0, dimensions.indexOf("x"))); j++)
						screen[i][j] = true;
			} else {
				boolean modifyRow = s.next().equals("row");
				String rowOrCol = s.next();
				if(modifyRow) {
					int row = Integer.parseInt(rowOrCol.substring(2));
					s.next();
					int translation = s.nextInt();
					CircularLinkedList list = new CircularLinkedList(screen[row]);
					list.moveHead(translation);
					screen[row] = list.toArray();
				} else {
					int col = Integer.parseInt(rowOrCol.substring(2));
					s.next();
					int translation = s.nextInt();
					boolean[] newArray = new boolean[screen.length];
					for(int i = 0; i<newArray.length; i++)
						newArray[i] = screen[i][col];
					CircularLinkedList list = new CircularLinkedList(newArray);
					list.moveHead(translation);
					newArray = list.toArray();
					for(int i = 0; i<newArray.length; i++)
						screen[i][col] = newArray[i];
				}
			}
			s.close();
		}
		
		int count = 0;
		for(int i = 0; i<screen.length; i++) {
			for(int j = 0; j<screen[i].length; j++) {
				System.out.print(screen[i][j]?1:0);
				if(screen[i][j])
					count++;
			}
			System.out.println();
		}
		System.out.println(count);
	}
	
	public static ArrayList<String> readFile(String filename) {
		try {
			ArrayList<String> instructions = new ArrayList<String>();
			Scanner s = new Scanner(new File(filename));
			
			while(s.hasNextLine())
				instructions.add(s.nextLine());
			
			s.close();
			return instructions;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
}
