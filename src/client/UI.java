package client;

import java.util.Scanner;
import src.Decryptor;
import src.Encryption;
import src.Message;

public class UI {

	public static void main(String[] args) {// less then 6
		Scanner in = new Scanner(System.in);
		while (true) {
			String option = "";
			System.out.println("Please choose an option:");
			System.out.println("\t(1) Encrypt");
			System.out.println("\t(2) Decrypt");
			
			option = in.nextLine();
			if (option.toLowerCase().equals("encrypt") || option.equals("1")) {
				System.out.print("Please enter something to encrypt: ");
				String encrypt = in.nextLine();
				Encryption e = new Encryption(encrypt);
				System.out.println("Key: " + e.getKey());
				System.out.println(e.getMessage());
				System.out.println();
			} else if (option.toLowerCase().equals("decrypt") || option.equals("2")) {
				System.out.print("Please enter your key: ");
				String key = in.nextLine();
				System.out.print("Please enter your encryption: ");
				String message = in.nextLine();
				Decryptor.decrypt(new Message(key, message));
			}
		}

	}

}
