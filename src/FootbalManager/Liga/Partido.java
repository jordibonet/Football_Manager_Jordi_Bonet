package FootbalManager.Liga;

import FootbalManager.Equipo.Equipo;

public class Partido {

    Equipo equipo1,equipo2;
    int golesE1, golesE2;
    Equipo ganador;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesE1 = golesE1;
        this.golesE2 = golesE2;
        this.ganador = ganador;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesE1() {
        return golesE1;
    }

    public void setGolesE1(int golesE1) {
        this.golesE1 = golesE1;
    }

    public int getGolesE2() {
        return golesE2;
    }

    public void setGolesE2(int golesE2) {
        this.golesE2 = golesE2;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                ", golesE1=" + golesE1 +
                ", golesE2=" + golesE2 +
                ", ganador=" + ganador +
                '}';
    }
}
