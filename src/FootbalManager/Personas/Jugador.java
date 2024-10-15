package FootbalManager.Personas;

import FootbalManager.Equipo.Equipo;

import java.util.ArrayList;
import java.util.Objects;


public class Jugador extends Persona implements Transferible{

    private int numDorsal;
    private String posicion;
    private double puntuacion;
    private boolean transferible;
    private Equipo equipo;

    public Jugador(String nombre, String apellido, String fechaNacimiento, double nivelMotivacion, int sueldoAnual, int numDorsal, String posicion, double puntuacion, boolean transferible, Equipo equipo) {
        super(nombre, apellido, fechaNacimiento, nivelMotivacion, sueldoAnual);
        this.numDorsal = numDorsal;
        this.posicion = posicion;
        this.puntuacion = puntuacion;
        this.transferible = transferible;
        this.equipo = equipo;
    }


    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getNumDorsal() {
        return numDorsal;
    }

    public void setNumDorsal(int numDorsal) {
        this.numDorsal = numDorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean getTransferible() {
        return transferible;
    }

    public void setTransferible(boolean transferible) {
        this.transferible = transferible;
    }

    @Override
    public String toString() {
        return "{" +
                "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Fecha de nacimiento: " + fechaNacimiento +
                ", Nicel de motivación: " + nivelMotivacion +
                ", Sueldo anual: " + sueldoAnual +
                ", Numero de dorsal: " + numDorsal +
                ", Posición: " + posicion +
                ", Puntuación: " + puntuacion +
                '}';
    }
    public String toFile() {
        return nombre+";"+apellido+";"+fechaNacimiento+";"+nivelMotivacion+";"+sueldoAnual+";"+numDorsal+";"+posicion+";"+puntuacion+";"+transferible;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " +nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Fecha de nacimiento: "+fechaNacimiento);
        System.out.println("Nivel de motivación: "+nivelMotivacion);
        System.out.println("Sueldo anual: "+sueldoAnual);
        System.out.println("Numero del dorsal: "+numDorsal);
        System.out.println("Posición: "+posicion);
        System.out.println("Puntuación: "+puntuacion);
    }

    @Override
    public void entrenament() {
        double probabilidad = Math.random();

        if (nivelMotivacion <10){
            nivelMotivacion = (nivelMotivacion + 0.2);
        }
        if (nivelMotivacion > 10) nivelMotivacion = 10;

        if (puntuacion < 100) {
            if (probabilidad < 0.7){
                puntuacion = (puntuacion + 0.1);
            } else if (probabilidad < 0.9){
                puntuacion = (puntuacion + 0.2);
            } else puntuacion = (puntuacion + 0.3);
        }
        if (puntuacion > 100) puntuacion = 100;

        if (puntuacion >= 0.05) {
         canviDePosicion();
            System.out.println(nombre +" ha cambiado de posición a " +posicion);
            if (puntuacion < 100){
                puntuacion = puntuacion +1;
            }
            if (puntuacion > 100) puntuacion = 100;
        }


    }

    private void canviDePosicion() {

        int num = ((int) (Math.random() * 2));

        if (Objects.equals(posicion, "POR")){
            switch (num){
                case 0:
                    posicion = "DAV";
                    break;
                case 1:
                    posicion = "DEF";
                    break;
                case 2:
                    posicion = "MIG";
                    break;
            }
        }else if (Objects.equals(posicion, "MIG")){
            switch (num){
                case 0:
                    posicion = "POR";
                    break;
                case 1:
                    posicion = "DAV";
                    break;
                case 2:
                    posicion = "DEF";
                    break;
            }
        }else if (Objects.equals(posicion, "DEF")){
            switch (num){
                case 0:
                    posicion = "MIG";
                    break;
                case 1:
                    posicion = "POR";
                    break;
                case 2:
                    posicion = "DAV";
                    break;
            }
        }else {
            switch (num){
                case 0:
                    posicion = "DEF";
                    break;
                case 1:
                    posicion = "MIG";
                    break;
                case 2:
                    posicion = "POR";
                    break;
            }
        }

    }

    @Override
    public void transferirAEquipo(Equipo e) {

    }

    @Override
    public boolean esTransferible() {
        return getTransferible();
    }


}
