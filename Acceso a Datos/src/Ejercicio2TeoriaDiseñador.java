import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Ejercicio2TeoriaDiseñador {

	private JFrame frame;
	private JTextField rutaOrigen;
	private JTextField rutaDestino;
	private JComboBox devuelveCodificacion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2TeoriaDiseñador window = new Ejercicio2TeoriaDiseñador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio2TeoriaDiseñador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		frame.setBounds(100, 100, 635, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton Copiar = new JButton("Copiar");
		Copiar.setBounds(251, 224, 114, 29);
		Copiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ejercicio2Teoria.main(rutaOrigen.getText(), rutaDestino.getText(),devuelveCodificacion );
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(Copiar);
		
		JLabel lblNewLabel = new JLabel("Origen");
		lblNewLabel.setBounds(64, 92, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(67, 120, 67, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		rutaOrigen = new JTextField();
		rutaOrigen.setBounds(166, 89, 414, 20);
		frame.getContentPane().add(rutaOrigen);
		rutaOrigen.setColumns(10);
		
		rutaDestino = new JTextField();
		rutaDestino.setBounds(164, 121, 416, 20);
		frame.getContentPane().add(rutaDestino);
		rutaDestino.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Grabadora de archivos, cuando existe un primer ARCHIVO");
		lblNewLabel_2.setBounds(155, 41, 300, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cod. destino");
		lblNewLabel_3.setBounds(64, 176, 70, 14);
		frame.getContentPane().add(lblNewLabel_3);
			
		
		devuelveCodificacion  = new JComboBox();
		devuelveCodificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		devuelveCodificacion.setModel(new DefaultComboBoxModel(new String[] {"UTF-8", "ASCII", "ANSI"}));
		devuelveCodificacion.setBounds(166, 172, 90, 22);
		frame.getContentPane().add(devuelveCodificacion);
	}
}
