package mx.site.bb.comentarios.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;


import mx.site.bb.comentarios.graficos.Comentarios;

public class EventoBorrarListener implements ActionListener {
	
	private Comentarios comentarios;
	
	public EventoBorrarListener(Comentarios comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		Set<JCheckBox> opciones = comentarios.getOpciones();
		JTextArea jta_textoFinal = comentarios.getJta_textoFinal();

		

		for(JCheckBox opcion : opciones){
			opcion.setSelected(false);
		}
		

		jta_textoFinal.setText("");
		
	}

}
