package src;

public class Decryptor {

	public static String decrypt(Message m) {
		String mess = "";
		int loc = 0;
		for (int i = 0; i < m.getMessage().length(); i++) {
			loc = i > 9 ? i % 10 : i;
			if ((int) m.getMessage().charAt(i) != 32) {
				mess += (char) ((int) m.getMessage().charAt(i) + (int) m
						.getKey().charAt(loc) % 10);
			} else {
				mess += " ";
			}
		}
		return mess;
	}

}
