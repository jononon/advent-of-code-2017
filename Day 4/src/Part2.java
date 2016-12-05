import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Part2 {
	public static void main (String args[]) {
		ArrayList<String> rooms = readFile("input.in");
		
		int total = 0;

		for(int i = 0; i<rooms.size(); i++) {
			if(verify(rooms.get(i))==0) {
				rooms.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i<rooms.size(); i++)
			rooms.set(i, unencrypt(rooms.get(i)));
		
	}
	
	public static int verify (String room) {
		Letter[] frequencies = new Letter[26];
		for(int i = 0; i<frequencies.length; i++)
			frequencies[i] = new Letter(i);
		
		char[] letters = room.substring(0, room.length()-11).toCharArray();
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
	
	public static String unencrypt (String room) {
		int sectorID = Integer.parseInt(room.substring(room.length()-10, room.length()-7));
		
		char[] roomChars = room.substring(0, room.length()-11).toCharArray();
		
		for(int i = 0; i<roomChars.length; i++) {
			if(roomChars[i] == '-')
				roomChars[i] = ' ';
			else {
				for(int j = 0; j<sectorID; j++) {
					if(roomChars[i] == 'z')
						roomChars[i] = 'a';
					else
						roomChars[i]++;
				}
			}
		}
		String output = new String(roomChars);
		if (output.equals("northpole object storage"))
			System.out.println(sectorID);
		return output;
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

