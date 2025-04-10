public class Contacto {
    private final String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public String toString() {
        return nombre + "," + telefono + "," + correo;
    }

    public static Contacto fromString(String linea) {
        String[] partes = linea.split(",");
        return new Contacto(partes[0], partes[1], partes[2]);
    }

    public String mostrar() {
        return "Nombre: " + nombre + "\nTeléfono: " + telefono + "\nCorreo: " + correo;
    }
}