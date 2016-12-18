import java.util.ArrayList;

public class Bot {
	private int botNumber;
	private int highValue;
	private int lowValue;
	private Bot highBot;
	private Bot lowBot;
	
	public Bot (int botNumber) {
		this.botNumber = botNumber;
		this.highValue = -1;
		this.lowValue = -1;
		this.highBot = null;
		this.lowBot = null;
	}
	
	public boolean addValue(int value) {
		if(highValue != -1 && lowValue != -1) {
			return false;
		} else if(lowValue == -1) {
			lowValue = value;
			return true;
		} else {
			if(value>=lowValue) {
				highValue = value;
				return true;
			} else {
				highValue = lowValue;
				lowValue = value;
				return true;
			}
		}
	}
	
	public boolean give() {
		if(highValue != -1 && lowValue != -1) {
			if(highBot != null)
				highBot.addValue(highValue);
			if(lowBot != null)
				lowBot.addValue(lowValue);
			highValue = -1;
			lowValue = -1;
			return true;
		}
		return false;
	}
	
	public void setHighBot(Bot highBot) {
		this.highBot = highBot;
	}
	
	public void setLowBot(Bot lowBot) {
		this.lowBot = lowBot;
	}

	public int getBotNumber() {
		return this.botNumber;
	}
	
	public boolean checkChips (int lowValue, int highValue) {
		return this.lowValue == lowValue && this.highValue == highValue;
	}
	
	public String toString () {
		return ("Bot: "+botNumber+" - Low: "+lowValue+" - High: "+highValue);
	}
}
