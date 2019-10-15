package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author harryalvarado28
 *
 */
public class Parser {
	private Scanner scanner;
    private HashMap transicion;

    public Parser(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    public String getInput() {
        return scanner.nextLine();
    }

    public HashMap parse() {
        transicion = new HashMap();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            parseLine(line);
            System.out.println(line);
        }
        System.out.println("\n");
        return transicion;
    }

    public void parseLine(String linea) {
        linea = linea.replaceAll("\\s", "");
        int i = linea.indexOf("->");
        String keyState = linea.substring(0, i);
        keyState = keyState.replaceAll(",", "");
        linea = linea.substring(i + 2, linea.length());
        String[] array = linea.split(",");
        Accion action = new Accion(array[0], array[1], array[2]);
        transicion.put(keyState, action);
    }
}
