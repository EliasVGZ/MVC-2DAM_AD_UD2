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
        VistaDepartamento vistaDepartamento = new VistaDepartamento();  // Agrega la vista para departamentos
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado(servicioEmpleado, vistaEmpleado);
        ControladorDepartamento controladorDepartamento = new ControladorDepartamento(servicioEmpleado, vistaDepartamento);  // Agrega el controlador para departamentos

        int opcion;
        do {
            System.out.println("\nMenú principal:");
            System.out.println("1. Gestión empleados");
            System.out.println("2. Gestión de departamentos");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    gestionarEmpleados(controladorEmpleado);
                    break;
                case 2:
                    gestionarDepartamentos(controladorDepartamento);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 0);

        empleadoDao.cerrarConexion();  // Cierra la conexión para departamentos
    }

    private static void gestionarEmpleados(ControladorEmpleado controladorEmpleado) throws IOException, SQLException {
        int opcion;
        do {
            System.out.println("\nMenú de opciones para empleados:");
            System.out.println("a. Insertar Empleado");
            System.out.println("b. Modificar Empleado");
            System.out.println("c. Borrar Empleado");
            System.out.println("d. Listar todos los empleados");
            System.out.println("e. Listar todos los empleados de un departamento");
            System.out.println("f. Consultar empleado por NIF");
            System.out.println("g. Consultar empleados por salario superior");
            System.out.println("h. Consultar empleados por salario igual o inferior al usuario");
            System.out.println("0. Volver al menú principal");

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
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != '0');
    }

    private static void gestionarDepartamentos(ControladorDepartamento controladorDepartamento) throws IOException, SQLException {
        int opcion;
        do {
            System.out.println("\nMenú de opciones para departamentos:");
            System.out.println("a. Insertar Departamento");
            System.out.println("b. Modificar Departamento");
            System.out.println("c. Eliminar Departamento");
            System.out.println("d. Listar todos los departamentos");
            System.out.println("e. Ver información de un único departamento");
            System.out.println("0. Volver al menú principal");

            String opcionStr = br.readLine();
            if (opcionStr.length() == 1) {
                opcion = opcionStr.charAt(0);
            } else {
                opcion = -1;  // Opción no válida
            }

            switch (opcion) {
                case 'a':
                    controladorDepartamento.insertarDepartamento();
                    break;
                case 'b':
                    controladorDepartamento.modificarDepartamento();
                    break;
                case 'c':
                    controladorDepartamento.eliminarDepartamento();
                    break;
                case 'd':
                    controladorDepartamento.consultarTodosDepartamentos();
                    break;
                case 'e':
                    //controladorDepartamento.verInformacionDepartamento();
                    break;
                case '0':
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != '0');
    }
}