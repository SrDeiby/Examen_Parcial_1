package Modelo;

public class Persona {

private String Nombre, Edad;    

public Persona(){}//Fin del constructor sin llenar

public Persona(String Nombre, String Edad){
  this.Nombre = Nombre;
  this.Edad = Edad;
}//Fin del constructor

public String getNombre() {
    return Nombre;
}

public void setNombre(String nombre) {
    Nombre = nombre;
}

public String getEdad() {
    return Edad;
}

public void setEdad(String edad) {
    Edad = edad;
}

}//Fin de la clase
