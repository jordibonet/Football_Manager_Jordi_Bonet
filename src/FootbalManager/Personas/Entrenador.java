package FootbalManager.Personas;

public class Entrenador extends Persona {

    private int numeroTorneosGanados;
    private boolean seleccionadorNacional;

    public Entrenador(String nombre, String apellido, String fechaNacimiento, double nivelMotivacion, int sueldoAnual, int numeroTorneosGanados, boolean seleccionadorNacional) {
        super(nombre, apellido, fechaNacimiento, nivelMotivacion, sueldoAnual);
        this.numeroTorneosGanados = numeroTorneosGanados;
        this.seleccionadorNacional = seleccionadorNacional;
    }

    public int getNumeroTorneosGanados() {
        return numeroTorneosGanados;
    }

    public void setNumeroTorneosGanados(int numeroTorneosGanados) {
        this.numeroTorneosGanados = numeroTorneosGanados;
    }

    public boolean isSeleccionadorNacional() {
        return seleccionadorNacional;
    }

    public void setSeleccionadorNacional(boolean seleccionadorNacional) {
        this.seleccionadorNacional = seleccionadorNacional;
    }

    @Override
    public String toString() {
        return "{" +
                "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Fecha de nacimiento: " + fechaNacimiento +
                ", Nivel de motivación: " + nivelMotivacion +
                ", Sueldo anual: " + sueldoAnual +
                ", Numero de torneos ganados: " + numeroTorneosGanados +
                ", ¿Ha estado seleccionador nacional?: " + seleccionadorNacional +
                '}';
    }

    public String toFile(){
        return nombre+";"+apellido+";"+fechaNacimiento+";"+nivelMotivacion+";"+sueldoAnual+";"+numeroTorneosGanados+";"+seleccionadorNacional;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " +nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Fecha de nacimiento: "+fechaNacimiento);
        System.out.println("Nivel de motivación: "+nivelMotivacion);
        System.out.println("Sueldo anual: "+sueldoAnual);
        System.out.println("Numero de torneos ganados: "+numeroTorneosGanados);
        System.out.println("¿Ha estado seleccionador nacional?: "+seleccionadorNacional);
    }

    @Override
    public void entrenament() {

        if (nivelMotivacion < 10){
            if(seleccionadorNacional){
                nivelMotivacion = nivelMotivacion + 0.3;
            } else nivelMotivacion = nivelMotivacion + 0.15;
        }

        if (nivelMotivacion > 10){
            nivelMotivacion = 10;
        }
        incrementarSueldo();

    }

    private void incrementarSueldo() {

        sueldoAnual = (int) (sueldoAnual * 1.5);

    }
}
