import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DaoEmpleado {

    List<Empleado> obtenerTodos();

    Empleado obtenerPorNIF(String nif);

    List<Empleado> obtenerPorSalarioSuperior(int salario) throws SQLException;


    List<Empleado> obtenerPorSalarioInferiorIgual(int salario);

    void insertarEmpleados(Empleado empleado);
    void actualizarEmpleados(Empleado empleado) throws IOException;
    void eliminarEmpleado(String nif) throws SQLException;

    boolean existeDepartamento(int numeroDepartamento);

    List<Empleado> obtenerTodosPorDepartamento(int numeroDepartamento);

    void insertarDepartamento(Departamento departamento);
    void modificarDepartamento(Departamento dep);
    void elimminarDepartamento(int numeroDepartamento);
    List<Departamento> obtenerTodosDepartamentos();


    Departamento obtenerPorNumDepartamento(int numeroDepartamento);
}
