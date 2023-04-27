package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerDocente;
import model.Docente;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Docente;
	private static JComboBox comboBox_Docentes;
	private JButton btnNewButton;
	private PanelMateria panelMateria;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDocentesYAsignaturas = new JLabel("Docentes y Asignaturas");
		lblDocentesYAsignaturas.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_lblDocentesYAsignaturas = new GridBagConstraints();
		gbc_lblDocentesYAsignaturas.insets = new Insets(0, 0, 5, 0);
		gbc_lblDocentesYAsignaturas.gridwidth = 7;
		gbc_lblDocentesYAsignaturas.gridx = 0;
		gbc_lblDocentesYAsignaturas.gridy = 0;
		contentPane.add(lblDocentesYAsignaturas, gbc_lblDocentesYAsignaturas);
		
		textField_Docente = new JTextField();
		GridBagConstraints gbc_textField_Docente = new GridBagConstraints();
		gbc_textField_Docente.gridwidth = 3;
		gbc_textField_Docente.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Docente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Docente.gridx = 0;
		gbc_textField_Docente.gridy = 1;
		contentPane.add(textField_Docente, gbc_textField_Docente);
		textField_Docente.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Docente> listaDocentes = ControllerDocente.findLikeNombre(textField_Docente.getText());
				imprimirDocentes(listaDocentes);
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 6;
		gbc_btnFiltrar.gridy = 1;
		contentPane.add(btnFiltrar, gbc_btnFiltrar);
		
		comboBox_Docentes = new JComboBox();
		GridBagConstraints gbc_comboBox_Docentes = new GridBagConstraints();
		gbc_comboBox_Docentes.gridwidth = 6;
		gbc_comboBox_Docentes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Docentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Docentes.gridx = 0;
		gbc_comboBox_Docentes.gridy = 2;
		contentPane.add(comboBox_Docentes, gbc_comboBox_Docentes);
		
		btnNewButton = new JButton("Cargar Materia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Docente d = (Docente) comboBox_Docentes.getSelectedItem();
				

				PanelMateria.cargarAignaturasImpartidas(d);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		panelMateria = new PanelMateria();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 7;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panelMateria, gbc_panel);
		
		btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Docente d = (Docente) comboBox_Docentes.getSelectedItem();
				PanelMateria.guardarAsig(d);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 7;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}
	
	/**
	 * 
	 * 
	 */
	
	public static void imprimirDocentes(List<Docente> docentes) {
		limpiarMunicipios();
		
		for (Docente d : docentes) {
			comboBox_Docentes.addItem(d);
		}
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static void limpiarMunicipios() {
		comboBox_Docentes.removeAllItems();
	}

}
