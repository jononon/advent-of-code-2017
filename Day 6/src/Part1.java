import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Part1 {
	
	public static void main (String args[]) {
		ArrayList<char[]> document = readFile("input.in");
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<document.get(i).length; i++) {
			int[] popularity = new int[26];
			
			for(int j = 0; j<document.size(); j++) 
				popularity[document.get(j)[i]-97]++;
			
			int max = Integer.MIN_VALUE, index = 0;
			for(int j = 0; j<popularity.length; j++) {
				if(popularity[j] > max) {
					max = popularity[j];
					index = j;
				}
			}
			sb.append((char)(index+97));
		}
		
		System.out.println(sb);
	}
	
	public static ArrayList<char[]> readFile (String filename) {
		try {
			Scanner s = new Scanner(new File(filename));
			
			ArrayList<char[]> lines = new ArrayList<char[]>();
			
			while(s.hasNextLine())
				lines.add(s.nextLine().toCharArray());
			
			s.close();
			
			return lines;
			
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		return null;
	}
}
