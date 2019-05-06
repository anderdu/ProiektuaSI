package interfazeGrafikoak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datuak.Pertsona;
import eragiketak.GureSistema;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class IZerrendatu extends JFrame {

	private JPanel contentPane;
	private GureSistema g;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int erab = 0;
					IZerrendatu frame = new IZerrendatu(erab);
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
	public IZerrendatu(int erab) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblP = new JLabel("p1");
		lblP.setBackground(Color.WHITE);
		lblP.setOpaque(true);
		lblP.setForeground(Color.BLACK);
		lblP.setBounds(126, 15, 437, 14);
		contentPane.add(lblP);
		
		JLabel lblP_1 = new JLabel("p2");
		lblP_1.setBackground(Color.WHITE);
		lblP_1.setOpaque(true);
		lblP_1.setForeground(Color.BLACK);
		lblP_1.setBounds(126, 55, 437, 14);
		contentPane.add(lblP_1);
		
		JLabel lblP_2 = new JLabel("p3");
		lblP_2.setBackground(Color.WHITE);
		lblP_2.setOpaque(true);
		lblP_2.setForeground(Color.BLACK);
		lblP_2.setBounds(125, 88, 438, 14);
		contentPane.add(lblP_2);
		
		JLabel lblP_3 = new JLabel("p4");
		lblP_3.setBackground(Color.WHITE);
		lblP_3.setOpaque(true);
		lblP_3.setForeground(Color.BLACK);
		lblP_3.setBounds(126, 135, 437, 14);
		contentPane.add(lblP_3);
		
		JLabel lblP_4 = new JLabel("p5");
		lblP_4.setBackground(Color.WHITE);
		lblP_4.setOpaque(true);
		lblP_4.setForeground(Color.BLACK);
		lblP_4.setBounds(126, 186, 437, 14);
		contentPane.add(lblP_4);
		
		JLabel lblP_5 = new JLabel("p6");
		lblP_5.setBackground(Color.WHITE);
		lblP_5.setOpaque(true);
		lblP_5.setForeground(Color.BLACK);
		lblP_5.setBounds(126, 231, 437, 14);
		contentPane.add(lblP_5);
		
		JLabel lblP_6 = new JLabel("p7");
		lblP_6.setBackground(Color.WHITE);
		lblP_6.setOpaque(true);
		lblP_6.setForeground(Color.BLACK);
		lblP_6.setBounds(126, 274, 437, 14);
		contentPane.add(lblP_6);
		
		JLabel lblP_7 = new JLabel("p8");
		lblP_7.setBackground(Color.WHITE);
		lblP_7.setOpaque(true);
		lblP_7.setForeground(Color.BLACK);
		lblP_7.setBounds(126, 318, 437, 14);
		contentPane.add(lblP_7);
		
		JLabel lblP_8 = new JLabel("p9");
		lblP_8.setBackground(Color.WHITE);
		lblP_8.setOpaque(true);
		lblP_8.setForeground(Color.BLACK);
		lblP_8.setBounds(126, 364, 437, 14);
		contentPane.add(lblP_8);
		
		JLabel lblP_9 = new JLabel("p10");
		lblP_9.setBackground(Color.WHITE);
		lblP_9.setOpaque(true);
		lblP_9.setForeground(Color.BLACK);
		lblP_9.setBounds(126, 407, 437, 14);
		contentPane.add(lblP_9);
		
		ArrayList<JLabel> labelak = new ArrayList<JLabel>();
		
		labelak.add(lblP);
		labelak.add(lblP_1);
		labelak.add(lblP_2);
		labelak.add(lblP_3);
		labelak.add(lblP_4);
		labelak.add(lblP_5);
		labelak.add(lblP_6);
		labelak.add(lblP_7);
		labelak.add(lblP_8);
		labelak.add(lblP_9);
		
		g = GureSistema.getGureSistema();
		g.pertsonakAtera();
		g.produktuenBalorazioak();
		g.produktuenIzenburuak();
		g.antzekotasunGuztiakKalkulatu();
		ArrayList<Pertsona> pertsonak = g.getPertsonak();
		pertsonak.get(erab).estimatuBaloratuEzDituenak();
		ArrayList<String> izenburuak = pertsonak.get(erab).emanEstimazioAltuenak();
		
		JButton btnB = new JButton("Trailerra");
		btnB.setBounds(5, 15, 92, 23);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estekaIreki(izenburuak.get(0));
			}
		});
		contentPane.add(btnB);
		
		JButton btnB_1 = new JButton("Trailerra");
		btnB_1.setBounds(5, 51, 92, 23);
		btnB_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(1));
			}
		});
		contentPane.add(btnB_1);
		
		JButton btnB_2 = new JButton("Trailerra");
		btnB_2.setBounds(5, 88, 92, 23);
		btnB_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(2));
			}
		});
		contentPane.add(btnB_2);
		
		JButton btnNewButton = new JButton("Trailerra");
		btnNewButton.setBounds(5, 135, 92, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(3));
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnTrailerra = new JButton("Trailerra");
		btnTrailerra.setBounds(5, 186, 92, 23);
		btnTrailerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(4));
			}
		});
		contentPane.add(btnTrailerra);
		
		JButton btnTrailerra_1 = new JButton("Trailerra");
		btnTrailerra_1.setBounds(5, 226, 92, 23);
		btnTrailerra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(5));
			}
		});
		contentPane.add(btnTrailerra_1);
		
		JButton btnTrailerra_2 = new JButton("Trailerra");
		btnTrailerra_2.setBounds(5, 274, 92, 23);
		btnTrailerra_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(6));
			}
		});
		contentPane.add(btnTrailerra_2);
		
		JButton btnTrailerra_3 = new JButton("Trailerra");
		btnTrailerra_3.setBounds(5, 318, 92, 23);
		btnTrailerra_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(7));
			}
		});
		contentPane.add(btnTrailerra_3);
		
		JButton btnTrailerra_4 = new JButton("Trailerra");
		btnTrailerra_4.setBounds(5, 364, 92, 23);
		btnTrailerra_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(8));
			}
		});
		contentPane.add(btnTrailerra_4);
		
		JButton btnTrailerra_5 = new JButton("Trailerra");
		btnTrailerra_5.setBounds(5, 407, 92, 23);
		btnTrailerra_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(9));
			}
		});
		contentPane.add(btnTrailerra_5);
		
		JButton btnItxi = new JButton("Itxi");
		btnItxi.setBounds(705, 424, 64, 23);
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnItxi);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(622, 424, 73, 23);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IHamarPelikula frame = new IHamarPelikula();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnAtzera);
		
		JLabel lblAlgo = new JLabel("");
		lblAlgo.setIcon(new ImageIcon("atzealdeak/filmstrip-91434_960_720.jpg"));
		lblAlgo.setBounds(0, 0, 784, 462);
		contentPane.add(lblAlgo);
		
		
		
		for (int i = 0; i < izenburuak.size(); i++) {
			String izena = izenburuak.get(i);
			JLabel labela = labelak.get(i);
			labela.setText(izena);
		}
		setVisible(true);
	}
	
	public void estekaIreki(String pLink){
		System.out.println(pLink);
		Character c = '"';
		String link = pLink.replace(" ", "+").replace(":", "%3A").replace("(", "%28").replace(")","%29").replace("'", "%27").replace(Character.toString(c),"");
		String url = "https://www.youtube.com/results?search_query=" + link + "+trailer";
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException e){
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
