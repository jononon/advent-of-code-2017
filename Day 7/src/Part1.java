import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Part1 {
	
	public static void main (String args[]) {
		ArrayList<String> lines = readFile("input.in");
		
//		ArrayList<String> lines = new ArrayList<String>();
//		lines.add("ioxxoj[asdfgh]zxcvbn");
		
		int count = 0;
		for(String line:lines) {
			String current = "";
			boolean ok = false;
			for(int i = 0; i<line.length(); i++) {
				if(line.charAt(i)=='[') {
					if(findABBA(current)) {
						ok = true;
					}
					current = "";
				} else if(line.charAt(i)==']') {
					if(findABBA(current)) {
						ok = false;
						break;
					}
					current = "";
				} 
				else if(i==line.length()-1) {
					current+=line.charAt(i);
					if(findABBA(current)) {
						ok = true;
					}
				} else {
					current+=line.charAt(i);
				}
				
			}
			if(ok)
				count++;
		}
		
		System.out.println(count);
		
	}
	
	public static ArrayList<String> readFile (String filename) {
		try {
			Scanner s = new Scanner(new File(filename));
			
			ArrayList<String> lines = new ArrayList<String>();
			
			while(s.hasNextLine())
				lines.add(s.nextLine());
			
			s.close();
			
			return lines;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
	public static boolean findPalindromes (String input) {
		return findPalindromes(0, input.length(), input);
	}
	
	public static boolean findABBA(String input) {
		for(int i = 0; i<input.length()-3; i++)
			if(input.substring(i, i+2).equals(reverse(input.substring(i+2, i+4))) && !input.substring(i, i+1).equals(input.substring(i+1,i+2)))
				return true;
		return false;
	}
	
	public static String reverse (String input) {
		char[] inputArr = input.toCharArray();
		char[] outputArr = new char[inputArr.length];
		for(int i = 0; i<inputArr.length; i++)
			outputArr[i] = inputArr[inputArr.length-1-i];
		return new String(outputArr);
	}
	
	public static boolean findPalindromes(int start, int end, String input) {
		if((end-start)<=3)
			return false;
		System.out.println(input.substring(start, end));
		char[] inputCharArray = input.toCharArray();
		boolean thisOne = false;
		if((end-start)==4)
		for(int i = start; i<end/2; i++) {
			//System.out.println(""+inputCharArray[i]+" "+inputCharArray[end-1-i]);
			if(inputCharArray[i]!=inputCharArray[end-1-i])
				thisOne = false;
		}
		if(!thisOne)
			thisOne = findPalindromes(start, end-1, input);
		if(!thisOne)
			thisOne = findPalindromes(start+1, end, input);	 
		return thisOne;
	}
}
