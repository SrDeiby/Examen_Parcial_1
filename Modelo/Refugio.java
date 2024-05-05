package Modelo;

public class Refugio {

    private String Nombre, Lugar, Capacidad;

    public Refugio(){}//Fin constructor vacío

    public Refugio(String Nombre, String Lugar, String Capacidad){
        this.Nombre = Nombre;
        this.Lugar = Lugar;
        this.Capacidad = Capacidad;
    }//Fin del constructor

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String capacidad) {
        Capacidad = capacidad;
    }

}//Fin de la clase
