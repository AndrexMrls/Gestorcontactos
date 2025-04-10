import javax.swing.*;
import java.io.*;
import java.util.*;

public class GestorContactos {
    private static final Map<String, Contacto> contactos = new HashMap<>();
    private static final String ARCHIVO = "contactos.txt";

    public static void main(String[] args) {
        cargarContactos();
        String[] opciones = {
            "Agregar contacto",
            "Buscar contacto",
            "Modificar contacto",
            "Eliminar contacto",
            "Mostrar todos",
            "Guardar y salir"
        };

        while (true) {
            int opcion = JOptionPane.showOptionDialog(
                null,
                "Selecciona una opción",
                "Gestor de Contactos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (opcion == -1 || opcion == 5) {
                guardarContactos();
                break;
            }

            switch(opcion) {
                case 0 -> agregar();
                case 1 -> buscar();
                case 2 -> modificar();
                case 3 -> eliminar();
                case 4 -> mostrarTodos();
            }
        }
    }

    private static void agregar() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        if (nombre == null || nombre.isEmpty()) return;

        String tel = JOptionPane.showInputDialog("Teléfono:");
        if (tel == null) return;

        String correo = JOptionPane.showInputDialog("Correo:");
        if (correo == null) return;

        contactos.put(nombre, new Contacto(nombre, tel, correo));
        JOptionPane.showMessageDialog(null, "Contacto agregado.");
    }

    private static void buscar() {
        String nombre = JOptionPane.showInputDialog("Nombre a buscar:");
        if (nombre == null) return;

        Contacto c = contactos.get(nombre);
        if (c != null)
            JOptionPane.showMessageDialog(null, c.mostrar());
        else
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
    }

    private static void modificar() {
        String nombre = JOptionPane.showInputDialog("Nombre del contacto a modificar:");
        if (nombre == null) return;

        Contacto c = contactos.get(nombre);
        if (c != null) {
            String nuevoTel = JOptionPane.showInputDialog("Nuevo teléfono:", c.getTelefono());
            String nuevoCorreo = JOptionPane.showInputDialog("Nuevo correo:", c.getCorreo());
            if (nuevoTel != null) c.setTelefono(nuevoTel);
            if (nuevoCorreo != null) c.setCorreo(nuevoCorreo);
            JOptionPane.showMessageDialog(null, "Contacto modificado.");
        } else {
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
        }
    }

    private static void eliminar() {
        String nombre = JOptionPane.showInputDialog("Nombre del contacto a eliminar:");
        if (nombre == null) return;

        if (contactos.remove(nombre) != null)
            JOptionPane.showMessageDialog(null, "Contacto eliminado.");
        else
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
    }

    private static void mostrarTodos() {
        if (contactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay contactos registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder("Lista de contactos:\n\n");
        for (Contacto c : contactos.values()) {
            sb.append(c.mostrar()).append("\n-------------------\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new java.awt.Dimension(400, 300));
        JOptionPane.showMessageDialog(null, scroll, "Contactos", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void cargarContactos() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Contacto c = Contacto.fromString(linea);
                contactos.put(c.getNombre(), c);
            }
        } catch (IOException e) {
            // Archivo no existe aún
        }
    }

    private static void guardarContactos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Contacto c : contactos.values()) {
                pw.println(c.toString());
            }
            JOptionPane.showMessageDialog(null, "Contactos guardados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los contactos.");
        }
    }
}