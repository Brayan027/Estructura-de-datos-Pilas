
package Modelos;

/**
 *
 * @Brayan Araujo Vega
 */
public class Nodo {
    private Nodo siguiente;
    private String Nombre;
    private String Apellido;
    private String edad;
    
    public Nodo(){
        siguiente=null;
        Nombre="";
        Apellido="";
        edad="";
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
    
    
}
