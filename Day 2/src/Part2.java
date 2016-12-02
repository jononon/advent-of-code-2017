import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Part2 {

	public static void main (String args[]) {
		char[][] keypad =   {{'X','X','1','X','X'},
							{'X','2','3','4','X'},
							{'5','6','7','8','9'},
							{'X','A','B','C','X'},
							{'X','X','D','X','X'}};
		
		LinkedList<String> instructions = readFile("input.in");
		
		int y = 1, x = 1;
		StringBuilder code = new StringBuilder();
		while (instructions.size()>0) {
			char[] instruction = instructions.pollLast().toCharArray();
			
			for(char curr:instruction) {
				if(curr == 'U' && y>0 && keypad[y-1][x]!='X')
					y--;
				else if(curr == 'L' && x>0 && keypad[y][x-1]!='X')
					x--;
				else if(curr == 'D' && y<keypad.length-1 && keypad[y+1][x]!='X')
					y++;
				else if(curr == 'R' && x<keypad[y].length-1 && keypad[y][x+1]!='X')
					x++;
			}
			code.append(keypad[y][x]);
		}
		
		System.out.println(code.toString());
		
	}
	
	public static LinkedList<String> readFile (String filename) {
		LinkedList<String> instructions = new LinkedList<String>();
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String next = br.readLine();
			while(next != null) {
				instructions.push(next);
				next = br.readLine();
			}
			
			br.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		return instructions;
	}
	
}
