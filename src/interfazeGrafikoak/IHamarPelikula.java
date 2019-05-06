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
import javax.swing.ImageIcon;
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
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(155, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblErabiltzailearenIdentifikatzailea = new JLabel("Erabiltzailearen identifikatzailea:");
		lblErabiltzailearenIdentifikatzailea.setBounds(108, 35, 187, 14);
		contentPane.add(lblErabiltzailearenIdentifikatzailea);
		
		JButton btnZerrendatu = new JButton("Zerrendatu");
		btnZerrendatu.setBounds(144, 134, 105, 23);
		contentPane.add(btnZerrendatu);
		
		JButton btnItxi = new JButton("Itxi");
		btnItxi.setBounds(361, 224, 58, 23);
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnItxi);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(266, 224, 75, 23);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IDatuakNagusia frame = new IDatuakNagusia();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnAtzera);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("atzealdeak/recorte.PNG"));
		label.setBounds(0, 0, 434, 262);
		contentPane.add(label);
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
