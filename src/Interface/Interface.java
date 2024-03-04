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
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.JTextField;

import Main.App;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interface {

	private JFrame frmPasswordGenerator;
	private final JTextField textField;
	private String nameFile;

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

		// Define similar colors
        Color color1 = new Color(255, 148, 120); // Color naranja claro
        Color color2 = new Color(255, 193, 120); // Color naranja
        Color color3 = new Color(255, 235, 120); // Color amarillo
        Color color4 = new Color(203, 255, 120); // Color verde lima
		
		final JTextField textField = new JTextField();
		textField.setBounds(200, 152, 200, 26);
		frmPasswordGenerator.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes guardar el texto ingresado en el JTextField
                nameFile = textField.getText();
            }
        });
        
		
		JLabel lblNewLabel = new JLabel("Introduzca el nombre del archivo en donde se guarda su contraseña");
		lblNewLabel.setBounds(100, 100, 400, 26);
		frmPasswordGenerator.getContentPane().add(lblNewLabel);
		
		// buttom generate password
		JButton btnNewButton = new JButton("Generate Password");
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture the output of AnotherClass main method
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                PrintStream oldOut = System.out;
                System.setOut(ps);
                try {
					App.main(nameFile);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
                System.out.flush();
                System.setOut(oldOut);
                
                // Create a new frame to display the output
                JFrame resultFrame = new JFrame("Result");
                JTextArea textArea = new JTextArea(baos.toString());
                JScrollPane scrollPane = new JScrollPane(textArea);
                resultFrame.add(scrollPane);
                resultFrame.setSize(400, 300);
                resultFrame.setVisible(true);
            }
		});
		btnNewButton.setBounds(100, 201, 150, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(color2);
		frmPasswordGenerator.getContentPane().add(btnNewButton);
		// buttom exit
        JButton exitButton = new JButton("Exit");
		exitButton.setBounds(300, 201, 150, 33);
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		exitButton.setBackground(color2);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        frmPasswordGenerator.add(exitButton);
        frmPasswordGenerator.setVisible(true);

	}
}
