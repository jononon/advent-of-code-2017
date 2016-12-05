import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Part2 {

	public static void main (String args[]) {
		String input = "ffykfhsq";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			
			char[] pw = new char[8];
			for(int i = 0; (new String(pw)).indexOf('\u0000')!=-1; i++) {
				byte[] hash = md.digest((input+i).getBytes());
				String hex = (new HexBinaryAdapter()).marshal(hash);
				if(hex.substring(0, Math.min(hex.length(), 5)).equals("00000")) {
					try {
						int index = Character.getNumericValue(hex.charAt(5));
						if(pw[index]=='\u0000')
							pw[index]=hex.charAt(6);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println("Out of bounds: "+hex.charAt(5));
					}
				}
			}
			System.out.println((new String(pw)).toLowerCase());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
