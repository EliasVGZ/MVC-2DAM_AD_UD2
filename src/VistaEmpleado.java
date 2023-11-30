
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class VistaEmpleado {

    private BufferedReader br;

    public VistaEmpleado(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String obtenerNif() throws IOException {
        String nif;
        do {
            System.out.println("Dni del empleado: ");
            nif = br.readLine();
            if (!validaDNI_Exp(nif)) {
                System.out.println("opcion no valida ");
            }
        } while (!validaDNI_Exp(nif));
        return nif;
    }

    public String obtenerNss() throws IOException {
        String nss;
        do {
            System.out.println("NSS del empleado: ");
            nss = br.readLine();
            if (!validarNss(nss)) {
                System.out.println("opcion no valida ");
            }
        } while (!validarNss(nss));
        return nss;
    }

    public String obtenerNombre() throws IOException {
        System.out.println("Nombre del empleado: ");
        return br.readLine();
    }

    public String obtenerApellido1() throws IOException {
        System.out.println("Primer apellido: ");
        return br.readLine();
    }

    public String obtenerApellido2() throws IOException {
        System.out.println("Segundo apellido: ");
        return br.readLine();
    }

    public String obtenerSexo() throws IOException {
        System.out.println("Sexo: ");
        return String.valueOf(br.readLine().charAt(0));
    }

    public String obtenerDireccion() throws IOException {
        System.out.println("Direccion: ");
        return br.readLine();
    }

    public LocalDate obtenerFechaNacimiento(){
        LocalDate fechaNacimiento = null;
        do {
            System.out.println("Fecha de nacimiento (yyyy/MM/dd): ");
            try {
                String fechaNacimientoStr = br.readLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
            } catch (DateTimeParseException | IOException e) {
                System.out.println("Formato de fecha incorrecto");
            }
        } while (fechaNacimiento == null);
        return fechaNacimiento;
    }

    public int obtenerSalario() throws IOException {
        System.out.println("Salario: ");
        return Integer.parseInt(br.readLine());
    }

    public int obtenerNumeroDepartamento() throws IOException {
        System.out.println("Numero departamento: ");
        return Integer.parseInt(br.readLine());

    }

    public String obtenerNSSsup() throws IOException {
        String NSSsup;
        do {
            System.out.println("Escribe el NSS superior(opciones: 88888,  11111, 22222, 300000");
            NSSsup = br.readLine();
            if (!NSSsup.equals("88888") && !NSSsup.equals("11111") && !NSSsup.equals("22222") && !NSSsup.equals("300000")) {
                System.out.println("opcion no valida");
            }
        } while (!NSSsup.equals("88888") && !NSSsup.equals("11111") && !NSSsup.equals("22222") && !NSSsup.equals("300000"));
        return NSSsup;
    }

    // Métodos para mostrar resultados al usuario
    public void mostrarEmpleados(List<Empleado> empleados) {
        if (empleados != null) {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        } else {
            System.out.println("No hay empleados para mostrar.");
        }
    }

    public Empleado crearNuevoEmpleado() throws IOException {
        String nif = obtenerNif();
        String nss = obtenerNss();
        String nombre = obtenerNombre();
        String apellido1 = obtenerApellido1();
        String apellido2 = obtenerApellido2();
        char sexo = obtenerSexo().charAt(0);  // Obtener el primer carácter
        String direccion = obtenerDireccion();
        LocalDate fechaNacimiento = obtenerFechaNacimiento();
        int salario = obtenerSalario();
        int numDept = obtenerNumeroDepartamento();
        String nssSup = obtenerNSSsup();

        // Crear y devolver un nuevo objeto Empleado
        return new Empleado(nss, nombre, apellido1, apellido2, sexo, direccion, fechaNacimiento, salario, numDept, nssSup, nif);
    }

    public int obtenerNuevoSalario(){
        int nuevoSalario = 0;
        try{
            System.out.println("Ingrese nuevo salario: ");
            nuevoSalario = Integer.parseInt(br.readLine());
            if(nuevoSalario>0){
                System.out.println("Salario correcto");
            }else{
                System.out.println("Salario incorrecto");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nuevoSalario;
    }









































    public static boolean validaDNI_Exp(String DNI) {
        boolean respuesta = false;
        if (DNI.matches("^[0-9]{8}[TtRrWwAaGgMmYyFfPpDdXxBbNnJjZzSsQqVvHhLlCcKkEe]{1}$")) {
            respuesta = true;
        }
        return respuesta;

    }

    public static boolean validarNss(String nss) {
        boolean respuesta = false;
        if (nss.matches("^[0-9]{5}")) {
            respuesta = true;

        }
        return respuesta;
    }



}
