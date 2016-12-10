import java.io.BufferedReader;
import java.io.FileReader;

public class Part1 {
	public static void main (String args[]) {
		try {
			FileReader fr = new FileReader("input.in");
			BufferedReader br = new BufferedReader(fr);
			String instructions = br.readLine();
			br.close();
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<instructions.length(); i++) {
				if(instructions.charAt(i)=='(') {
					String buffLength = instructions.substring(i+1, instructions.indexOf("x", i));
					i+= buffLength.length()+1;
					String repeat = instructions.substring(i+1, instructions.indexOf(")", i));
					i+= repeat.length()+2;
					String text = instructions.substring(i, i+Integer.parseInt(buffLength));
					for(int j = 0; j<Integer.parseInt(repeat); j++) {
						sb.append(text);
					}
					i+=text.length()-1;
				} else {
					sb.append(instructions.charAt(i));
				}
			}
			System.out.println(sb);
			System.out.println(sb.length());
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
