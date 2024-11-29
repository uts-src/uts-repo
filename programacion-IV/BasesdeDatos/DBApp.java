import java.sql.*;

public class DBApp {
    public static void main(String[] args) {
        String url = "jdbc:ucanaccess://C:/ruta/al/archivo.accdb";
        try (Connection conn = DriverManager.getConnection(url, "", "")) {
            String query = "SELECT * FROM nombre_de_la_tabla"; //codigo SQL para leer registros de la base de datos
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { // imprimir los registros obtenidos
                System.out.println(rs.getString("nombre_columna_1") + " " + rs.getString("nombre_columna_2"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}