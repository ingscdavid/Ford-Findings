package mx.site.bb.comentarios.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mx.site.bb.comentarios.graficos.Comentarios;

public class EventoBorrarListener implements ActionListener {
	
	private Comentarios comentarios;
	
	public EventoBorrarListener(Comentarios comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JTextField jtf_nombre = comentarios.getJtf_nombre();
		Set<JCheckBox> opciones = comentarios.getOpciones();
		JTextArea jta_textoFinal = comentarios.getJta_textoFinal();
		JTextArea jta_textoIntroduccion = comentarios.getJta_textoIntroduccion();
		
		jtf_nombre.setText("");
		for(JCheckBox opcion : opciones){
			opcion.setSelected(false);
		}
		
		jta_textoIntroduccion.setText("");
		jta_textoFinal.setText("");
		
	}

}
