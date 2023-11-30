import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao implements DaoEmpleado{

    private Connection conexion;

    public EmpleadoDao(){
        this.conexion = ConectarBBDD.conectar();
    }
    @Override
    public List<Empleado> obtenerTodos() {
        List<Empleado> empleados = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM empleado");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setNss(resultSet.getString("NSS"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setApellido1(resultSet.getString("Apel1"));
                empleado.setApellido2(resultSet.getString("Apel2"));
                empleado.setSexo(resultSet.getString("Sexo").charAt(0));
                empleado.setDireccion(resultSet.getString("Dirección"));
                empleado.setFechaNacimiento(resultSet.getDate("Fechanac").toLocalDate());
                empleado.setSalario(resultSet.getInt("Salario"));
                empleado.setNumeroDepartamento(resultSet.getInt("Numdept"));
                empleado.setNSSsup(resultSet.getString("NSSsup"));
                empleado.setNif(resultSet.getString("NIF"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción según tus necesidades
        }
        return empleados;
    }


    @Override
    public Empleado obtenerPorNIF(String nif) {
        String sql = "SELECT * FROM empleado WHERE NIF = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, nif);
            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                Empleado empleado = new Empleado();
                empleado.setNif(nif);
                empleado.setNss(resultado.getString("NSS"));
                empleado.setNombre(resultado.getString("Nombre"));
                empleado.setApellido1(resultado.getString("Apel1"));
                empleado.setApellido2(resultado.getString("Apel2"));
                empleado.setSexo(resultado.getString("Sexo").charAt(0));
                empleado.setDireccion(resultado.getString("Dirección"));
                empleado.setFechaNacimiento(resultado.getDate("Fechanac").toLocalDate());
                empleado.setSalario(resultado.getInt("Salario"));
                empleado.setNumeroDepartamento(resultado.getInt("Numdept"));
                empleado.setNSSsup(resultado.getString("NSSsup"));

                return empleado;  // Retorna el objeto Empleado creado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción según tus necesidades
        }

        return null;  // Retorna null si no se encontró ningún empleado con ese NIF
    }


    @Override
    public List<Empleado> obtenerPorSalarioSuperior(int salario) throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        try(PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM empleado where Salario > ? ")){
            preparedStatement.setInt(1, salario);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setNss(resultSet.getString("NSS"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setApellido1(resultSet.getString("Apel1"));
                empleado.setApellido2(resultSet.getString("Apel2"));
                empleado.setSexo(resultSet.getString("Sexo").charAt(0));
                empleado.setDireccion(resultSet.getString("Dirección"));
                empleado.setFechaNacimiento(resultSet.getDate("Fechanac").toLocalDate());
                empleado.setSalario(resultSet.getInt("Salario"));
                empleado.setNumeroDepartamento(resultSet.getInt("Numdept"));
                empleado.setNSSsup(resultSet.getString("NSSsup"));
                empleado.setNif(resultSet.getString("NIF"));
                empleados.add(empleado);
            }


        }catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción según tus necesidades
        }
        return empleados;
    }

    @Override
    public List<Empleado> obtenerPorSalarioInferiorIgual(int salario) {
        List<Empleado> empleados = new ArrayList<>();
        try(PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM empleado where Salario <= ? ")){
            preparedStatement.setInt(1, salario);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setNss(resultSet.getString("NSS"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setApellido1(resultSet.getString("Apel1"));
                empleado.setApellido2(resultSet.getString("Apel2"));
                empleado.setSexo(resultSet.getString("Sexo").charAt(0));
                empleado.setDireccion(resultSet.getString("Dirección"));
                empleado.setFechaNacimiento(resultSet.getDate("Fechanac").toLocalDate());
                empleado.setSalario(resultSet.getInt("Salario"));
                empleado.setNumeroDepartamento(resultSet.getInt("Numdept"));
                empleado.setNSSsup(resultSet.getString("NSSsup"));
                empleado.setNif(resultSet.getString("NIF"));
                empleados.add(empleado);
            }


        }catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción según tus necesidades
        }
        return empleados;
    }

    @Override
    public void insertarEmpleados(Empleado empleado) {

        String sql = "INSERT INTO empleado (NSS, Nombre, Apel1, Apel2, Sexo, Dirección, Fechanac, Salario, Numdept, NSSsup, NIF) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preStatement = conexion.prepareStatement(sql)) {
            //establecer los valores de los parámetros
            preStatement.setString(1, empleado.getNss());
            preStatement.setString(2, empleado.getNombre());
            preStatement.setString(3, empleado.getApellido1());
            preStatement.setString(4, empleado.getApellido2());
            preStatement.setString(5, String.valueOf(empleado.getSexo()));
            preStatement.setString(6, empleado.getDireccion());
            preStatement.setDate(7, java.sql.Date.valueOf(empleado.getFechaNacimiento()));
            preStatement.setDouble(8, empleado.getSalario());
            preStatement.setInt(9, empleado.getNumeroDepartamento());
            preStatement.setString(10, empleado.getNSSsup());
            preStatement.setString(11, empleado.getNif());

            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarEmpleados(Empleado empleado)  {

        String sql = "UPDATE empleado set salario = ? Where nif = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setDouble(1, empleado.getSalario());
            preparedStatement.setString(2, empleado.getNif());

            int filasActualizadas = preparedStatement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("salario Empleado actualizado ");
            } else {
                System.out.println("No se pudo encontrar al empleado con NIF " + empleado.getNif() + " para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el empleado: " + e.getMessage());
        }
    }

    @Override
    public void eliminarEmpleado(String nif) throws SQLException {

        if(tieneEmpleadosACargo(nif)){
            System.out.println("No se puede eliminar porque tiene empleados a su cargo");
        }else{
            //eliminar empleado
            String sqlDelete = "DELETE from empleado where NIF = ? ";
            try (PreparedStatement preparedStatementDelete = conexion.prepareStatement(sqlDelete)) {
                preparedStatementDelete.setString(1, nif);
                int filasAfectadas = preparedStatementDelete.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Empleado eliminado");
                } else {
                    System.out.println("No se puede eliminar el empleado");
                }
            }
        }
    }

    @Override
    public boolean existeDepartamento(int numeroDepartamento) {
        String sql = "SELECT COUNT(*) FROM empleado WHERE Numdept = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, numeroDepartamento);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia del departamento: " + e.getMessage());
        }

        return false;
    }


    public boolean tieneEmpleadosACargo(String NSSsupervisor) {
        String sql = "SELECT COUNT(*) FROM empleado WHERE NSSsup = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, NSSsupervisor);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar empleados a cargo: " + e.getMessage());
        }

        return false;
    }


    @Override
    public List<Empleado> obtenerTodosPorDepartamento(int numeroDepartamento) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado WHERE Numdept = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, numeroDepartamento);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Empleado empleado = new Empleado();
                empleado.setNss(resultSet.getString("NSS"));
                empleado.setNombre(resultSet.getString("Nombre"));
                empleado.setApellido1(resultSet.getString("Apel1"));
                empleado.setApellido2(resultSet.getString("Apel2"));
                empleado.setSexo(resultSet.getString("Sexo").charAt(0));
                empleado.setDireccion(resultSet.getString("Dirección"));
                empleado.setFechaNacimiento(resultSet.getDate("Fechanac").toLocalDate());
                empleado.setSalario(resultSet.getInt("Salario"));
                empleado.setNumeroDepartamento(resultSet.getInt("Numdept"));
                empleado.setNSSsup(resultSet.getString("NSSsup"));
                empleado.setNif(resultSet.getString("NIF"));

                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener empleados por departamento: " + e.getMessage());
        }

        return empleados;
    }

    @Override
    public void insertarDepartamento(Departamento departamento) {

        String sql = "INSERT INTO departamento (Numdep, Nombredep, Numempdep, NSSgerente, fechainicgerente) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preStatement = conexion.prepareStatement(sql)) {
            //establecer los valores de los parámetros
            preStatement.setInt(1, departamento.getNumeroDepartamento());
            preStatement.setString(2, departamento.getNombreDepartamento());
            preStatement.setInt(3, departamento.getNumeroDepartamento());
            preStatement.setString(4, departamento.getNSSgerente());
            preStatement.setDate(5, java.sql.Date.valueOf(departamento.getFechaInicioGerente()));
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modificarDepartamento(Departamento dep) {

    }

    @Override
    public void elimminarDepartamento(int numeroDepartamento) {
        String sqlDeleteDepto = "DELETE FROM departamento WHERE Numdep = ?";
        try (PreparedStatement psDelete = conexion.prepareStatement(sqlDeleteDepto)) {
            psDelete.setInt(1, numeroDepartamento);
            int filasAfectadas = psDelete.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Departamento eliminado");
            } else {
                System.out.println("No se puede eliminar el departamento");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Departamento> obtenerTodosDepartamentos() {
        return null;
    }

    @Override
    public Departamento obtenerPorNumDepartamento(int numeroDepartamento) {
        String sqlVerificarDepartamento = "SELECT Numempdep FROM departamento WHERE Numdep = ?";
        try (PreparedStatement psVerificar = conexion.prepareStatement(sqlVerificarDepartamento)) {
            psVerificar.setInt(1, numeroDepartamento);
            ResultSet resultado = psVerificar.executeQuery();

            if (resultado.next()) {
                int totalEmpleados = resultado.getInt("Numempdep");

                if (totalEmpleados > 0) {

                    System.out.println("Numero de empleados del departamento "+totalEmpleados);
                    String sqlVerEmpleados = "SELECT * from empleado where Numdept = ?";
                    try {
                        PreparedStatement preparedStatement = conexion.prepareStatement(sqlVerEmpleados);
                        preparedStatement.setInt(1, numeroDepartamento);
                        resultado = preparedStatement.executeQuery();

                        while(resultado.next()){
                            String nss = resultado.getString("NSS");
                            String nombre = resultado.getString("Nombre");
                            String apellido1 = resultado.getString("Apel1");
                            String apellido2 = resultado.getString("Apel2");
                            String sexo = resultado.getString("Sexo");
                            String direccion = resultado.getString("Dirección");
                            LocalDate fechaNacimiento = resultado.getDate("Fechanac").toLocalDate();
                            Double salario = resultado.getDouble("Salario");
                            int numdept = resultado.getInt("Numdept");
                            String nsssup = resultado.getString("NSSsup");
                            String nif = resultado.getString("NIF");
                            System.out.println(nss + " " + nombre + " " + apellido1 + " " + apellido2 + " " + sexo + " " +
                                    direccion + " " + fechaNacimiento + " " + salario + " " + numdept + " " + nsssup + " " + nif);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Departamento no existe");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }


    public void cerrarConexion() {
        ConectarBBDD.cerrarConexion();
    }
}
