import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControladorDepartamento {

    private ServicioEmpleado servicio;
    private VistaDepartamento vistaDepartamento;

    public ControladorDepartamento(ServicioEmpleado servicio, VistaDepartamento vistaDepartamento) {
        this.servicio = servicio;
        this.vistaDepartamento = vistaDepartamento;
    }

    public void insertarDepartamento() throws IOException {

        Departamento dep = vistaDepartamento.crearNuevoDepartamento();
        servicio.insertarDepartamento(dep);
    }

    public void consultarTodosDepartamentos(){
        List<Departamento> departamentos = servicio.obtenerTodosDepartamentos();
        vistaDepartamento.mostrarDepartamentos(departamentos);
    }

    public void modificarDepartamento() throws IOException {
        int numeroDepartamento = vistaDepartamento.obtenerNumDepartamento();
        Departamento depExiste = servicio.obtenerDepartamentoPorNumero(numeroDepartamento);
    }

    public void eliminarDepartamento() throws IOException, SQLException {
        int numDepartamento = vistaDepartamento.obtenerNumDepartamento();
        Departamento depExiste = servicio.obtenerDepartamentoPorNumero(numDepartamento);
        if(depExiste != null){
            servicio.borrarDepartamento(numDepartamento);

        }else{
            System.out.println("Departamento con numero "+numDepartamento+ " no encontrado.");
        }
    }
}
