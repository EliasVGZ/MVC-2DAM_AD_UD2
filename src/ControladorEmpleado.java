import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControladorEmpleado {

    private ServicioEmpleado servicio;
    private VistaEmpleado vista;

    public ControladorEmpleado(ServicioEmpleado servicio, VistaEmpleado vista) {
        this.servicio = servicio;
        this.vista = vista;
    }

    // Métodos para manejar las consultas
    public void consultarTodosEmpleados() {
        List<Empleado> empleados = servicio.obtenerTodosEmpleados();
        vista.mostrarEmpleados(empleados);
    }

    public void consultarEmpleadoPorNIF() throws IOException {
        String nif = vista.obtenerNif();
        Empleado empleado = servicio.obtenerEmpleadoPorNIF(nif);
        System.out.println("Empleado encontrado: " + empleado);
    }



    public void consultarEmpleadosSalarioSuperior() throws IOException, SQLException {
        int salario = vista.obtenerSalario();
        List<Empleado> empleados = servicio.obtenerEmpleadosSalarioSuperior(salario);
        vista.mostrarEmpleados(empleados);
    }

    public void consultarEmpleadosSalarioInferiorIgual() throws IOException {
        int salario = vista.obtenerSalario();
        List<Empleado> empleados = servicio.obtenerEmpleadosSalarioInferiorIgual(salario);
        vista.mostrarEmpleados(empleados);
    }


    public void insertarEmpleado() throws IOException {

        Empleado nuevoEmpleado = vista.crearNuevoEmpleado();
        servicio.insertarEmpleado(nuevoEmpleado);


    }

    public void actualizarEmpleado() throws IOException {
        String dni = vista.obtenerNif();
        Empleado empleadoExiste = servicio.obtenerEmpleadoPorNIF(dni);
        if (empleadoExiste != null) {
            // El empleado existe, ahora puedes realizar la actualización
            int nuevoSalario = vista.obtenerNuevoSalario();  // Solicitar el nuevo salario al usuario

            // Modificar el salario del empleado
            empleadoExiste.setSalario(nuevoSalario);

            // Llamar al método en el servicio para realizar la actualización
            servicio.actualizarEmpleado(empleadoExiste);
        } else {
            System.out.println("Empleado con DNI " + dni + " no encontrado. No se pudo actualizar el salario");
        }

    }

    public void borrarEmpleado() throws IOException, SQLException {
        String dni = vista.obtenerNif();
        Empleado empleadoExiste = servicio.obtenerEmpleadoPorNIF(dni);
        if(empleadoExiste != null){
            servicio.borrarEmpleado(dni);
        }else{
            System.out.println("Empleado con Dni "+dni+ " no encontrado.");
        }
    }

    public void listarEmpleadosPorDepartamento(){
        try{
            int numeroDepartamento = vista.obtenerNumeroDepartamento();
            if(servicio.existeDepartamento(numeroDepartamento)){
                List<Empleado> empleados = servicio.obtenerTodosPorDepartamento(numeroDepartamento);
                if(!empleados.isEmpty()){//si la lista no esta vacia
                    System.out.println("Empleados del departamento: ");
                    for(Empleado info : empleados){
                        System.out.println(info.toString());
                    }
                }else{
                    System.out.println("No hay empleados en el departamento");
                }
            }else{
                System.out.println("Departamento no existe");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
