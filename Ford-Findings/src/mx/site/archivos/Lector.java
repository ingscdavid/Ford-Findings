package mx.site.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lector {
	
	private JFileChooser chooser;
	private String FILENAME;
	private BufferedReader br;
	
	public BufferedReader leerArchivo(){
		
		
		chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
	    chooser.setFileFilter(filter);
	    
	    int returnValue = chooser.showOpenDialog(null);
	    
	    if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			FILENAME = selectedFile.getAbsolutePath();
			
		}

		
		try  {
			
			br = new BufferedReader(new FileReader(FILENAME));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return br;
	}
	

}
