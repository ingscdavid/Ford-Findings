package mx.site.bb.comentarios.eventos;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import mx.site.bb.comentarios.graficos.Comentarios;


public class EventoGenerarListener implements ActionListener {

	private Comentarios comentarios;

	public EventoGenerarListener(Comentarios comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		
		
		
		StringBuffer sbComentarioFinal = new StringBuffer();
		
		
		sbComentarioFinal.append(" ");
		

		// Si la caja de comentarios iniciales no está vacía, agregar la frase
		// copiada a la caja desde el trabajo del alumno

		Set<JCheckBox> opciones = comentarios.getOpciones();

		for (Iterator<JCheckBox> it = opciones.iterator(); it.hasNext();) {

			JCheckBox jcb = (JCheckBox) it.next();

			if (jcb.isSelected()) {
				sbComentarioFinal.append(jcb.getToolTipText() + "\n");
			}
		}

		sbComentarioFinal.append("\nSaludos,");

		JTextArea jta_textoFinal = comentarios.getJta_textoFinal();
		jta_textoFinal.setText(sbComentarioFinal.toString());

		StringSelection stringSelection = new StringSelection(jta_textoFinal.getText());
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);

	}

}
