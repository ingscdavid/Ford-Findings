package mx.site.bb.comentarios.graficos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mx.site.archivos.Lector;
import mx.site.bb.comentarios.eventos.EventoBorrarListener;
import mx.site.bb.comentarios.eventos.EventoGenerarListener;
import mx.unitec.calculadora.utilerias.Utilerias;

public class Comentarios extends JFrame {

	private Lector lector;
	private int numLineas = 2;
	private Set<JCheckBox> opciones = new LinkedHashSet<>();
	private JTextField jtf_nombre;
	private JTextArea jta_textoIntroduccion;
	private JTextArea jta_textoFinal;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Comentarios() throws IOException {
		
		int alto = 1000;
		
		jtf_nombre = new JTextField();
		jta_textoIntroduccion = new JTextArea();
		JScrollPane scrollPane1 = new JScrollPane(jta_textoIntroduccion, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		jta_textoIntroduccion.setRows(30);
		jta_textoIntroduccion.setRows(5);
		jta_textoFinal = new JTextArea();
		JScrollPane scrollPane2 = new JScrollPane(jta_textoFinal, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		JButton jb_Generar = new JButton("GENERAR COMMENT");
		JButton jb_Borrar = new JButton("BORRAR");
		
		JPanel jpPanel = new JPanel(new GridBagLayout());

		Utilerias.asignarPosicion(0, 0, new JLabel("Nombre: "), jpPanel);
		Utilerias.asignarPosicion(1, 0, jtf_nombre, jpPanel);
		jtf_nombre.setColumns(15);

		Utilerias.asignarPosicion(0, 1, scrollPane1, jpPanel, 2, GridBagConstraints.HORIZONTAL);

		agregaOpciones(jpPanel);

		Utilerias.asignarPosicion(0, numLineas, scrollPane2, jpPanel, 2, GridBagConstraints.HORIZONTAL);
		jta_textoFinal.setRows(30);
		jta_textoFinal.setRows(5);
		numLineas++;
		
		Utilerias.asignarPosicion(0, numLineas, jb_Generar, jpPanel);
		jb_Generar.addActionListener(new EventoGenerarListener(this));
		
		
		Utilerias.asignarPosicion(1, numLineas, jb_Borrar, jpPanel);
		jb_Borrar.addActionListener(new EventoBorrarListener(this));
		
		int calculo = numLineas*40;
		
		if (calculo > 1000){
			alto = calculo;
		}
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(jpPanel);
		setSize(350, alto);
		setTitle("COMENTARIOS");
		pack();
		jtf_nombre.requestFocusInWindow();
		
		

	}

	private void agregaOpciones(JPanel jpPanel) throws IOException {

		lector = new Lector();
		BufferedReader br = lector.leerArchivo();
		JCheckBox jcb;
		String linea;
		int i = 0;
		
		while ((linea = br.readLine()) != null) {
			if (!linea.equals("")) {
				
				
				String[] comentarios = linea.split("::");
				jcb = new JCheckBox();
				jcb.setText(comentarios[0]);
				jcb.setToolTipText(comentarios[1]);
				
				Utilerias.asignarPosicion(i, numLineas, jcb, jpPanel,1,GridBagConstraints.HORIZONTAL);
				i++;
				opciones.add(jcb);
				if (i > 1) {
					i = 0;
					numLineas++;
				}
				
			}
			
		}
		if(numLineas%2!=0) {
			numLineas++;
		}

	}

	public Set<JCheckBox> getOpciones() {
		return opciones;
	}

	public void setOpciones(Set<JCheckBox> opciones) {
		this.opciones = opciones;
	}

	public JTextField getJtf_nombre() {
		return jtf_nombre;
	}

	public void setJtf_nombre(JTextField jtf_nombre) {
		this.jtf_nombre = jtf_nombre;
	}

	public JTextArea getJta_textoIntroduccion() {
		return jta_textoIntroduccion;
	}

	public void setJta_textoIntroduccion(JTextArea jta_textoIntroduccion) {
		this.jta_textoIntroduccion = jta_textoIntroduccion;
	}

	public JTextArea getJta_textoFinal() {
		return jta_textoFinal;
	}

	public void setJta_textoFinal(JTextArea jta_textoFinal) {
		this.jta_textoFinal = jta_textoFinal;
	}

}
