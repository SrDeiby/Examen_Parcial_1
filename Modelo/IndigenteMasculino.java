package Modelo;

public class IndigenteMasculino extends Indigente {
    public IndigenteMasculino(String Nombre, String Edad, String Tiempo, String NumeroCama, String Opcion) {
        super(Nombre, Edad, Tiempo, NumeroCama, Opcion);
    }

    // Implementación del método para indigentes masculinos
    @Override
    public String determinarServicioMedico() {
        return "Urología";
    }
}