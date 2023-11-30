import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBBDD {

    private static Connection conexion;

    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/empleados";
            String usuario = "root";
            String contraseña = "";

            conexion = DriverManager.getConnection(url, usuario, contraseña);
            //System.out.println("Conexión a la base de datos");
            return conexion;

        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                //System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            // Manejo de errores
            throw new RuntimeException("Error al cerrar la conexión", e);
        }
    }
}
