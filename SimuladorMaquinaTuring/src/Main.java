/**
 * 
 */


import Logica.MaquinaTuring;
import Logica.Parser;
import java.io.File;
import java.util.HashMap;

import java.io.File;

/**
 * @author harryalvarado28
 *
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     boolean pasos = false;
	     	if (args.length == 2) {
	            if (args[1].equals("s")) {
	                pasos = true;
	            }
	        }
	       
	        Parser parser = new Parser( new File("/Users/harry/workspace/SimuladorMaquinaTuring/input2.txt")); // ruta del archivo
	        String entrada = parser.getInput();
	        HashMap transicion = parser.parse();

	        new MaquinaTuring(entrada, transicion, pasos).run();
	}
}
