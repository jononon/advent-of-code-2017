import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Part1 {
	public static void main (String args[]) {
		ArrayList<String> rooms = readFile("input.in");
		
		int total = 0;

		for(int i = 0; i<rooms.size(); i++)
			total += verify(rooms.get(i));
		
		System.out.println(total);
		
	}
	
	public static int verify (String room) {
		Letter[] frequencies = new Letter[26];
		for(int i = 0; i<frequencies.length; i++)
			frequencies[i] = new Letter(i);
		
		char[] letters = room.substring(0, room.length()-10).toCharArray();
		for(int i = 0; i<letters.length; i++)
			if(letters[i] != '-')
				frequencies[((int)letters[i])-97].incrementFrequency();
		
		Arrays.sort(frequencies);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<Math.min(frequencies.length,5); i++)
			sb.append(frequencies[i].getLetter());
		
		if(sb.toString().equals(room.substring(room.length()-6, room.length()-1)))
			return Integer.parseInt(room.substring(room.length()-10, room.length()-7));
		return 0;
		
	}
	
	public static ArrayList<String> readFile (String filename) {
		try{
			ArrayList<String> rooms = new ArrayList<String>();
			
			Scanner s = new Scanner(new File(filename));
			
			while(s.hasNextLine())
				rooms.add(s.nextLine());
			
			s.close();
			return rooms;
		} catch (IOException e) {
			System.err.println(e);
		}
		return null;
	}
}

