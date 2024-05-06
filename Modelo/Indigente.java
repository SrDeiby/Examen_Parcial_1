package Modelo;

public class Indigente extends Persona {
private String Tiempo, NumeroCama;

public Indigente(String Nombre, String Edad, String Tiempo, String NumeroCama){
super(Nombre, Edad);
this.Tiempo = Tiempo;
this.NumeroCama = NumeroCama;
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

}//Fin de la clase
