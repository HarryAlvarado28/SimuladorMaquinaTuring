/**
 * 
 */
package Logica;

/**
 * @author harryalvarado28
 *
 */
public class Accion {
	 
    public String siguiente_estado;
    public String nuevo_simbolo;
    public String movimiento;

    public Accion(String siguiente_estado, String nuevo_simbolo, String movimiento) {
        this.siguiente_estado = siguiente_estado;
        this.nuevo_simbolo = nuevo_simbolo;
        this.movimiento = movimiento;
    }
}
