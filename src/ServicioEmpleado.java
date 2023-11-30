import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServicioEmpleado {

    private DaoEmpleado dao; // Debes implementar un DAO para acceder a la base de datos

    public ServicioEmpleado(DaoEmpleado dao) {
        this.dao = dao;
    }

    public List<Empleado> obtenerTodosEmpleados() {
        return dao.obtenerTodos();
    }

    public Empleado obtenerEmpleadoPorNIF(String nif) {
        return dao.obtenerPorNIF(nif);
    }

    public List<Empleado> obtenerEmpleadosSalarioSuperior(int salario) throws SQLException {
        return dao.obtenerPorSalarioSuperior(salario);
    }

    public List<Empleado> obtenerEmpleadosSalarioInferiorIgual(int salario) {
        return dao.obtenerPorSalarioInferiorIgual(salario);
    }

    public void insertarEmpleado(Empleado nuevoEmpleado) {

        dao.insertarEmpleados(nuevoEmpleado);
    }

    public void actualizarEmpleado(Empleado nuevoEmpleado) throws IOException {
        dao.actualizarEmpleados(nuevoEmpleado);
    }

    public void borrarEmpleado(String nif) throws SQLException {
        dao.eliminarEmpleado(nif);
    }


    public boolean existeDepartamento(int numeroDepartamento) {

        return dao.existeDepartamento(numeroDepartamento);
    }

    public List<Empleado> obtenerTodosPorDepartamento(int numeroDepartamento) {
        return dao.obtenerTodosPorDepartamento(numeroDepartamento);
    }




}
