import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Part2 {
	public static void main (String args[]) {
		ArrayList<String> instructions = readFile("input.in");
		
		ArrayList<Bot> bots = new ArrayList<Bot>();
		ArrayList<Output> outputs = new ArrayList<Output>();
		
		for(String instruction:instructions) {
			Scanner s = new Scanner(instruction);
			
			if(s.next().equals("value")) {
				int value = s.nextInt();
				s.next();s.next();s.next();
				
				int botNumber = s.nextInt();
				Bot currentBot = null;
				for(int i = 0; i<bots.size(); i++) {
					if(bots.get(i).getCollectionNumber()==botNumber) {
						currentBot = bots.get(i);
						break;
					}
				}
				if(currentBot == null) {
					currentBot = new Bot(botNumber);
					bots.add(currentBot);
				}
				currentBot.addValue(value);
			} else {
				int botNumber = s.nextInt();
				Bot currentBot = null;
				for(int i = 0; i<bots.size(); i++) {
					if(bots.get(i).getCollectionNumber()==botNumber) {
						currentBot = bots.get(i);
						break;
					}
				}
				if(currentBot == null) {
					currentBot = new Bot(botNumber);
					bots.add(currentBot);
				}
				s.next();s.next();s.next();
				if(s.next().equals("bot")) {
					int lowBotNumber = s.nextInt();
					Bot lowBot = null;
					for(int i = 0; i<bots.size(); i++) {
						if(bots.get(i).getCollectionNumber()==lowBotNumber) {
							lowBot = bots.get(i);
							break;
						}
					}
					if(lowBot == null) {
						lowBot = new Bot(lowBotNumber);
						bots.add(lowBot);
					}
					currentBot.setLowBot(lowBot);
				} else {
					int lowBotNumber = s.nextInt();
					Output lowBot = null;
					for(int i = 0; i<outputs.size(); i++) {
						if(outputs.get(i).getCollectionNumber()==lowBotNumber) {
							lowBot = outputs.get(i);
							break;
						}
					}
					if(lowBot == null) {
						lowBot = new Output(lowBotNumber);
						outputs.add(lowBot);
					}
					currentBot.setLowBot(lowBot);
				}
				s.next();s.next();s.next();
				if(s.next().equals("bot")) {
					int highBotNumber = s.nextInt();
					Bot highBot = null;
					for(int i = 0; i<bots.size(); i++) {
						if(bots.get(i).getCollectionNumber()==highBotNumber) {
							highBot = bots.get(i);
							break;
						}
					}
					if(highBot == null) {
						highBot = new Bot(highBotNumber);
						bots.add(highBot);
					}
					currentBot.setHighBot(highBot);
				} else {
					int highBotNumber = s.nextInt();
					Output highBot = null;
					for(int i = 0; i<outputs.size(); i++) {
						if(outputs.get(i).getCollectionNumber()==highBotNumber) {
							highBot = outputs.get(i);
							break;
						}
					}
					if(highBot == null) {
						highBot = new Output(highBotNumber);
						outputs.add(highBot);
					}
					currentBot.setHighBot(highBot);
				}
			}
			s.close();
		}
		System.out.println("loaded instructions");
		boolean cont;
		do {
			cont = false;
			for(int i = 0; i<bots.size(); i++) {
				if(bots.get(i).checkChips(17, 61))
//				if(bots.get(i).checkChips(2, 5))
					System.out.println(bots.get(i).getCollectionNumber());
//				System.out.println(bots.get(i));
				if(bots.get(i).give()) {
					cont = true;
					
				}
			}
		} while (cont);
		
		int product = 1;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<outputs.size(); j++)
				if(outputs.get(j).getCollectionNumber()==i)
					product*=outputs.get(j).getValues().get(0);
		}
		System.out.println(product);
	}
	
	public static ArrayList<String> readFile (String filename) {
		ArrayList<String> instructions = new ArrayList<String>();
		try{
			Scanner s = new Scanner(new File(filename));
			while (s.hasNextLine())
				instructions.add(s.nextLine());
			s.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return instructions;
	}
}
