package prueba.connection;

import java.sql.*;

public class DbConnection {

    static String db = "persona";
    static String login = "postgres";
    static String password = "12345";
    static String url = "jdbc:postgresql://localhost/" + db;

    Connection connection = null;

    public DbConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, login, password);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + db + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }
}
