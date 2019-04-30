package interfazeGrafikoak;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datuak.DatuenKarga;
import datuak.KargaCSV;
import datuak.Pertsona;
import eragiketak.ProdukturarekinEstimazioa;
import eragiketak.GureSistema;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IDatuakNagusia extends JFrame {

	private JPanel contentPane;
	private GureSistema nGureSistema;
	private DatuenKarga kargaInterfaze;
	private ProdukturarekinEstimazioa estimazioa;
	
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
		estimazioa = ProdukturarekinEstimazioa.getEstimazioaKalkulatu();
		kargaInterfaze = new KargaCSV();
		
		getContentPane().setBackground(Color.CYAN);
		
		// JPanel batean
//		Dimension tamaina = getSize();
//		argazkia = new ImageIcon(getClass().getResource("tv-the-flash05.jpg"));
//		Graphics g = null;
//		g.drawImage(argazkia.getImage(), 0, 0, tamaina.width, tamaina.height, null);
//		setOpaque(false);
//		super.paint(g);
		
		JButton btnBalorazioak = new JButton("Balorazioak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBalorazioak, 149, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBalorazioak, 0, SpringLayout.WEST, contentPane);
		btnBalorazioak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<Integer, ArrayList<Float>> produkBal = nGureSistema.produktuenBalorazioak();
				new IDatuakBalorazioak(produkBal);
				
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 118, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 147, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -1, SpringLayout.NORTH, btnBalorazioak);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -89, SpringLayout.EAST, contentPane);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\-\\git\\ProiektuaSI\\WhatsApp Image 2019-04-11 at 10.57.23.jpeg"));
		lblNewLabel.setBounds(90, 90, 430, 280);
		contentPane.add(lblNewLabel);
		contentPane.add(btnBalorazioak);
		
		JButton btnIzenburuak = new JButton("Izenburuak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnIzenburuak, 149, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBalorazioak, -91, SpringLayout.WEST, btnIzenburuak);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnIzenburuak, -41, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnIzenburuak, 242, SpringLayout.WEST, contentPane);
		btnIzenburuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HashMap<Integer, String> produkIzenburuak = nGureSistema.produktuenIzenburuak();
				new IDatuakIzenburuak(produkIzenburuak);

//				HashMap<Integer, String> produkIz = nGureSistema.produktuenIzenburuak();
//				new IDatuaIzenburuak(produkIz);
				
				dispose();

			}
		});
		contentPane.add(btnIzenburuak);
		
		JButton btnPelikulaEstimatu = new JButton("Pelikula estimatu!");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnIzenburuak, -6, SpringLayout.NORTH, btnPelikulaEstimatu);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBalorazioak, -6, SpringLayout.NORTH, btnPelikulaEstimatu);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPelikulaEstimatu, 200, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPelikulaEstimatu, -22, SpringLayout.SOUTH, contentPane);
		btnPelikulaEstimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Float>> produkBal = nGureSistema.produktuenBalorazioak();
				ArrayList<Pertsona> pertsonak = nGureSistema.pertsonakAtera();
				nGureSistema.antzekotasunGuztiakKalkulatu();
				dispose();
				new IEstimatu(estimazioa);
			}
		});
		contentPane.add(btnPelikulaEstimatu);
		
		JButton btnAtera = new JButton("Itxi");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPelikulaEstimatu, -81, SpringLayout.WEST, btnAtera);
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAtera, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAtera, -22, SpringLayout.EAST, contentPane);
		contentPane.add(btnAtera);
		
		JButton btnNewButton = new JButton("10 pelikula zuretzat!");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -39, SpringLayout.NORTH, lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new IHamarPelikula();
			}
		});
		contentPane.add(btnNewButton);
	}
}
