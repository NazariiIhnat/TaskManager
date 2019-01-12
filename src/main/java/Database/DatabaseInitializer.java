package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static Connection connection;

    {
        try {
            if(connection == null){
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:Tasks.db");
            }
            createTaskTableIfNotExists();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createTaskTableIfNotExists() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS task " +
                "(start_date DATE, " +
                "description TEXT, " +
                "priority VARCHAR(1), " +
                "status TEXT);";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public Connection getConnection() {
        return connection;
    }
}
