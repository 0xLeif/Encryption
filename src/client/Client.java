package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import src.Decryptor;
import src.Encryption;
import src.Message;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class Client {

	private JFrame frame;
	// first screen
	private JButton en;
	private JButton de;
	// decrypt screen
	private JButton btnDecrypt;
	private JLabel lblMessage;
	private JTextField decryptTextField;
	private JTextPane decryptTextPane;
	private JTextField decryptKeyTextField;
	private JLabel decryptKey;
	// encrypt screen
	private JTextPane encryptTextPane;
	private JButton toEncrypt;
	private JLabel encryptKey;
	private JTextField encryptKeyTextField;
	// both screens
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		en = new JButton("Encrypt");
		en.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				en.setVisible(false);
				de.setVisible(false);

				btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						btnBack.setVisible(false);
						encryptTextPane.setVisible(false);
						toEncrypt.setVisible(false);
						encryptKey.setVisible(false);
						encryptKeyTextField.setVisible(false);
						
						en.setVisible(true);
						de.setVisible(true);
					}
				});
				btnBack.setBounds(0, 0, 117, 29);
				frame.getContentPane().add(btnBack);

				encryptKey = new JLabel("Key");
				encryptKey.setBounds(200, 10, 61, 16);
				frame.getContentPane().add(encryptKey);

				encryptKeyTextField = new JTextField();
				encryptKeyTextField.setBounds(225, 6, 174, 28);
				frame.getContentPane().add(encryptKeyTextField);

				encryptTextPane = new JTextPane();
				encryptTextPane.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				encryptTextPane.setBounds(0, 39, 400, 202);
				frame.getContentPane().add(encryptTextPane);

				toEncrypt = new JButton("Encrypt");
				toEncrypt.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (encryptKeyTextField.getText().length() == 10) {
							if (encryptTextPane.getText().length() > 0) {
								Encryption cryption = new Encryption(encryptKeyTextField.getText(), encryptTextPane.getText());
								encryptTextPane.setText(cryption.getMessage());
								encryptKeyTextField.setText(cryption.getKey());
							}
						}else if (encryptTextPane.getText().length() > 0) {
							Encryption cryption = new Encryption(
									encryptTextPane.getText());
							encryptTextPane.setText(cryption.getMessage());
							encryptKeyTextField.setText(cryption.getKey());
						}
					}
				});
				toEncrypt.setBounds(-40, 243, 485, 29);
				frame.getContentPane().add(toEncrypt);
			}
		});
		en.setBounds(0, 0, 200, 278);
		frame.getContentPane().add(en);

		de = new JButton("Decrypt");
		de.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				en.setVisible(false);
				de.setVisible(false);
				btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						btnBack.setVisible(false);
						btnDecrypt.setVisible(false);
						lblMessage.setVisible(false);
						decryptTextField.setVisible(false);
						decryptTextPane.setVisible(false);
						decryptKeyTextField.setVisible(false);
						decryptKey.setVisible(false);

						en.setVisible(true);
						de.setVisible(true);
					}
				});
				btnBack.setBounds(0, 0, 117, 29);
				frame.getContentPane().add(btnBack);

				decryptKey = new JLabel("Key");
				decryptKey.setBounds(10, 52, 61, 16);
				frame.getContentPane().add(decryptKey);

				decryptKeyTextField = new JTextField();
				decryptKeyTextField.setBounds(39, 46, 174, 28);
				frame.getContentPane().add(decryptKeyTextField);

				decryptTextField = new JTextField();
				decryptTextField.setBounds(80, 80, 174, 28);
				frame.getContentPane().add(decryptTextField);

				decryptTextPane = new JTextPane();
				decryptTextPane.setBounds(6, 120, 388, 152);
				frame.getContentPane().add(decryptTextPane);

				lblMessage = new JLabel("Message");
				lblMessage.setBounds(10, 86, 61, 16);
				frame.getContentPane().add(lblMessage);

				btnDecrypt = new JButton("Decrypt");
				btnDecrypt.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (decryptKeyTextField.getText().length() == 10
								&& decryptTextField.getText().length() > 0) {
							decryptTextPane.setText(Decryptor
									.decrypt(new Message(decryptKeyTextField
											.getText(), decryptTextField
											.getText())));
						}
					}
				});
				btnDecrypt.setBounds(277, 81, 117, 29);
				frame.getContentPane().add(btnDecrypt);
			}
		});
		de.setBounds(200, 0, 200, 278);
		frame.getContentPane().add(de);
	}
}
