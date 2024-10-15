package FootbalManager.Personas;

public abstract class Persona {

    protected String nombre;
    protected String apellido;
    protected String fechaNacimiento;
    protected double nivelMotivacion;
    protected int sueldoAnual;

    public Persona(String nombre, String apellido, String fechaNacimiento, double nivelMotivacion, int sueldoAnual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelMotivacion = nivelMotivacion;
        this.sueldoAnual = sueldoAnual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getNivelMotivacion() {
        return nivelMotivacion;
    }

    public void setNivelMotivacion(double nivelMotivacion) {
        this.nivelMotivacion = nivelMotivacion;
    }

    public int getSueldoAnual() {
        return sueldoAnual;
    }

    public void setSueldoAnual(int sueldoAnual) {
        this.sueldoAnual = sueldoAnual;
    }

    public abstract void mostrarDatos();

    abstract public void entrenament();
}
