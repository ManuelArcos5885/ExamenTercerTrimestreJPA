package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


import controller.ControllerAsigPorDocente;
import controller.ControllerAsignatura;
import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMateria extends JPanel {
	private static JList<Asignatura> jlistaAsigSelec;
	private static JList<Asignatura> jlistaAsigNoSelec;
	private static DefaultListModel<Asignatura> modeloListaAsigSelec;
	private static DefaultListModel<Asignatura> modeloListaAsigNoSelec;
	/**
	 * Create the panel.
	 */
	public PanelMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{227, 65, 0, 158, 0};
		gridBagLayout.rowHeights = new int[]{15, 280, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Asignatura no seleccionada");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Asignatura seleccionada");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		
		
		jlistaAsigNoSelec = new JList(getDefaultListModelNoSelec());
		jlistaAsigNoSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		
		
		
		JScrollPane scrollPane = new JScrollPane(jlistaAsigNoSelec);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{54, 0, 44, 0};
		gbl_panel.rowHeights = new int[]{25, 25, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirTodosSelec();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);
		
		JButton button_2 = new JButton(">");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Asignatura> a = jlistaAsigNoSelec.getSelectedValuesList();
				modeloListaAsigSelec.addAll(a);
				
				for (int i = jlistaAsigNoSelec.getSelectedIndices().length -1; i >= 0; i--) {
					modeloListaAsigNoSelec.removeElementAt(jlistaAsigNoSelec.getSelectedIndices()[i]);
					
				}
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.anchor = GridBagConstraints.NORTH;
		gbc_button_2.gridwidth = 4;
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 1;
		panel.add(button_2, gbc_button_2);
		
		JButton button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Asignatura> a = jlistaAsigSelec.getSelectedValuesList();
				modeloListaAsigNoSelec.addAll(a);
				
				for (int i = jlistaAsigSelec.getSelectedIndices().length -1; i >= 0; i--) {
					modeloListaAsigSelec.removeElementAt(jlistaAsigSelec.getSelectedIndices()[i]);
					
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 2;
		panel.add(button_1, gbc_button_1);
		
		JButton button_3 = new JButton("<<");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirTodosNoSelec();
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 3;
		panel.add(button_3, gbc_button_3);
		
		
		
		jlistaAsigSelec = new JList(getDefaultListModelSelec());
		jlistaAsigSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		
		
		JScrollPane scrollPane_1 = new JScrollPane(jlistaAsigSelec);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.weightx = 1.0;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		add(scrollPane_1, gbc_scrollPane_1);

	}
	/**
	 * 
	 * 
	 */
	private DefaultListModel getDefaultListModelSelec () {
		modeloListaAsigSelec = new DefaultListModel<Asignatura>();
		return this.modeloListaAsigSelec;
	}
	
	
	private DefaultListModel getDefaultListModelNoSelec () {
		modeloListaAsigNoSelec = new DefaultListModel<Asignatura>();
		return this.modeloListaAsigNoSelec;
	}
	/**
	 * 
	 * 
	 */
	
	
	public static void cargarAignaturasImpartidas(Docente d) {
		modeloListaAsigNoSelec.removeAllElements();
		modeloListaAsigSelec.removeAllElements();
		List<Asignaturaspordocente> as = ControllerAsigPorDocente.findLikeidDocente(d);
		
		for (Asignaturaspordocente a : as) {
			modeloListaAsigSelec.addElement(a.getAsignatura());
		}
		
		
		
		
		List<Asignatura> asigs = ControllerAsignatura.findAll();
		boolean esNuevaAsignatura = true;
		for (Asignatura a : asigs) {
			
			for (Asignaturaspordocente asigdoc : as) {
				if (asigdoc.getAsignatura().getId() == a.getId()) {
					esNuevaAsignatura = false;
				}
				
			}
			
			if (esNuevaAsignatura) {
				modeloListaAsigNoSelec.addElement(a);
			}
			esNuevaAsignatura = true;
		}
		
	}

	/**
	 * 
	 * 
	 * 
	 */
	
	private void imprimirTodosNoSelec() {
		List<Asignatura> as = ControllerAsignatura.findAll();
		
		for (Asignatura a : as) {
			modeloListaAsigNoSelec.addElement(a);
		}
		
		modeloListaAsigSelec.removeAllElements();
	}
	/**
	 * 
	 * 
	 * 
	 */
	
	private void imprimirTodosSelec() {
		List<Asignatura> as = ControllerAsignatura.findAll();
		
		for (Asignatura a : as) {
			modeloListaAsigSelec.addElement(a);
		}
		
		modeloListaAsigNoSelec.removeAllElements();
	}
	/**
	 * 
	 * 
	 */
	
	public static void guardarAsig(Docente d) {
		List<Asignaturaspordocente> as = ControllerAsigPorDocente.findLikeidDocente(d);	
		for (int i = 0; i < as.size(); i++) {
			ControllerAsigPorDocente.remove(as.get(i));
		}
		
		for (int i = 0; i < modeloListaAsigSelec.size(); i++) {
			Asignatura a = modeloListaAsigSelec.get(i);
			Asignaturaspordocente ap = new Asignaturaspordocente(0,a,d);
			ControllerAsigPorDocente.persist(ap);
		}
		
		
		

		
	}
	

}
