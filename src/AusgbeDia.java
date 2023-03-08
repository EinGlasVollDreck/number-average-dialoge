import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AusgbeDia extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField arithmetisch;
	private JTextField geometrisch;
	private JTextField harmonisch;
	private double[] numbers;

	public AusgbeDia(double[] nr) {
		numbers = nr;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{201, 224, 0};
		gbl_contentPane.rowHeights = new int[]{56, 52, 59, 85, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("arithemtisch");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		arithmetisch = new JTextField();
		arithmetisch.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(arithmetisch, gbc_textField);
		arithmetisch.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("geometrisch");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		geometrisch = new JTextField();
		geometrisch.setEnabled(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		contentPane.add(geometrisch, gbc_textField_1);
		geometrisch.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("harmonisch");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		harmonisch = new JTextField();
		harmonisch.setEnabled(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		contentPane.add(harmonisch, gbc_textField_2);
		harmonisch.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton.addActionListener(this);
		
		try {
			arithmetisch.setText(Double.toString(Statistik.berechneMittelwert(numbers, Statistik.MittelwertTyp.ARITHMETISCH)));
		} catch (MittelwertException ex) {
			arithmetisch.setText(ex.getMessage());
		}

		try {
			geometrisch.setText(Double.toString(Statistik.berechneMittelwert(numbers, Statistik.MittelwertTyp.GEOMETRISCH)));
		} catch (MittelwertException ex) {
			geometrisch.setText(ex.getMessage());
		}

		try {
			harmonisch.setText(Double.toString(Statistik.berechneMittelwert(numbers, Statistik.MittelwertTyp.HARMONISCH)));
		} catch (MittelwertException ex) {
			harmonisch.setText(ex.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String befehl = e.getActionCommand();
		if(befehl.equals("Ok"))
		{
			this.setVisible(false);
		}
		
	}

}
