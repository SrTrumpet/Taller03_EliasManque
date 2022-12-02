package cl.ucn.taller03.ventanas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Victorias extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextPane textPane;
	@SuppressWarnings("unused")
	private Sistema sist;
	private JLabel lblNewLabel;
	private JButton btnAtras;

	/**
	 * Create the frame.
	 */
	public Victorias(Sistema sist) {
		
		this.sist = sist;
		setTitle("%Victorias");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 148, 345, 144);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(textPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconVentana.jpg"));
		lblNewLabel.setBounds(61, 10, 315, 142);
		contentPane.add(lblNewLabel);
		
		textPane.setText(sist.generarPorcentajeVictorias());
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(301, 302, 117, 30);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnAtras == e.getSource()) {
			dispose();
		}
		
	}
}
