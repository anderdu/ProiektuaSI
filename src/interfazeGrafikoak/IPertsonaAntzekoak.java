package interfazeGrafikoak;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class IPertsonaAntzekoak extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Integer[] a = {1,2,3};
					IPertsonaAntzekoak frame = new IPertsonaAntzekoak(a);
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
	public IPertsonaAntzekoak(Integer[] listaErab) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lblZureAntzekoGustuak = new JLabel("ZURE ANTZEKO GUSTUAK DITUZTEN PERTSONAK");
		lblZureAntzekoGustuak.setForeground(Color.WHITE);
		lblZureAntzekoGustuak.setBounds(43, 21, 325, 55);
		contentPane.add(lblZureAntzekoGustuak);
		
		JLabel label = new JLabel("1.");
		label.setBounds(62, 98, 46, 14);
		label.setForeground(Color.WHITE);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setBounds(62, 123, 46, 14);
		label_1.setForeground(Color.WHITE);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setBounds(62, 148, 46, 14);
		label_2.setForeground(Color.WHITE);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setBounds(62, 173, 46, 14);
		label_3.setForeground(Color.WHITE);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5.");
		label_4.setBounds(62, 198, 46, 14);
		label_4.setForeground(Color.WHITE);
		contentPane.add(label_4);
		
		JLabel lblEr = new JLabel("er1");
		lblEr.setBounds(102, 98, 206, 14);
		lblEr.setForeground(Color.WHITE);
		contentPane.add(lblEr);
		
		JLabel lblEr_1 = new JLabel("er2");
		lblEr_1.setBounds(102, 123, 206, 14);
		lblEr_1.setForeground(Color.WHITE);
		contentPane.add(lblEr_1);
		
		JLabel lblEr_2 = new JLabel("er3");
		lblEr_2.setBounds(102, 148, 206, 14);
		lblEr_2.setForeground(Color.WHITE);
		contentPane.add(lblEr_2);
		
		JLabel lblEr_3 = new JLabel("er4");
		lblEr_3.setBounds(102, 173, 206, 14);
		lblEr_3.setForeground(Color.WHITE);
		contentPane.add(lblEr_3);
		
		JLabel lblEr_4 = new JLabel("er5");
		lblEr_4.setBounds(102, 198, 206, 14);
		lblEr_4.setForeground(Color.WHITE);
		contentPane.add(lblEr_4);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IAntPertsonaIdSartu frame = new IAntPertsonaIdSartu();
				frame.setVisible(true);
			}
		});
		btnAtzera.setBounds(210, 228, 89, 23);
		contentPane.add(btnAtzera);
		
		JButton btnItxi = new JButton("Itxi");
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnItxi.setBounds(316, 228, 89, 23);
		contentPane.add(btnItxi);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(0, -7, 434, 283);
		label_5.setIcon(new ImageIcon("atzealdeak/curtain-2757815_960_720.png"));
		contentPane.add(label_5);
		
		if (listaErab != null) {
			lblEr.setText(listaErab[0].toString());
			lblEr_1.setText(listaErab[1].toString());
			lblEr_2.setText(listaErab[2].toString());
			lblEr_3.setText(listaErab[3].toString());
			lblEr_4.setText(listaErab[4].toString());
		}
	}

}
