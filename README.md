# 📇 Gestor de Contactos en Java

Este proyecto es una **aplicación de escritorio en Java** que permite **gestionar una lista de contactos** utilizando una interfaz gráfica sencilla basada en `JOptionPane`.

## 🚀 Funcionalidades principales

- Agregar un nuevo contacto
- Buscar un contacto por nombre
- Modificar el teléfono y correo de un contacto
- Eliminar un contacto existente
- Mostrar todos los contactos
- Guardar los contactos en un archivo `.txt` para conservarlos entre ejecuciones

## 🧠 Lógica del programa

La lógica del programa está separada en dos clases principales:

### ✅ `Contacto.java`

Clase que representa un contacto individual. Contiene:

- **Atributos**: nombre (inmutable), teléfono, y correo.
- **Métodos**:
  - `toString()`: convierte un contacto a una línea de texto (para guardar en archivo).
  - `fromString(String)`: reconstruye un contacto desde una línea de texto.
  - `mostrar()`: devuelve una representación con formato del contacto (ideal para mostrar).
  - Getters y setters para teléfono y correo.

### ✅ `GestorContactos.java`

Clase principal que maneja la interfaz y la lógica de operaciones.

- Usa una **estructura de datos** `HashMap<String, Contacto>` para almacenar los contactos en memoria.
- Utiliza un **archivo externo** llamado `contactos.txt` para persistencia.

### 🧺 Estructura de datos

Se utiliza un `HashMap`, que forma parte de la **colección `Map` de Java**.

- Clave: nombre del contacto (String)
- Valor: objeto `Contacto`

**Ventajas**:
- Acceso rápido (tiempo constante) para buscar, modificar o eliminar contactos.
- Evita duplicados fácilmente usando el nombre como clave.

### 📦 Colección utilizada

La colección utilizada es `java.util.HashMap`, una implementación de la interfaz `Map` del **Java Collections Framework**.

## 🧩 Organización del menú

El menú se muestra usando `JOptionPane` y ofrece las siguientes opciones:

1. Agregar contacto
2. Buscar contacto
3. Modificar contacto
4. Eliminar contacto
5. Mostrar todos los contactos
6. Guardar y salir

Cada opción llama a un método específico con la lógica correspondiente.

## 💾 Persistencia

Los contactos se guardan en el archivo `contactos.txt` mediante:

- `BufferedReader` para cargar los contactos al iniciar.
- `PrintWriter` para guardar los contactos al salir.

## 🖥️ Requisitos para ejecutar

- JDK 8 o superior
- Cualquier IDE (Eclipse, IntelliJ, NetBeans) o compilador de línea de comandos


  👨‍💻 Autores
- Carlos Sierra
- Yesenia Perez
- Andres Morales


