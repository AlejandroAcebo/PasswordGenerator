package password.gen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface {

	private JFrame frmPasswordGenerator;
	@SuppressWarnings("unused")
	private final JTextField textField;
	private String password;

	private Color buttonBackground = new Color(144, 238, 144);
	private Color buttonText = new Color(70, 70, 70);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmPasswordGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		this.textField = new JTextField();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Create the home frame
		frmPasswordGenerator = new JFrame();
		frmPasswordGenerator.setTitle("Password Generator");
		frmPasswordGenerator.setBounds(200, 200, 600, 400);
		frmPasswordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordGenerator.getContentPane().setLayout(null);
		frmPasswordGenerator.setLocationRelativeTo(null);
		
		// Textfield to put the name of the file where you want to save
		final JTextField nameFile = new JTextField();
		nameFile.setBounds(200, 152, 200, 26);
		nameFile.setColumns(10);    
		frmPasswordGenerator.getContentPane().add(nameFile);

		// Label of the title
		JLabel lblTitle = new JLabel("GENERATOR OF PASSWORDS");
		lblTitle.setBounds(200, 50, 400, 26);
		frmPasswordGenerator.getContentPane().add(lblTitle);
		
		// Label for instructions
		JLabel lblEnterPass = new JLabel("Enter the name of the file where you want to save your password");
		lblEnterPass.setBounds(100, 100, 400, 26);
		frmPasswordGenerator.getContentPane().add(lblEnterPass);

		// Button generate password and no save
		JButton btnGenPass = new JButton("Generate");
		btnGenPass.setBounds(220, 200, 150, 40);
		btnGenPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenPass.setBackground(buttonBackground);
		btnGenPass.setForeground(buttonText);
		
		// Button generate password and save in a file
		JButton btnGenPassAndSave = new JButton("Generate & Save");
		btnGenPassAndSave.setBounds(60, 200, 150, 40);
		btnGenPassAndSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenPassAndSave.setBackground(buttonBackground);
		btnGenPassAndSave.setForeground(buttonText);
		
		// Button exit
        JButton exitButton = new JButton("Exit");
		exitButton.setBounds(380, 200, 150, 40);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitButton.setBackground(buttonBackground);
		exitButton.setForeground(buttonText);

		// Add the buttons to the frame
		frmPasswordGenerator.add(btnGenPass);
		frmPasswordGenerator.add(btnGenPassAndSave);
		frmPasswordGenerator.add(exitButton);

		// Event listener if the button generate and no save is clicked
		btnGenPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					password = GenNoSave.genPass();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// Create the new frame where the password will be show
				JFrame showPasswordAndCopy = new JFrame("Password generated");
				showPasswordAndCopy.setTitle("Password");
				showPasswordAndCopy.setBounds(200, 200, 600, 400);
				showPasswordAndCopy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				showPasswordAndCopy.setLocationRelativeTo(null);

				// Use setbound for no using the layout of the frame
				showPasswordAndCopy.setLayout(null);

				// Label and panel of the password
				JLabel messagePassword = new JLabel("The password is :       " + password);
				JPanel pnlPassword = new JPanel();
				pnlPassword.setBounds(80, 100, 400, 26);
				pnlPassword.add(messagePassword);
				
				// Button of copy
				JButton btnCopy = new JButton("Copy");
				btnCopy.setBounds(100, 201, 150, 33);
				btnCopy.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnCopy.setBackground(buttonBackground);
				btnCopy.setForeground(buttonText);
				
				// Button of back
				JButton btnBack = new JButton("Back");
				btnBack.setBounds(300, 201, 150, 33);
				btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnBack.setBackground(buttonBackground);
				btnBack.setForeground(buttonText);

				// Add to the frame
				showPasswordAndCopy.add(btnCopy);
				showPasswordAndCopy.add(btnBack);

				// Show the new frame and hide the home frame
				showPasswordAndCopy.setVisible(true);
				frmPasswordGenerator.setVisible(false);

				// If it was clicked the password will be copy in the clipboard
				btnCopy.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						copyPassword(password);
					}	
				});

				// if it was clicked the frame of the password will hide and the main frame will show again
				btnBack.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						showPasswordAndCopy.setVisible(false);
						frmPasswordGenerator.setVisible(true);
					}
				});
				showPasswordAndCopy.getContentPane().add(pnlPassword);
				}
		});

		// Event listener if the button generate and save is clicked
		btnGenPassAndSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

				// Check if the file name is empty because a string of one or more character is required
				String name = nameFile.getText();
				if (name.isEmpty()){
					JOptionPane.showMessageDialog(null, "You have to introduce a name for the file of the password", "Error", JOptionPane.WARNING_MESSAGE);
				} else{
					try {
						password = GenAndSave.genPass(name);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					// Create the new frame where the password will be show
					JFrame showPasswordAndCopy = new JFrame("Password generated");
					showPasswordAndCopy.setTitle("Password");
					showPasswordAndCopy.setBounds(200, 200, 600, 400);
					showPasswordAndCopy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					showPasswordAndCopy.setLocationRelativeTo(null);

					// Use setbound for no using the layout of the frame
					showPasswordAndCopy.setLayout(null);

					// Label and panel of the password
					JLabel messagePassword = new JLabel("The password is :       " + password);
					JPanel pnlPassword = new JPanel();
					pnlPassword.setBounds(80, 100, 400, 26);
					pnlPassword.add(messagePassword);
					
					// Button of copy
					JButton btnCopy = new JButton("Copy");
					btnCopy.setBounds(100, 201, 150, 33);
					btnCopy.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnCopy.setBackground(buttonBackground);
					btnCopy.setForeground(buttonText);

					// Button of back
					JButton btnBack = new JButton("Back");
					btnBack.setBounds(300, 201, 150, 33);
					btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnBack.setBackground(buttonBackground);
					btnBack.setForeground(buttonText);

					// Add to the frame
					showPasswordAndCopy.add(btnCopy);
					showPasswordAndCopy.add(btnBack);

					// Show the new frame and hide the home frame
					showPasswordAndCopy.setVisible(true);
					frmPasswordGenerator.setVisible(false);

					// If it was clicked the password will be copy in your clipboard
					btnCopy.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							copyPassword(password);
						}	
					});

					// If it was clicked the frame of the password will hide and the main frame will show again
					btnBack.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							showPasswordAndCopy.setVisible(false);
							frmPasswordGenerator.setVisible(true);
						}
					});
					showPasswordAndCopy.getContentPane().add(pnlPassword);
				}
			}
		});
		
		// Event listener if the button exit is clicked it will close the frame
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frmPasswordGenerator.setVisible(true);
	}

	/**
	 * Method that expects a string that will be copy in the clipboard
	 * @param password String to copy
	 */
	public void copyPassword (String password){
		StringSelection selection = new StringSelection(password);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		JOptionPane.showMessageDialog(null, "Text copied to clipboard!", "", JOptionPane.WARNING_MESSAGE);
	}
}
