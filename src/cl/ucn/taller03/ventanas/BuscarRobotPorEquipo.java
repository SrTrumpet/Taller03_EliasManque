package cl.ucn.taller03.ventanas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;

@SuppressWarnings("serial")
public class BuscarRobotPorEquipo extends JFrame implements ActionListener {

	private Sistema sist;
	
	private JPanel contentPane;
	private JTextField textBuscadorPiloto;
	private JButton btnBuscar;
	private JLabel lblTituloBuscar;
	private JButton btnAtras;
	
	//JScroll
	private JScrollPane scrollPane;
	
	
	private JTextPane textPane;
	/**
	 * Create the frame.
	 */
	public BuscarRobotPorEquipo(Sistema sist) {
		
		this.sist = sist;
		
		setTitle("Buscar Robot");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iniciarLabels();
		iniciarBotones();
		iniciarScroll();
		iniciarTextos();
		
		
		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie
		
	}
	
	
	
	private void iniciarLabels() {
		
		lblTituloBuscar = new JLabel("Ingresa el nombre del Equipo");
		lblTituloBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloBuscar.setIcon(new ImageIcon("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		lblTituloBuscar.setBounds(72, 27, 346, 65);
		contentPane.add(lblTituloBuscar);
	}
	
	private void iniciarBotones() {
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\inconBuscar.png"));
		btnBuscar.setBounds(329, 102, 63, 36);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(301, 302, 117, 30);
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);
	}
	
	private void iniciarTextos() {
		
		textBuscadorPiloto = new JTextField();
		textBuscadorPiloto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textBuscadorPiloto.setBounds(47, 102, 272, 36);
		contentPane.add(textBuscadorPiloto);
		textBuscadorPiloto.setColumns(10);
		
		
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(textPane);
	}

	private void iniciarScroll() {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 148, 345, 144);
		contentPane.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(btnAtras == e.getSource()) {
			dispose();
			
		}
		if(btnBuscar == e.getSource()) {

			String datos = sist.buscarListaRobotPorEquipo(textBuscadorPiloto.getText());
			
			textPane.setText(datos);
			
			
		}
		
		
	}

}
