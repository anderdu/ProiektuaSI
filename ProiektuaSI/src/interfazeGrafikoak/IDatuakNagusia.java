package interfazeGrafikoak;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datuak.DatuenKarga;
import datuak.KargaCSV;
import datuak.Pertsona;
import eragiketak.GureSistema;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class IDatuakNagusia extends JFrame {

	private JPanel contentPane;
	private GureSistema nGureSistema;
	private DatuenKarga kargaInterfaze;
	
	private ImageIcon argazkia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDatuakNagusia frame = new IDatuakNagusia();
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
	public IDatuakNagusia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		nGureSistema = GureSistema.getGureSistema();
		kargaInterfaze = new KargaCSV();
		
		// JPanel batean
//		Dimension tamaina = getSize();
//		argazkia = new ImageIcon(getClass().getResource("tv-the-flash05.jpg"));
//		Graphics g = null;
//		g.drawImage(argazkia.getImage(), 0, 0, tamaina.width, tamaina.height, null);
//		setOpaque(false);
//		super.paint(g);
		
		JButton btnBalorazioak = new JButton("Balorazioak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBalorazioak, 80, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBalorazioak, 29, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBalorazioak, -126, SpringLayout.SOUTH, contentPane);
		btnBalorazioak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<Integer, ArrayList<Float>> produkBal = nGureSistema.produktuenBalorazioak();
				new IDatuakBalorazioak(produkBal);
				
				dispose();
			}
		});
		contentPane.add(btnBalorazioak);
		
		JLabel label = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 92, SpringLayout.WEST, contentPane);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 125, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 92, SpringLayout.WEST, contentPane);
		contentPane.add(label_1);
		
		JButton btnIzenburuak = new JButton("Izenburuak");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBalorazioak, -38, SpringLayout.WEST, btnIzenburuak);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnIzenburuak, 228, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnIzenburuak, -56, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnIzenburuak, 80, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnIzenburuak, 0, SpringLayout.SOUTH, label);
		btnIzenburuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HashMap<Integer, String> produkIzenburuak = nGureSistema.produktuenIzenburuak();
				new IDatuakIzenburuak(produkIzenburuak);

				HashMap<Integer, String> produkIz = nGureSistema.produktuenIzenburuak();
				new IDatuaIzenburuak(produkIz);
				
				dispose();

			}
		});
		contentPane.add(btnIzenburuak);
		
		JButton btnPelikulaEstimatu = new JButton("Pelikula estimatu!");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPelikulaEstimatu, 35, SpringLayout.SOUTH, btnBalorazioak);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPelikulaEstimatu, 153, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPelikulaEstimatu, 64, SpringLayout.SOUTH, btnBalorazioak);
		btnPelikulaEstimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Float>> produkBal = nGureSistema.produktuenBalorazioak();
				ArrayList<Pertsona> pertsonak = nGureSistema.pertsonakAtera();
				nGureSistema.antzekotasunGuztiakKalkulatu();
				dispose();
				new IEstimatu(nGureSistema);
			}
		});
		contentPane.add(btnPelikulaEstimatu);
	}
}
