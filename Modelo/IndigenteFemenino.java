package Modelo;

public class IndigenteFemenino extends Indigente {
    public IndigenteFemenino(String Nombre, String Edad, String Tiempo, String NumeroCama, String Opcion) {
        super(Nombre, Edad, Tiempo, NumeroCama, Opcion);
    }

    // Implementación del método para indigentes femeninos
    @Override
    public String determinarServicioMedico() {
        return "Ginecología";
    }
}
