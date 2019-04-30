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
import java.awt.Desktop;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
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
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		
		JLabel lblP = new JLabel("p1");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP, -324, SpringLayout.EAST, contentPane);
		contentPane.add(lblP);
		
		JLabel lblP_1 = new JLabel("p2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP_1, 18, SpringLayout.SOUTH, lblP);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_1, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_1, -263, SpringLayout.EAST, contentPane);
		contentPane.add(lblP_1);
		
		JLabel lblP_2 = new JLabel("p3");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP_2, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_2, -408, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblP_1, -19, SpringLayout.NORTH, lblP_2);
		contentPane.add(lblP_2);
		
		JLabel lblP_3 = new JLabel("p4");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP_3, 33, SpringLayout.SOUTH, lblP_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_3, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_3, -354, SpringLayout.EAST, contentPane);
		contentPane.add(lblP_3);
		
		JLabel lblP_4 = new JLabel("p5");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_4, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_4, -337, SpringLayout.EAST, contentPane);
		contentPane.add(lblP_4);
		
		JLabel lblP_5 = new JLabel("p6");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblP_5, -208, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblP_4, -31, SpringLayout.NORTH, lblP_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_5, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_5, -363, SpringLayout.EAST, contentPane);
		contentPane.add(lblP_5);
		
		JLabel lblP_6 = new JLabel("p7");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_6, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_6, -344, SpringLayout.EAST, contentPane);
		contentPane.add(lblP_6);
		
		JLabel lblP_7 = new JLabel("p8");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_7, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_7, -337, SpringLayout.EAST, contentPane);
		contentPane.add(lblP_7);
		
		JLabel lblP_8 = new JLabel("p9");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_8, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_8, -337, SpringLayout.EAST, contentPane);
		contentPane.add(lblP_8);
		
		JLabel lblP_9 = new JLabel("p10");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_9, 0, SpringLayout.WEST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP_9, -235, SpringLayout.EAST, contentPane);
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
		pertsonak.get(erab).inprimatu();
		ArrayList<String> izenburuak = pertsonak.get(erab).emanEstimazioAltuenak();
		
		JButton btnB = new JButton("Trailerra");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estekaIreki(izenburuak.get(0));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP, 4, SpringLayout.NORTH, btnB);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP, 29, SpringLayout.EAST, btnB);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnB, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnB, 0, SpringLayout.WEST, contentPane);
		contentPane.add(btnB);
		
		JButton btnB_1 = new JButton("Trailerra");
		btnB_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(1));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnB_1, 13, SpringLayout.SOUTH, btnB);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnB_1, 0, SpringLayout.WEST, contentPane);
		contentPane.add(btnB_1);
		
		JButton btnB_2 = new JButton("Trailerra");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP_2, 28, SpringLayout.EAST, btnB_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnB_2, -4, SpringLayout.NORTH, lblP_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnB_2, 0, SpringLayout.EAST, btnB);
		btnB_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(2));
			}
		});
		contentPane.add(btnB_2);
		
		JButton btnNewButton = new JButton("Trailerra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(3));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -4, SpringLayout.NORTH, lblP_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnB);
		contentPane.add(btnNewButton);
		
		JButton btnTrailerra = new JButton("Trailerra");
		btnTrailerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(4));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTrailerra, -4, SpringLayout.NORTH, lblP_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTrailerra, 0, SpringLayout.EAST, btnB);
		contentPane.add(btnTrailerra);
		
		JButton btnTrailerra_1 = new JButton("Trailerra");
		btnTrailerra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(5));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTrailerra_1, 0, SpringLayout.WEST, btnB);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTrailerra_1, -208, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnTrailerra_1);
		
		JButton btnTrailerra_2 = new JButton("Trailerra");
		btnTrailerra_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(6));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTrailerra_2, 269, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP_6, 4, SpringLayout.NORTH, btnTrailerra_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTrailerra_2, 0, SpringLayout.WEST, btnB);
		contentPane.add(btnTrailerra_2);
		
		JButton btnTrailerra_3 = new JButton("Trailerra");
		btnTrailerra_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(7));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTrailerra_3, 21, SpringLayout.SOUTH, btnTrailerra_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP_7, 4, SpringLayout.NORTH, btnTrailerra_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTrailerra_3, 0, SpringLayout.WEST, btnB);
		contentPane.add(btnTrailerra_3);
		
		JButton btnTrailerra_4 = new JButton("Trailerra");
		btnTrailerra_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(8));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTrailerra_4, 23, SpringLayout.SOUTH, btnTrailerra_3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP_8, 4, SpringLayout.NORTH, btnTrailerra_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTrailerra_4, 0, SpringLayout.WEST, btnB);
		contentPane.add(btnTrailerra_4);
		
		JButton btnTrailerra_5 = new JButton("Trailerra");
		btnTrailerra_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estekaIreki(izenburuak.get(9));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTrailerra_5, 20, SpringLayout.SOUTH, btnTrailerra_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP_9, 4, SpringLayout.NORTH, btnTrailerra_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTrailerra_5, 0, SpringLayout.WEST, btnB);
		contentPane.add(btnTrailerra_5);
		
		
		
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
