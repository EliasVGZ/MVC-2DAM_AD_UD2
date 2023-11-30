import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class VistaDepartamento {

    private BufferedReader br;

    public VistaDepartamento(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int obtenerNumDepartamento() throws IOException {
        System.out.println("Numero departamento: ");
        return Integer.parseInt(br.readLine());

    }

    public String obtenerNombreDepartamento() throws IOException {
        System.out.println("Nombre del Departamento: ");
        return br.readLine();
    }

    public int obtenerNumeroEmpleadosDepartamento() throws IOException {
        System.out.println("Numero de empleados: ");
        return Integer.parseInt(br.readLine());
    }
    public String obtenerNSSgerente() throws IOException {
        String nss;
        do {
            System.out.println("NSS del gerente: ");
            nss = br.readLine();
            if (!validarNss(nss)) {
                System.out.println("opcion no valida ");
            }
        } while (!validarNss(nss));
        return nss;

    }
    public LocalDate obtenerFechaInicioGerente() {
        LocalDate fechaNacimiento = null;
        do {
            System.out.println("Fecha de inicio (yyyy/MM/dd): ");
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

    public void mostrarDepartamentos(List<Departamento> departamento) {
        if (departamento != null) {
            System.out.println("Lista de departamentos:");
            for (Departamento dep : departamento) {
                System.out.println(dep);
            }
        } else {
            System.out.println("No hay departamentos para mostrar.");
        }
    }


    public Departamento crearNuevoDepartamento() throws IOException {

        int numeroDepartamento = obtenerNumDepartamento();
        String nombreDepartamento = obtenerNombreDepartamento();
        int numeroEmpleadosDepartamento = obtenerNumeroEmpleadosDepartamento();
        String nssGerente = obtenerNSSgerente();
        LocalDate fechaInicio = obtenerFechaInicioGerente();

        return new Departamento(numeroDepartamento, nombreDepartamento,numeroEmpleadosDepartamento,nssGerente,fechaInicio);

    }




    public static boolean validarNss(String nss) {
        boolean respuesta = false;
        if (nss.matches("^[0-9]{5}")) {
            respuesta = true;

        }
        return respuesta;
    }





}
