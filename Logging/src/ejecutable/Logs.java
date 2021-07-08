package ejecutable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.acme.Demo;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logs window = new Logs();
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
	public Logs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Mensaje a Guardar");
		
		JCheckBox chkError = new JCheckBox("Error");
		
		JCheckBox chkWarning = new JCheckBox("Warnig");
		
		JCheckBox chkInfo = new JCheckBox("Info");
		JTextArea textArea = new JTextArea();
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Demo mensaje = new Demo(true,true,true,true,true);
						try {
							  String texto=textArea.getText();
							Demo.LogMessage(texto,chkInfo.isSelected(),chkWarning.isSelected(),chkError.isSelected());
						} catch (Exception e1) {
						
							e1.printStackTrace();
						}
					
				
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(chkError)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chkWarning)
							.addGap(18)
							.addComponent(chkInfo)))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chkError)
						.addComponent(chkWarning)
						.addComponent(chkInfo))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
