package FootbalManager.Personas;

import FootbalManager.Equipo.Equipo;

import java.util.ArrayList;

public interface Transferible {

    void transferirAEquipo(Equipo e);

    boolean esTransferible();

}
