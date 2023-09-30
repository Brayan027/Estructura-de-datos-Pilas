package Modelos;

public class Pila {

    private Nodo cima;

    public Pila() {
        cima = null;
    }

    public boolean PilaVacia() {
        return cima == null;
    }

    public void insertar(String nombre, String apellido, String edad) {
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setApellido(apellido);

        nuevo.setSiguiente(cima);
        cima = nuevo;

    }

    public Nodo ObtenerCima() {
        if (PilaVacia()) {
            return null;
        }
        return cima;
    }
    
    
    public Nodo quitar(){
        if(PilaVacia()){
            return null;
        }
        Nodo aux=cima;
        cima=cima.getSiguiente();
        aux.setSiguiente(null);
        System.gc();
        return null;
    }
    
    
}
