import java.io.BufferedReader;
import java.io.FileReader;

public class Part2 {
	public static void main (String args[]) {
		try {
			FileReader fr = new FileReader("input.in");
			BufferedReader br = new BufferedReader(fr);
			String instructions = br.readLine();
			br.close();
			
			long length = 0;
			
			for(int i = 0; i<instructions.length(); i++) {
				if(instructions.charAt(i)=='(') {
					String buffLength = instructions.substring(i+1, instructions.indexOf("x", i));
					i+= buffLength.length()+1;
					String repeat = instructions.substring(i+1, instructions.indexOf(")", i));
					i+= repeat.length()+2;
					String text = instructions.substring(i, i+Integer.parseInt(buffLength));
					for(int j = 0; j<Integer.parseInt(repeat); j++) {
						length += decompress(text);
					}
					i+=text.length()-1;
				} else {
					length++;
				}
			}
			System.out.println(length);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static int decompress (String instructions) {
		int length = 0;
		
		for(int i = 0; i<instructions.length(); i++) {
			if(instructions.charAt(i)=='(') {
				String buffLength = instructions.substring(i+1, instructions.indexOf("x", i));
				i+= buffLength.length()+1;
				String repeat = instructions.substring(i+1, instructions.indexOf(")", i));
				i+= repeat.length()+2;
				String text = instructions.substring(i, i+Integer.parseInt(buffLength));
				for(int j = 0; j<Integer.parseInt(repeat); j++) {
					length += decompress(text);
				}
				i+=text.length()-1;
			} else {
				length++;
			}
		}
		return length;
	}
}
