package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.JTextField;

import Main.App;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interface {

	private JFrame frmPasswordGenerator;
	private final JTextField textField;
	private String nameFile;
	private String password;

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
		// Variables
		frmPasswordGenerator = new JFrame();
		frmPasswordGenerator.setTitle("Password Generator");
		frmPasswordGenerator.setBounds(200, 200, 600, 400);
		frmPasswordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordGenerator.getContentPane().setLayout(null);
		frmPasswordGenerator.setLocationRelativeTo(null);

		// Define similar colors
        Color color1 = new Color(255, 148, 120); // Color naranja claro
        Color color2 = new Color(255, 193, 120); // Color naranja
        Color color3 = new Color(255, 235, 120); // Color amarillo
        Color color4 = new Color(203, 255, 120); // Color verde lima
		
		final JTextField textField = new JTextField();
		textField.setBounds(200, 152, 200, 26);
		frmPasswordGenerator.getContentPane().add(textField);
		textField.setColumns(10);    
		
		JLabel lblNewLabel = new JLabel("Introduzca el nombre del archivo en donde se guarda su contraseña");
		lblNewLabel.setBounds(100, 100, 400, 26);
		frmPasswordGenerator.getContentPane().add(lblNewLabel);
		
		// buttom generate password
		JButton btnNewButton = new JButton("Generate Password");
		btnNewButton.setBounds(100, 201, 150, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(color2);
		frmPasswordGenerator.add(btnNewButton);
		// buttom exit
        JButton exitButton = new JButton("Exit");
		exitButton.setBounds(300, 201, 150, 33);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitButton.setBackground(color2);
		frmPasswordGenerator.add(exitButton);

		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture the output of AnotherClass main method
				nameFile = textField.getText();
				
                try {
					password = App.genPass(nameFile);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JFrame showPasswordAndCopy = new JFrame("Password generated");

				JLabel messageField = new JLabel(password);
				JPanel panel = new JPanel();
				panel.add(messageField);
				

				// Second Jframe
				
				showPasswordAndCopy.setTitle("Password");
				showPasswordAndCopy.setBounds(200, 200, 600, 400);
				showPasswordAndCopy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				showPasswordAndCopy.setLocationRelativeTo(null);

				// Show the new frame and hide the home frame
				showPasswordAndCopy.setVisible(true);
				frmPasswordGenerator.setVisible(false);
				// Buttom of copy
				JButton btnCopy = new JButton("Copy");
				btnCopy.setBounds(100, 201, 150, 33);
				btnCopy.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnCopy.setBackground(color2);
				showPasswordAndCopy.add(btnCopy);
				// Buttom of back
				JButton btnBack = new JButton("Back");
				btnBack.setBounds(300, 201, 150, 33);
				btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnBack.setBackground(color2);
				showPasswordAndCopy.add(btnBack);
				// If it was clicked the password will be copy in your clipboard
				btnCopy.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						StringSelection selection = new StringSelection(password);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(selection, null);
						JOptionPane.showMessageDialog(null, "Text copied to clipboard!");
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
				showPasswordAndCopy.getContentPane().add(panel);
            }
		});
		
		
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        frmPasswordGenerator.setVisible(true);

	}
}
