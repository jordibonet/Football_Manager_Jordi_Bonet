package FootbalManager.Liga;
import FootbalManager.Equipo.Equipo;

import java.util.ArrayList;
import java.util.Arrays;

public class Liga{

    String nombre;
    int numEquipos;
    Equipo [] equiposLiga;
    int partidosDisputados=0;
    ArrayList <Partido> PartidosLiga = new ArrayList<>();
    int [] puntosEquipo;
    int [] golesTotales;
    Equipo EquipoGanador;


    public int[] getGolesTotales() {
        return golesTotales;
    }

    public void setGolesTotales(int[] golesTotales) {
        this.golesTotales = golesTotales;
    }

    public int[] getPuntosEquipo() {
        return puntosEquipo;
    }

    public void setPuntosEquipo(int[] puntosEquipo) {
        this.puntosEquipo = puntosEquipo;
    }

    public Equipo getEquipoGanador() {
        return EquipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        EquipoGanador = equipoGanador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumEquipos() {
        return numEquipos;
    }

    public void setNumEquipos(int numEquipos) {
        this.numEquipos = numEquipos;
    }

    public ArrayList<Partido> getPartidosLiga() {
        return PartidosLiga;
    }

    public void setPartidosLiga(ArrayList<Partido> partidosLiga) {
        PartidosLiga = partidosLiga;
    }

    public int getPartidosDisputados() {
        return partidosDisputados;
    }

    public void setPartidosDisputados(int partidosDisputados) {
        this.partidosDisputados = partidosDisputados;
    }

    public Equipo[] getEquiposLiga() {
        return equiposLiga;
    }

    public void setEquiposLiga(Equipo[] equiposLiga) {
        this.equiposLiga = equiposLiga;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                ", numEquipos=" + numEquipos +
                ", equiposLiga=" + Arrays.toString(equiposLiga) +
                ", partidosDisputados=" + partidosDisputados +
                ", PartidosLiga=" + PartidosLiga +
                '}';
    }

    public void Clasificacion(){
        System.out.println("Nombre de la liga: " +getNombre());
        System.out.println("Numero de equipos: " +getNumEquipos());
        System.out.println("Nombre de los equipos: ");
        for (int i = 0; i < getEquiposLiga().length; i++) {
            System.out.println(getEquiposLiga()[i].getNombre());
        }
        System.out.println("Número de partidos disputados: " +getPartidosDisputados());
        /*System.out.println("Los partidos fueron: ");
        for (int i = 0; i < getPartidosLiga().size(); i++) {
            System.out.println("Partido " +(i+1) +": " +getPartidosLiga().get(i).equipo1.getNombre() +" VS " +getPartidosLiga().get(i).equipo2.getNombre() +". GANADOR: " +getPartidosLiga().get(i).getGanador().getNombre());
        }
        System.out.println("Los goles de cada equipo fueron");
        for (int i = 0; i < getEquiposLiga().length; i++) {
            System.out.println(getEquiposLiga()[i].getNombre() +": " +getGolesTotales()[i]);
        }*/
        System.out.println("EL GANADOR DE LA LIGA FUE EL EQUIPO: " +getEquipoGanador().getNombre());
    }
}
