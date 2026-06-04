import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSupabase {
    private static final String URL = "jdbc:postgresql://db.bjjuadymoaprafolfrgk.supabase.co:5432/postgres?user=postgres&password=e27MQlK38LEBcnCP";
    private static final String USUARIO = "postgres";
    private static final String PASSWORD = "e27MQlK38LEBcnCP";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}