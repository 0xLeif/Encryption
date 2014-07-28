package src;

public class Encryption {
	private Message message;

	public Encryption(String s) {
		String key = genKey();
		String mess = "";
		int loc = 0;
		for (int i = 0; i < s.length(); i++) {
				loc = i > 9 ? i % 10 : i;
				if ((int) s.charAt(i) != 32) {
					mess += (char) ((int) s.charAt(i) - (int) key.charAt(loc) % 10);
				} else {
					mess += " ";
			}
		}
		message = new Message(key, mess);
	}
	
	public Encryption(String k, String s) {
		String key = k;
		String mess = "";
		int loc = 0;
		for (int i = 0; i < s.length(); i++) {
				loc = i > 9 ? i % 10 : i;
				if ((int) s.charAt(i) != 32) {
					mess += (char) ((int) s.charAt(i) - (int) key.charAt(loc) % 10);
				} else {
					mess += " ";
			}
		}
		message = new Message(key, mess);
	}

	private String genKey() {
		String key = "";
		for (int i = 0; i < 10; i++) {
			int c = (int) (Math.random() * 74) + 48;
			if (c >= 58 && c <= 64 || c >= 91 && c <= 96) {
				i--;
			} else {
				key += (char) c;
			}
		}
		return key;
	}

	public Message toMessage() {
		return message;
	}

	public String getMessage() {
		return message.getMessage();
	}

	public String getKey() {
		return message.getKey();
	}
}
