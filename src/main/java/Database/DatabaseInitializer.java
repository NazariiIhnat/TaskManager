package Dayabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private Connection connection;
    {
        try {
            String url = "jdbc:sqlite:Tasks.db";
            connection = DriverManager.getConnection(url);
            createTableIfNotExists();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS task " +
                "(id INT," +
                "desc TEXT);";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }
}
