package FootbalManager.Equipo;

import FootbalManager.Personas.Entrenador;
import FootbalManager.Personas.Jugador;
import java.util.ArrayList;

public class Equipo {

    private String nombre;
    private int anoFundacion;
    private String ciudad;
    private String nombreEstadio;
    private String nombrePresidente;
    private int numJugadores;
    private ArrayList<Jugador> jugadores;
    private Entrenador entrenador;


    public Equipo(String nombre, int anoFundacion, String ciudad, String nombreEstadio, String nombrePresidente, int numJugadores) {
        this.nombre = nombre;
        this.anoFundacion = anoFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.nombrePresidente = nombrePresidente;
        this.numJugadores = numJugadores;
        this.jugadores = new ArrayList<>();
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoFundacion() {
        return anoFundacion;
    }

    public void setAnoFundacion(int anoFundacion) {
        this.anoFundacion = anoFundacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public String getNombrePresidente() {
        return nombrePresidente;
    }

    public void setNombrePresidente(String nombrePresidente) {
        this.nombrePresidente = nombrePresidente;
    }

    public int getNumJugadores(){
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores){
        this.numJugadores = numJugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", anoFundacion=" + anoFundacion +
                ", ciudad='" + ciudad + '\'' +
                ", nombreEstadio='" + nombreEstadio + '\'' +
                ", nombrePresidente='" + nombrePresidente + '\'' +
                ", jugadores=" + jugadores +
                ", entrenador=" + entrenador +
                '}';
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " +nombre);
        System.out.println("Año de fundación: "+anoFundacion);
        System.out.println("Ciudad: "+ciudad);
        System.out.println("Nombre del estadio: "+nombreEstadio);
        System.out.println("Nombre del presidente: "+nombrePresidente);
        System.out.println("Entrenador: " +entrenador);
        for (int i = 0; i < getJugadores().size(); i++) {
            System.out.println("Jugador " +(i+1) +": " +getJugadores().get(i));
        }
    }

    public String toFile() {
        return nombre+";"+anoFundacion+";"+ciudad+";"+nombreEstadio+";"+nombrePresidente+";"+numJugadores;
    }

    public double mediaMotivacion() {

        double Motivación;
        double nivelMotivación;

        nivelMotivación = getEntrenador().getNivelMotivacion();
        for (int i = 0; i < getJugadores().size(); i++) {
            nivelMotivación = nivelMotivación + getJugadores().get(i).getNivelMotivacion();
        }
        Motivación = nivelMotivación /(1+getJugadores().size());
        return Motivación;
    }

    public double mediaPuntuacion(){
        double Puntuacion;
        double puntos=0;

        for (int i = 0; i < getJugadores().size(); i++) {
            puntos = puntos + getJugadores().get(i).getPuntuacion();
        }

        Puntuacion = puntos / getJugadores().size();

        return Puntuacion;
    }
}
