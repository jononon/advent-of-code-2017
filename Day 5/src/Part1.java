import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Part1 {

	public static void main (String args[]) {
		String input = "ffykfhsq";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		
			StringBuilder pw = new StringBuilder();
			
			for(int i = 0; pw.length()<8; i++) {
				byte[] hash = md.digest((input+i).getBytes());
				String hex = (new HexBinaryAdapter()).marshal(hash);
				if(hex.substring(0, Math.min(hex.length(), 5)).equals("00000"))
					pw.append(hex.charAt(5));
			}
			System.out.println(pw.toString().toLowerCase());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
