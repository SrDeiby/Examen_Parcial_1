package Modelo;

public class Indigente extends Persona {
private String Tiempo;

public Indigente(String Nombre, String Edad, String Tiempo){
super(Nombre, Edad);
this.Tiempo = Tiempo;

}//Fin del constructor

public String getTiempo() {
    return Tiempo;
}

public void setTiempo(String tiempo) {
    Tiempo = tiempo;
}

}//Fin de la clase
