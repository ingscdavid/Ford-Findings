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
import mx.site.checks.Spelling;

public class EventoGenerarListener implements ActionListener {

	private Comentarios comentarios;

	public EventoGenerarListener(Comentarios comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String[] frases1 = { "Buena reflexión cuando escribes que -\"", "Estoy de acuerdo contigo cuando mencionas que -\"",
				"Es una buena observación la que haces: -\"", "Haces un análisis valioso al escribir que -\"",
				"Este es un comentario inteligente -\"", "Totalmete cierto -\"", "¡Es verdad! -\"",
				"Coincido con la idea de que -\"", "En definitiva, una idea fundamental para este tema: -\"",
				"Es correcto cuando planteas que -\"", "Buen trabajo al expresar que -\"", "Sí yo también conincido en que -\""  };
		
		String[] saludos1 = { "Estimad@", "Apreciable","Hola", "¿Qué tal?", "Buen día,"};
		
		
		
		StringBuffer sbComentarioFinal = new StringBuffer(saludos1[(int) (Math.random() * saludos1.length)]);
		
		String nombre = comentarios.getJtf_nombre().getText();
		
		nombre = Spelling.checkNames(nombre);
		
		if(nombre.contains(" y ")) {
			sbComentarioFinal = new StringBuffer("Apreciables");
		}		
		
		sbComentarioFinal.append(" ");
		sbComentarioFinal.append(nombre.trim() + ",\n\n");

		// Si la caja de comentarios iniciales no está vacía, agregar la frase
		// copiada a la caja desde el trabajo del alumno
		if (!comentarios.getJta_textoIntroduccion().getText().equals("")) {
			StringBuffer fraseGanadora = new StringBuffer(frases1[(int) (Math.random() * frases1.length)]);
			fraseGanadora.append(comentarios.getJta_textoIntroduccion().getText().replace('\n', ' '));
			fraseGanadora.append("\"\n");
			sbComentarioFinal.append(fraseGanadora.toString());
		}

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
