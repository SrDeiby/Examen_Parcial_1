package Modelo;

public abstract class Indigente extends Persona {
private String Tiempo, NumeroCama, Opcion;

public Indigente(String Nombre, String Edad, String Tiempo, String NumeroCama, String Opcion){
super(Nombre, Edad);
this.Tiempo = Tiempo;
this.NumeroCama = NumeroCama;
this.Opcion = Opcion;
}//Fin del constructor

public String getTiempo() {
    return Tiempo;
}

public void setTiempo(String tiempo) {
    Tiempo = tiempo;
}

public String getNumeroCama() {
    return NumeroCama;
}

public void setNumeroCama(String numeroCama) {
    NumeroCama = numeroCama;
}

public String getOpcion() {
    return Opcion;
}

public void setOpcion(String opcion) {
    Opcion = opcion;
}

public abstract String determinarServicioMedico();


}//Fin de la clase
