package FootbalManager;

import FootbalManager.Equipo.Equipo;
import FootbalManager.Liga.Liga;
import FootbalManager.Liga.Partido;
import FootbalManager.Personas.Entrenador;
import FootbalManager.Personas.Jugador;
import FootbalManager.Personas.Persona;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        boolean salir;
        ArrayList <Persona> EntrenadoresYJugadores = new ArrayList<>();
        ArrayList <Equipo> Equipos = new ArrayList<>();
        Liga liga = new Liga();

        addEntrenadoresYJugadores(EntrenadoresYJugadores);
        addEquipos(Equipos);

        salir = false;
        do {
            menu();
            salir=elegirOpcionMenu(salir, Equipos, EntrenadoresYJugadores,liga);
        }while (!salir);



    }

    private static void addEntrenadoresYJugadores(ArrayList<Persona> EntrenadoresYJugadores) {
        String fileName = "src/FootbalManager/resources/entrenadores.txt";

        BufferedReader br;
        String line;
        String [] datos;

        try {
            br = new BufferedReader(new FileReader(fileName));

            while ((line = br.readLine()) !=null){
                datos = line.split(";");
                Entrenador aux = new Entrenador(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), Boolean.parseBoolean(datos[6]));
                EntrenadoresYJugadores.add(aux);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL BUSCAR EL FICHERO");
        } catch (IOException e) {
            System.out.println("ERROR AL LEER EL FICHERO");
        }

        fileName = "src/FootbalManager/resources/players.txt";
        try {
            br = new BufferedReader(new FileReader(fileName));

            while ((line = br.readLine()) !=null){
                datos = line.split(";");
                Jugador aux = new Jugador(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), datos[6], Double.parseDouble(datos[7]), Boolean.parseBoolean(datos[8]), null);
                EntrenadoresYJugadores.add(aux);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL BUSCAR EL FICHERO");
        } catch (IOException e) {
            System.out.println("ERROR AL LEER EL FICHERO");
        }

    }

    private static void addEquipos(ArrayList<Equipo> Equipos) {
        String fileName = "src/FootbalManager/resources/equipos.txt";

        BufferedReader br;
        String line;
        String [] datos;

        try {
            br = new BufferedReader(new FileReader(fileName));

            while ((line = br.readLine()) !=null){
                datos = line.split(";");
                Equipo equip = new Equipo(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3], datos[4],Integer.parseInt(datos[5]));
                datos = br.readLine().split(";");
                Entrenador e = new Entrenador(datos[0],datos[1],datos[2],Double.parseDouble(datos[3]),Integer.parseInt(datos[4]),Integer.parseInt(datos[5]),Boolean.parseBoolean(datos[6]));
                equip.setEntrenador(e);
                for (int i = 0; i < equip.getNumJugadores(); i++) {
                    datos = br.readLine().split(";");
                    Jugador j = new Jugador(datos[0],datos[1],datos[2],Double.parseDouble(datos[3]),Integer.parseInt(datos[4]),Integer.parseInt(datos[5]),datos[6], Double.parseDouble(datos[7]), Boolean.parseBoolean(datos[8]), equip);
                    equip.getJugadores().add(j);
                }
                Equipos.add(equip);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL BUSCAR EL FICHERO");
        } catch (IOException e) {
            System.out.println("ERROR AL LEER EL FICHERO");
        }

    }


    private static boolean elegirOpcionMenu(boolean salir, ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores, Liga liga) {
        int opcion = opcion();
        switch (opcion) {
            case 0:
                salir = confirmarSalir(Equipos, EntrenadoresYJugadores);
                break;
            case 1:
                verClasificacionLiga(liga);
                break;
            case 2:
                gestionarEquipos(Equipos, EntrenadoresYJugadores);
                break;
            case 3:
                darAltaEquipo(Equipos);
                break;
            case 4:
                darAltaJugadorEntrenador(EntrenadoresYJugadores);
                break;
            case 5:
                consultarDatosEquipo(Equipos);
                break;
            case 6:
                consultarDatosJugador(Equipos);
                break;
            case 7:
                disputarNuevaLiga(Equipos, liga);
                break;
            case 8:
                sesionEntrenamiento(EntrenadoresYJugadores);
                break;
            case 9:
                cargarDatos(Equipos, EntrenadoresYJugadores);
                break;
            case 10:
                guardarDatos(Equipos, EntrenadoresYJugadores);
                break;
            default:
                System.out.println("¡¡¡Escoge una opción valida!!!");
                break;

        }
        return salir;
    }

    private static boolean confirmarSalir(ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {
        boolean correcto;
        int opt;
        Scanner sc = new Scanner(System.in);


        System.out.println("Quieres guardar los datos antes de salir");
        System.out.println("1. SI");
        System.out.println("2. NO");
        correcto=false;
        do {
            System.out.print("\nOpción: ");
            opt = sc.nextInt();
            if (opt == 1 || opt == 2){
                correcto = true;
            } else System.out.println("¡ELIGE UNA OPCIÓN VÁLIDA!");
        }while (!correcto);

        boolean salir;
        if (opt == 1){
            guardarDatos(Equipos, EntrenadoresYJugadores);
        }
        System.out.println("Has terminado el sistema");
        System.out.println("¡HASTA PRONTO!");
        salir = true;


        return salir;
    }

    private static void cargarDatos(ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {
        addEntrenadoresYJugadores(EntrenadoresYJugadores);
        addEquipos(Equipos);
    }

    private static void guardarDatos(ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {

        String File = "src/FootbalManager/resources/equipos.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(File))){
            for (Equipo equipo : Equipos) {
                bw.write(equipo.toFile());
                bw.write(System.lineSeparator());
                bw.write(equipo.getEntrenador().toFile());
                bw.write(System.lineSeparator());
                for (int j = 0; j < equipo.getJugadores().size(); j++) {
                    bw.write(equipo.getJugadores().get(j).toFile());
                    bw.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR EN LA ESCRITURA DE LOS EQUIPOS");
        }

        File = "src/FootbalManager/resources/entrenadores.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(File))){
            for (Persona entrenadoresYJugadore : EntrenadoresYJugadores) {
                if (entrenadoresYJugadore instanceof Entrenador) {
                    bw.write(((Entrenador) entrenadoresYJugadore).toFile());
                    bw.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR EN LA ESCRITURA DE LOS ENTRENADORES");
        }

        File = "src/FootbalManager/resources/players.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(File))){
            for (Persona entrenadoresYJugadore : EntrenadoresYJugadores) {
                if (entrenadoresYJugadore instanceof Jugador) {
                    bw.write(((Jugador) entrenadoresYJugadore).toFile());
                    bw.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR EN LA ESCRITURA DE LOS JUGADORES");
        }

    }

    private static void sesionEntrenamiento(ArrayList<Persona> EntrenadoresYJugadores) {

        for (Persona per: EntrenadoresYJugadores) {
            per.entrenament();

        }

    }

    private static void disputarNuevaLiga(ArrayList<Equipo> Equipos, Liga l) {

        int num, count;
        String nombre;
        Scanner sc = new Scanner(System.in);


        System.out.println("Nombre de la nueva liga: ");
        nombre = sc.nextLine();
        l.setNombre(nombre);

        count = mostrarEquipos(Equipos);
        System.out.println("Este es el numero de equipos que hay creado.");
        System.out.println("Cuantos equipos quieres que participen en la liga " +nombre +"? (mínimo 2): ");
        num = buscarNumLiga(count);
        l.setNumEquipos(num);

        Equipo [] EquiposLiga = SeleccionarEquiposLiga(Equipos,num);
        l.setEquiposLiga(EquiposLiga);
        int [] p = new int[l.getEquiposLiga().length];
        l.setPuntosEquipo(p);
        l.setGolesTotales(p);

        realizarPartidosLiga(l);
        GanadorLiga(l);

    }

    private static void GanadorLiga(Liga l) {
        int [] posicionesGanadores;
        int posiconGanador;

        posicionesGanadores = encontrarPosicionMaxima(l);

        if (posicionesGanadores.length == 1){
            posiconGanador = posicionesGanadores[0];
            Ganador(l,posicionesGanadores,posiconGanador);
        } else {
            System.out.println("Hay un empate con los equipos: ");
            Equipo [] equiposFinal = new Equipo[posicionesGanadores.length];
            for (int i = 0; i < posicionesGanadores.length; i++) {
                System.out.println(l.getEquiposLiga()[i].getNombre());
                equiposFinal[i] = l.getEquiposLiga()[i];
            }
            if (l.getGolesTotales()[posicionesGanadores[0]] > l.getGolesTotales()[posicionesGanadores[1]]){
                posiconGanador = posicionesGanadores[0];
                Ganador(l,posicionesGanadores,posiconGanador);
            } else if (l.getGolesTotales()[posicionesGanadores[0]] > l.getGolesTotales()[posicionesGanadores[1]]){
                posiconGanador = posicionesGanadores[1];
                Ganador(l,posicionesGanadores,posiconGanador);
            } else {
                System.out.println("¡Hay empate en goles totales!");
                System.out.println("Por lo el ganador se decidira por el numeor de puntuación y motivación de los jugadores y entrenador del equipo.");
                double [] puntuacionEquiposLiga = puntuacionEquiposLiga(l.getEquiposLiga());
                if (puntuacionEquiposLiga[posicionesGanadores[0]] > puntuacionEquiposLiga[posicionesGanadores[1]]){
                    posiconGanador = posicionesGanadores[0];
                    Ganador(l,posicionesGanadores,posiconGanador);
                } else{
                    posiconGanador = posicionesGanadores[1];
                    Ganador(l,posicionesGanadores,posiconGanador);
                }

            }
        }

    }

    private static void Ganador(Liga l, int[] posicionesGanadores, int posiconGanador) {
        l.setEquipoGanador(l.getEquiposLiga()[posicionesGanadores[posiconGanador]]);
        System.out.println("El ganador es " +l.getEquipoGanador().getNombre());
    }

    private static int[] encontrarPosicionMaxima(Liga l) {

        int [] posicion = new int[2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < l.getPuntosEquipo().length ; i++) {
            if (l.getPuntosEquipo()[i] > max) {
                max = l.getPuntosEquipo()[i];
                posicion[0]=i;
            } else if (l.getPuntosEquipo()[i] == max) {
                posicion[1]= i;
            }
        }
        return posicion;
    }

    private static void realizarPartidosLiga(Liga l) {

        l.getEquiposLiga();
        double [] puntuacionEquiposLiga;
        int golesE1, golesE2;
        puntuacionEquiposLiga = puntuacionEquiposLiga(l.getEquiposLiga());

        for (int i = 0; i < l.getEquiposLiga().length; i++) {
            for (int j = 0; j < l.getEquiposLiga().length; j++) {
                if (i != j) {
                    Partido p = new Partido(l.getEquiposLiga()[i], l.getEquiposLiga()[j]);
                    golesE1 = marcarGoles(puntuacionEquiposLiga[i]);
                    golesE2 = marcarGoles(puntuacionEquiposLiga[j]);
                    p.setGolesE1(golesE1);
                    l.getGolesTotales()[i]=l.getGolesTotales()[i] +p.getGolesE1();
                    p.setGolesE2(golesE2);
                    l.getGolesTotales()[j]=l.getGolesTotales()[j] +p.getGolesE2();
                    if (p.getGolesE1() > p.getGolesE2()){
                        p.setGanador(p.getEquipo1());
                        l.getPuntosEquipo()[i]= l.getPuntosEquipo()[i]+3;
                    } else if (p.getGolesE1() < p.getGolesE2()){
                        p.setGanador(p.getEquipo2());
                        l.getPuntosEquipo()[j] = l.getPuntosEquipo()[j] +3;
                    } else {
                        l.getPuntosEquipo()[i]= l.getPuntosEquipo()[i]+1;
                        l.getPuntosEquipo()[j]= l.getPuntosEquipo()[j]+1;
                    }
                    l.setPartidosDisputados(l.getPartidosDisputados()+1);
                    l.getPartidosLiga().add(p);
                }
            }
        }


    }

    private static int marcarGoles(double puntuacion) {
        int goles;

        if (puntuacion >= 0 && puntuacion <= 30) {
            goles = (int) (Math.random() * 3);
        } else if (puntuacion > 30 && puntuacion <= 60) {
            goles = (int) (Math.random() * 3) + 1;
        } else if (puntuacion > 60 && puntuacion <= 90) {
            goles = (int) (Math.random() * 2) +2;
        } else if (puntuacion > 90 && puntuacion <= 140) {
            goles = (int) (Math.random() * 3) +2;
        } else if (puntuacion > 140 && puntuacion <= 180) {
            goles = (int) (Math.random() * 2) +3;
        } else{
            goles = (int) (Math.random() * 2) +4;
        }

        return goles;
    }

    private static double[] puntuacionEquiposLiga(Equipo[] EquiposLiga) {
        double [] puntuacionEquiposLiga = new double[EquiposLiga.length];
        double puntuacion;
        double motivacion;
        double mult;


        for (int i = 0; i < EquiposLiga.length; i++) {
            puntuacion = EquiposLiga[i].mediaPuntuacion();
            motivacion = EquiposLiga[i].mediaMotivacion();

            mult = motivacion/5;
            puntuacionEquiposLiga[i] = puntuacion * mult;
        }
        return puntuacionEquiposLiga;
    }

    private static Equipo[] SeleccionarEquiposLiga(ArrayList<Equipo> Equipos, int num) {
        int count, numEquipo;
        Equipo [] EquiposLiga = new Equipo[num];
        ArrayList<Equipo> e = new ArrayList<>(Equipos);

        for (int i = 0; i < num; i++) {
            count =0;
            System.out.println("\nEQUIPOS");
            for (Equipo equi: e) {
                count++;
                System.out.println(count +"- " +equi.getNombre());
            }
            System.out.println("QUE EQUIPO QUIERES AÑADIR A LA LIGA?:");
            numEquipo = buscarNum(count);
            numEquipo--;
            EquiposLiga[i]= e.get(numEquipo);
            e.remove(numEquipo);
        }
        return EquiposLiga;
    }

    private static int mostrarEquipos(ArrayList<Equipo> Equipos) {
        int count = 0;
        System.out.println("EQUIPOS");
        for (Equipo equi: Equipos) {
            count++;
            System.out.println(count +"- " +equi.getNombre());
        }
        return count;
    }

    private static int buscarNumLiga(int count) {
        int num;
        boolean salir;
        Scanner sc = new Scanner(System.in);

        salir = false;
        do {
            System.out.print("\nOpción: ");
            num = sc.nextInt();
            if (num > count || num < 2){
                System.out.println("¡SELECCIONA UN NÚMERO ENTRE 2 y "+count +"!");
            } else salir=true;
        }while (!salir);
        return num;
    }

    private static void consultarDatosJugador(ArrayList<Equipo> Equipos) {
        String nombreEquipo;
        int numJug;

        nombreEquipo = seleccionarNombreEquipo(Equipos);
        numJug = seleccionarJugadorEquipo(nombreEquipo, Equipos);

        for (Equipo equipo : Equipos) {
            if (Objects.equals(equipo.getNombre(), nombreEquipo)){
                equipo.getJugadores().get(numJug-1).mostrarDatos();
                System.out.println("\n");
            }
        }

    }

    private static int seleccionarJugadorEquipo(String nombreEquipo, ArrayList<Equipo> Equipos) {
        int num=0, count=0;
        for (Equipo equipo : Equipos) {
            if (Objects.equals(equipo.getNombre(), nombreEquipo)){
                for (int i = 0; i < equipo.getJugadores().size(); i++) {
                    System.out.println((i+1) +"- " +equipo.getJugadores().get(i).getNombre());
                    count++;
                }
                num = buscarNum(count);
            }
        }
        return num;
    }

    private static void consultarDatosEquipo(ArrayList<Equipo> Equipos) {
        String nombreEquipo;

        nombreEquipo = seleccionarNombreEquipo(Equipos);

        for (Equipo equipo : Equipos) {
            if (Objects.equals(equipo.getNombre(), nombreEquipo)) equipo.mostrarInfo();
        }
        System.out.println("\n");
    }

    private static void darAltaJugadorEntrenador(ArrayList<Persona> EntrenadoresYJugadores) {
        int opcion;
        boolean correcto, salir;
        String nombre, apellido, fechaNacimiento;
        int sueldo;
        Scanner sc = new Scanner(System.in);

        correcto = false;
        do {
            System.out.println("Quieres crear un entrenador o un jugador?");
            System.out.println("1. Entrenador");
            System.out.println("2. Jugador");
            System.out.print("\nOpción:");
            opcion = sc.nextInt();
            if (opcion == 1 || opcion == 2){
                correcto = true;
            }else {
                System.out.println("¡SELECCIONA UNA OPCIÓN CORRECTA!");
            }
        }while (!correcto);

        if (opcion == 1){
            System.out.println("Vas a crear a un Entrenador");
        } else {
            System.out.println("Vas a crear a un Jugador");
        }

        System.out.println("Nombre:");
        nombre = sc.nextLine();
        System.out.println("Apellido");
        apellido = sc.nextLine();
        fechaNacimiento = fechaDeNacimiento();
        System.out.println("Sueldo anual:");
        sueldo = sc.nextInt();

        if (opcion == 1){
            int torneos,seleccionadorNacional;
            boolean SN;

            System.out.println("Numero de torneos ganados: ");
            torneos = sc.nextInt();
            salir = false;
            do {
                System.out.println("¿Ha sido seleccionador nacional?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print("Opcion: ");
                seleccionadorNacional = sc.nextInt();
                if (seleccionadorNacional == 1 || seleccionadorNacional == 2){
                    salir = true;
                } else {
                    System.out.println("¡SELECCIONA UNA OPCIÓN CORRECTA!");
                }
            }while (!salir);
            SN = seleccionadorNacional == 1;

            Entrenador aux = new Entrenador(nombre,apellido,fechaNacimiento,5,sueldo,torneos,SN);
            EntrenadoresYJugadores.add(aux);
            System.out.println("Has creado al entrenador " +nombre +"con los datos: ");
            aux.mostrarDatos();

        } else {
            int dorsal, puntuacion;
            String posicon, pos;


            System.out.println("Numero del dorsal: ");
            dorsal = sc.nextInt();
            System.out.println("Posicion (POR, DEF, MIG, DAV):");
            salir = false;
                do {
                pos = sc.next();
                posicon = pos.toUpperCase();
                if (posicon.equals("POR") || posicon.equals("DEF") || posicon.equals("MIG") || posicon.equals("DAV")){
                    salir = true;
                }else System.out.println("LAS POSICIONES HAN DE SER: POR, DEF, MIG Y DAV");
            }while (!salir);
            System.out.println("Puntuación (30 - 100): ");
            salir = false;
            do {
                puntuacion = sc.nextInt();
                if (puntuacion < 30 || puntuacion >100){
                    System.out.println("LA PUNTUACIÓN HA DE SER ENTRE 30 Y 100");
                } else salir = true;
            }while (!salir);

            Jugador aux = new Jugador(nombre, apellido, fechaNacimiento, 5, sueldo, dorsal, posicon, puntuacion, true, null);
            EntrenadoresYJugadores.add(aux);
            System.out.println("Has creado al jugador "+nombre +" con los datos:");
            aux.mostrarDatos();
        }

    }

    private static String fechaDeNacimiento() {
        int dia, mes, anyo;
        String m = null;
        boolean salir;
        String fechaDeNacimiento;
        Scanner sc = new Scanner(System.in);


        System.out.println("Fecha de nacimiento: ");
        salir = false;
        do {
            System.out.println("Dia: ");
            dia = sc.nextInt();
            if (dia < 1 || dia > 31){
                System.out.println("¡Seleccione un dia entre 1 y 31!");
            } else salir = true;
        }while (!salir);

        salir = false;
        do {
            System.out.println("Mes:");
            mes = sc.nextInt();
            if (mes < 1 || mes > 12){
                System.out.println("¡Seleccione un mes entre 1 y 12!");
            } else  salir = true;
        }while (!salir);
        
        switch (mes){
            case 1:
                m="01";
                break;
            case 2:
                m="02";
                break;
            case 3:
                m="03";
                break;
            case 4:
                m="04";
                break;
            case 5:
                m="05";
                break;
            case 6:
                m="06";
                break;
            case 7:
                m="07";
                break;
            case 8:
                m="08";
                break;
            case 9:
                m="09";
                break;
            case 10:
                m="10";
                break;
            case 11:
                m="11";
                break;
            case 12:
                m="12";
                break;
            default:
                break;
        }
        

        salir = false;
        do {
            System.out.println("Año:");
            anyo = sc.nextInt();
            if (anyo < 1000 || anyo > 2024){
                System.out.println("¡Seleccione un año valido!");
            }else salir = true;
        }while (!salir);

        fechaDeNacimiento = dia+"-"+m +"-"+anyo;

        return fechaDeNacimiento;
    }

    private static void darAltaEquipo(ArrayList<Equipo> Equipos) {
        String nombre, ciudad, nEstadio, nPresidente;
        boolean salir, nombreIgual;
        int anyo;
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce el nombre del nuevo equipo:");
        salir = false;
        do {
            nombreIgual = false;
            System.out.print("\nNombre: ");
            nombre = sc.nextLine();
            for (Equipo equipo : Equipos) {
                if (Objects.equals(nombre, equipo.getNombre())) {
                    System.out.println("YA EXISTE UN EQUIPO CON ESE NOMBRE");
                    nombreIgual = true;
                }
            }
            if (!nombreIgual) salir = true;
        }while (!salir);

        System.out.print("\nAño de fundación: ");
        anyo = sc.nextInt();
        System.out.print("\nCiudad: ");
        ciudad = sc.nextLine();
        System.out.print("\nNombre del estadio: ");
        nEstadio = sc.nextLine();
        System.out.print("\nNombre del presidente: ");
        nPresidente = sc.nextLine();

        Equipo aux = new Equipo(nombre, anyo, ciudad, nEstadio, nPresidente,0);
        Equipos.add(aux);
        System.out.println("Se ha creado correctamente el equipo " +nombre);


    }

    private static void transferirJugador(String nombreEquipo, ArrayList<Equipo> Equipos) {

        int count = 0;
        int num, destinoEquipo;



        for (Equipo equi: Equipos) {
            if (Objects.equals(nombreEquipo, equi.getNombre())){
                for (int i = 0; i < equi.getJugadores().size(); i++) {
                    System.out.println((count + 1) + "- " +equi.getJugadores().get(i).getNombre() +" " + equi.getJugadores().get(i).getApellido());
                    count++;
                }
                System.out.println("Selecciona el número del jugador que quieres transferir: ");
                num = buscarNum(count);
                num--;
                if (equi.getJugadores().get(num).esTransferible()) {
                    count=0;
                    for (Equipo e: Equipos) {
                        if (!Objects.equals(nombreEquipo, e.getNombre())){
                            System.out.println((count +1) +"- " +e.getNombre());
                            count++;
                        }
                    }
                    System.out.println("Selecciona el número del equipo al que lo quieres transferir: ");
                    destinoEquipo = buscarNum(count);
                    Jugador j = equi.getJugadores().get(num);
                    equi.getJugadores().remove(num);
                    j.setEquipo(Equipos.get(destinoEquipo));
                    Equipos.get(destinoEquipo).getJugadores().add(j);

                } else {
                    System.out.println("El jugador " +equi.getJugadores().get(num).getNombre() +" " +equi.getJugadores().get(num).getApellido() +" no es transferible.");
                }
            }
        }

    }

    private static void ficharJugadorEntrnador(String nombreEquipo, ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {
        boolean salir;
        int opcion, count=0, num;
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Quieres fichar un entrenador o un jugador?");
        System.out.println("1. Entrenador");
        System.out.println("2. Jugador");
        salir = false;
        do {
            opcion = sc.nextInt();
            if (opcion == 1 || opcion == 2){
                salir = true;
            } else {
                System.out.println("¡ELIGE UNA OPCIÓN VÁLIDA!");
            }
        }while (!salir);

        if (opcion == 1){
            for (Equipo aux: Equipos) {
                if (Objects.equals(nombreEquipo, aux.getNombre())){
                    if (aux.getEntrenador()==null){
                        System.out.println("Vas a fichar un entrenador");
                        for (Persona entYJug : EntrenadoresYJugadores) {
                            if (entYJug instanceof Entrenador) {
                                System.out.println((count + 1) + "- " + entYJug.getNombre() + " " + entYJug.getApellido());
                                count++;
                            }
                        }
                        System.out.println("Selecciona el número del entrenador que quieres fichar: ");
                        num = buscarNum(count);

                        count=0;
                        for (int i = 0; i < EntrenadoresYJugadores.size(); i++) {
                            if (EntrenadoresYJugadores.get(i) instanceof Entrenador){
                                count++;
                                if (num==count){
                                    Entrenador e = (Entrenador) EntrenadoresYJugadores.get(i);
                                    for (Equipo equi: Equipos) {
                                        if (Objects.equals(nombreEquipo, equi.getNombre())){
                                            equi.setEntrenador(e);
                                        }
                                    }
                                    EntrenadoresYJugadores.remove(i);
                                    System.out.println(e.getNombre() +" " +e.getApellido() +"es el nuevo entrenador del " +nombreEquipo);
                                }
                            }
                        }
                    }else {
                        System.out.println("El equipo " +nombreEquipo +" ya tiene entrnador");
                        System.out.println("Si quieres fichar un entrenador nuevo primero tendras que destituir al actual");
                    }
                }
            }

        } else {
            System.out.println("Vas a fichar un jugador");
            for (Persona entYJug : EntrenadoresYJugadores) {
                if (entYJug instanceof Jugador) {
                    System.out.println((count + 1) + "- " + entYJug.getNombre() + " " + entYJug.getApellido());
                    count++;
                }
            }
            System.out.println("Selecciona el número del jugador que quieres fichar: ");
            num = buscarNum(count);

            count=0;
            for (int i = 0; i < EntrenadoresYJugadores.size(); i++) {
                if (EntrenadoresYJugadores.get(i) instanceof Jugador){
                    count++;
                    if (num==count){
                        Jugador j = (Jugador) EntrenadoresYJugadores.get(i);
                        for (Equipo equi: Equipos) {
                            if (Objects.equals(nombreEquipo, equi.getNombre())){
                                j.setEquipo(equi);
                                equi.getJugadores().add(j);
                                equi.setNumJugadores(+1);
                            }
                        }
                        EntrenadoresYJugadores.remove(i);
                        System.out.println(j.getNombre() +" " +j.getApellido() +" es un nuevo jugador del " +nombreEquipo);
                    }
                }

            }

        }
    }

    private static int buscarNum(int count) {
        int num;
        boolean salir;
        Scanner sc = new Scanner(System.in);

        salir = false;
        do {
            System.out.print("\nOpción: ");
            num = sc.nextInt();
            if (num > count || num < 0){
                System.out.println("¡SELECCIONA UN NÚMERO VÁLIDO!");
            } else salir=true;
        }while (!salir);
        return num;
    }

    private static void destituirEntrenador(String nombreEquipo, ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {
        boolean salir;
        int opcion;
        Scanner sc = new Scanner(System.in);


        System.out.println("¿Estas seguro que quieres destituir al entrenador?");
        System.out.println("1. SI");
        System.out.println("2. NO");
        salir = false;
        do {
            System.out.print("\nOpción: ");
            opcion = sc.nextInt();

            if (opcion == 1||opcion ==2){
                salir=true;
            } else {
                System.out.println("ELIGE UNA OPCIÓN VALIDA");
            }
        }while (!salir);

        if (opcion == 1){
            for (Equipo aux: Equipos) {
                if (Objects.equals(nombreEquipo,aux.getNombre())){
                    Entrenador e = aux.getEntrenador();
                    aux.setEntrenador(null);
                    EntrenadoresYJugadores.add(e);
                    System.out.println("El entrenador ha sido destituido");
                }
            }
        } else {
            System.out.println("El entrenador no será destituido");
        }

    }

    private static void modificarPresidente(String nombreEquipo, ArrayList<Equipo> Equipos) {
        String nPresidente;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre del nuevo presidente: ");
        nPresidente = sc.nextLine();

        for (Equipo aux: Equipos) {
            if (Objects.equals(nombreEquipo,aux.getNombre())){
                if (Objects.equals(nPresidente,aux.getNombrePresidente())){
                    System.out.println("El nombre del nuevo presidente es el mismo que el actual");
                } else if (Objects.equals(nPresidente,null)){
                    System.out.println("El equipo no tenia presidente anterior");
                }
                aux.setNombrePresidente(nPresidente);
                System.out.println(nPresidente +" es el nuevo presidente del equipo "+nombreEquipo);
            }
        }
    }

    private static Boolean darBajaEquipo(boolean atras, String nombreEquipo, ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {
        boolean correcto;
        char confirmar;
        Scanner sc = new Scanner(System.in);

        correcto = false;
        System.out.println("Estas seguro que quieres eliminar al equipo: " +nombreEquipo);
        do {
            System.out.print("\n'S' o 'N': ");
            confirmar = Character.toUpperCase(sc.next().charAt(0));
            if (confirmar == 'S' || confirmar == 'N'){
                correcto = true;
            } else {
                System.out.println("¡ELIGE UNA OPCIÓN CORRECTA!");
            }
        }while (!correcto);

        if (confirmar == 'S'){
            for (int i = 0; i < Equipos.size(); i++) {
                if (Objects.equals(nombreEquipo, Equipos.get(i).getNombre())){
                    EntrenadoresYJugadores.addAll(Equipos.get(i).getJugadores());

                    for (Persona entrenadoresYJugadore : EntrenadoresYJugadores) {
                        if (entrenadoresYJugadore instanceof Jugador) {
                            ((Jugador) entrenadoresYJugadore).setEquipo(null);
                        }
                    }


                    Entrenador e = Equipos.get(i).getEntrenador();
                    EntrenadoresYJugadores.add(e);
                    
                    System.out.println("El equipo ha sido eliminado");
                    Equipos.remove(i);
                    atras=true;
                    break;
                }
            }
        } else System.out.println("El equipo no va a ser eliminado");
        return atras;
    }

    private static void verClasificacionLiga(Liga liga){
        liga.Clasificacion();
    }

    private static void gestionarEquipos(ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {
        boolean atras;
        String nombreEquipo;

        nombreEquipo = seleccionarNombreEquipo(Equipos);

        atras = false;
        do {
            menuGestionarEquipos();
            atras = elegirOpcionGestionarEquipos(atras, nombreEquipo,Equipos, EntrenadoresYJugadores);
        }while (!atras);

    }

    private static String seleccionarNombreEquipo(ArrayList<Equipo> Equipos) {
        String nombreEquipo;
        int num, count;

       count = mostrarEquipos(Equipos);
        num = buscarNum(count);

        nombreEquipo = Equipos.get(num-1).getNombre();
        return nombreEquipo;
    }
    private static boolean elegirOpcionGestionarEquipos(boolean atras, String nombreEquipo, ArrayList<Equipo> Equipos, ArrayList<Persona> EntrenadoresYJugadores) {
        int opcion = opcion();
        switch (opcion){
            case 0:
                atras = true;
                break;
            case 1:
                atras=darBajaEquipo(atras,nombreEquipo,Equipos,EntrenadoresYJugadores);
                break;
            case 2:
                modificarPresidente(nombreEquipo,Equipos);
                break;
            case 3:
                destituirEntrenador(nombreEquipo,Equipos, EntrenadoresYJugadores);
                break;
            case 4:
                ficharJugadorEntrnador(nombreEquipo, Equipos, EntrenadoresYJugadores);
                break;
            case 5:
                transferirJugador(nombreEquipo, Equipos);
                break;
            default:
                System.out.println("¡¡¡Escoge una opción valida!!!");
                break;
        }
        return atras;
    }

    private static void menuGestionarEquipos() {
        System.out.println("TEAM MANAGER: ");
        System.out.println("      1- Dar de baja el grupo");
        System.out.println("      2- Modificar presidente/a");
        System.out.println("      3- Destituir entrenador/a");
        System.out.println("      4- Fichar jugador/a o entrenador/a");
        System.out.println("      5- Transferir jugador/a");
        System.out.println("   0- ATRÁS");
    }

    private static int opcion() {
        int opcion=0;
        boolean salir;

        do {
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("\nOpción: ");
                opcion = sc.nextInt();
                salir=true;
            } catch (Exception e){
                System.out.println("Selecciona un número");
                salir=false;
            }
        }while (!salir);
        return opcion;
    }

    private static void menu() {
        System.out.println("Welcome to Politècncis Football Manager: ");
        System.out.println("      1- Ver clasificación liga");
        System.out.println("      2- Gestionar equipos");
        System.out.println("      3- Dar de alta un equipo");
        System.out.println("      4- Dar de alta un jugador/a o entrenador/a");
        System.out.println("      5- Consultar datos de un equipo");
        System.out.println("      6- Consultar datos de un jugador/a");
        System.out.println("      7- Disputar nueva liga");
        System.out.println("      8- Realizar sesión de entrenamiento");
        System.out.println("      9- Cargar datos de equipos");
        System.out.println("      10- Guardar datos de quipos");
        System.out.println("   0- SALIR");
    }

}