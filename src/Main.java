import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException, SQLException {

        EmpleadoDao empleadoDao = new EmpleadoDao();
        ServicioEmpleado servicioEmpleado = new ServicioEmpleado(empleadoDao);
        VistaEmpleado vistaEmpleado = new VistaEmpleado();
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado(servicioEmpleado, vistaEmpleado);

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("a. Insertar Empleado");
            System.out.println("b. Modificar Empleado");
            System.out.println("c. Borrar Empleado");
            System.out.println("d. Listar todos los empleados");
            System.out.println("e. Listar todos los empleados de un departamento");
            System.out.println("f. Consultar empleado por NIF");
            System.out.println("g. Consultar empleados por salario superior");
            System.out.println("h. Consultar empleados por salario igual o inferior");
            System.out.println("0. Salir");

            String opcionStr = br.readLine();
            if (opcionStr.length() == 1) {
                opcion = opcionStr.charAt(0);
            } else {
                opcion = -1;  // Opción no válida
            }

            switch (opcion) {
                case 'a':
                    controladorEmpleado.insertarEmpleado();
                    break;
                case 'b':
                    controladorEmpleado.actualizarEmpleado();
                    break;
                case 'c':
                    controladorEmpleado.borrarEmpleado();
                    break;
                case 'd':
                    controladorEmpleado.consultarTodosEmpleados();
                    break;
                case 'e':
                    controladorEmpleado.listarEmpleadosPorDepartamento();
                    break;
                case 'f':
                    controladorEmpleado.consultarEmpleadoPorNIF();
                    break;
                case 'g':
                    controladorEmpleado.consultarEmpleadosSalarioSuperior();
                    break;
                case 'h':
                    controladorEmpleado.consultarEmpleadosSalarioInferiorIgual();
                    break;
                case '0':
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != '0');

        empleadoDao.cerrarConexion();

    }
}