package cl.ucn.taller03.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cl.ucn.taller03.logica.Sistema;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BuscarRobotPorPiloto extends JFrame implements ActionListener{

	private Sistema sist;
	
	private JPanel contentPane;
	private JTextField textBuscadorPiloto;
	private JButton btnBuscar;
	private JLabel lblTituloBuscar;
	private JButton btnAtras;


	/**
	 * Create the frame.
	 */
	public BuscarRobotPorPiloto(Sistema sist) {
		
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
		iniciarTextos();
		
		setLocationRelativeTo(null);// Deja centrada la ventana
		setResizable(false);// No deja que se reescale la ventana para que la intefaz no cambie
		
	}
	
	
	
	private void iniciarLabels() {
		
		lblTituloBuscar = new JLabel("Ingresa el nombre del Piloto");
		lblTituloBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloBuscar.setIcon(new ImageIcon("D:\\Program\\eclipse\\Taller03_EliasManque\\src\\cl\\ucn\\taller03\\img\\iconBarra.jpg"));
		lblTituloBuscar.setBounds(84, 27, 272, 65);
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
		textBuscadorPiloto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBuscadorPiloto.setBounds(47, 102, 272, 36);
		contentPane.add(textBuscadorPiloto);
		textBuscadorPiloto.setColumns(10);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(btnAtras == e.getSource()) {
			dispose();
			
		}
		if(btnBuscar == e.getSource()) {

		}
		
		
	}
}
