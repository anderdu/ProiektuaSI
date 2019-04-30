package interfazeGrafikoak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import eragiketak.GureSistema;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class IHamarPelikula extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHamarPelikula frame = new IHamarPelikula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IHamarPelikula() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 63, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 145, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblErabiltzailearenIdentifikatzailea = new JLabel("Erabiltzailearen identifikatzailea:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblErabiltzailearenIdentifikatzailea, 108, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblErabiltzailearenIdentifikatzailea, -19, SpringLayout.NORTH, textField);
		contentPane.add(lblErabiltzailearenIdentifikatzailea);
		
		JButton btnZerrendatu = new JButton("Zerrendatu");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnZerrendatu, 46, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnZerrendatu, 0, SpringLayout.WEST, textField);
		contentPane.add(btnZerrendatu);
		setVisible(true);
		
		btnZerrendatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String erabId = textField.getText();
				int erab = Integer.parseInt(erabId);
				dispose();
				new IZerrendatu(erab);
				
				
			}
		});
	}
}
