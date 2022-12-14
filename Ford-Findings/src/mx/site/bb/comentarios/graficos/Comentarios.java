package mx.site.bb.comentarios.graficos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Dimension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mx.site.archivos.Lector;
import mx.site.bb.comentarios.eventos.EventoBorrarListener;
import mx.site.bb.comentarios.eventos.EventoGenerarListener;
import mx.unitec.calculadora.utilerias.Utilerias;

public class Comentarios extends JFrame {

	private Lector lector;
	private int numLineas = 2;
	private Set<JCheckBox> opciones = new LinkedHashSet<>();
	private JTextArea jta_textoFinal;
	private Dimension size;
	private String fileName;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Comentarios() throws IOException {
		
		size = Toolkit.getDefaultToolkit().getScreenSize();
		
		int height = (int) size.getWidth() / 2;
				
		
		jta_textoFinal = new JTextArea();
		JScrollPane scrollPane2 = new JScrollPane(jta_textoFinal, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		
		JButton jb_Generar = new JButton("GENERATE FINDING");
		JButton jb_Borrar = new JButton("DELETE");
		
		JPanel jpPanel = new JPanel(new GridBagLayout());

		agregaOpciones(jpPanel);

		Utilerias.asignarPosicion(0, ++numLineas, scrollPane2, jpPanel, 2, GridBagConstraints.HORIZONTAL);
		jta_textoFinal.setRows(30);
		jta_textoFinal.setRows(5);
		numLineas++;
		
		Utilerias.asignarPosicion(0, numLineas, jb_Generar, jpPanel);
		jb_Generar.addActionListener(new EventoGenerarListener(this));
		
		
		Utilerias.asignarPosicion(1, numLineas, jb_Borrar, jpPanel);
		jb_Borrar.addActionListener(new EventoBorrarListener(this));
		
		
		this.fileName = this.fileName.replace("\\","|");
		
		System.out.println(this.fileName);
		
		for(String name : this.fileName.split("\\|")) {
			System.out.println(name);
			this.fileName = name;
		}
		
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(jpPanel);
		setSize(350, height);
		setTitle(this.fileName);
		pack();

		
		

	}

	private void agregaOpciones(JPanel jpPanel) throws IOException {

		lector = new Lector();
		BufferedReader br = lector.leerArchivo();
		this.fileName = lector.getFileName();
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
		if(numLineas %2 !=0) {
			numLineas++;
		}

	}

	public Set<JCheckBox> getOpciones() {
		return opciones;
	}

	public void setOpciones(Set<JCheckBox> opciones) {
		this.opciones = opciones;
	}


	public JTextArea getJta_textoFinal() {
		return jta_textoFinal;
	}

	public void setJta_textoFinal(JTextArea jta_textoFinal) {
		this.jta_textoFinal = jta_textoFinal;
	}

}
