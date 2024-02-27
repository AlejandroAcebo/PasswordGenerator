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
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Interface {

	private JFrame frmPasswordGenerator;
	private JTextField textField;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPasswordGenerator = new JFrame();
		frmPasswordGenerator.setTitle("Password Generator");
		frmPasswordGenerator.setBounds(200, 200, 550, 400);
		frmPasswordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordGenerator.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Generate Password");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setBounds(168, 201, 181, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		frmPasswordGenerator.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setToolTipText("Name file...\r\n");
		textField.setBounds(168, 152, 181, 26);
		frmPasswordGenerator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduzca el nombre del archivo en donde\r\n\r\n\r\n se guarda su contraseña");
		lblNewLabel.setBounds(93, 101, 339, 26);
		frmPasswordGenerator.getContentPane().add(lblNewLabel);
	}
}
