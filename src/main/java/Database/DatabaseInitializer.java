package Database;

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
            createPriorityTableIfNotExists();
            createTaskTableIfNotExists();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createPriorityTableIfNotExists() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS task_priority " +
                "(priority_letter VARCHAR(1)," +
                "priority_description VARCHAR(30));";
        Statement statement = connection.createStatement();
        statement.execute(query);
        addDataToPriorityTable();
    }

    private void addDataToPriorityTable() throws SQLException {
        String queryForPriorityA ="INSERT INTO task_priority VALUES" +
                "('A'," +
                "'important and urgent');";
        String queryForPriorityB ="INSERT INTO task_priority VALUES" +
                "('B'," +
                "'important and not urgent');";
        String queryForPriorityC ="INSERT INTO task_priority VALUES" +
                "('C'," +
                "'unimportant and urgent');";
        String queryForPriorityD ="INSERT INTO task_priority VALUES" +
                "('D'," +
                "'unimportant and nor urgent');";
        String arrayOfQueries[] = {queryForPriorityA, queryForPriorityB, queryForPriorityC, queryForPriorityD};
        Statement statement = connection.createStatement();
        for (String query : arrayOfQueries)
            statement.execute(query);
    }

    private void createTaskTableIfNotExists() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS task " +
                "(start_date DATE, " +
                "description TEXT, " +
                "priority VARCHAR(1), " +
                "FOREIGN KEY (priority) REFERENCES task_priority (priority_letter));";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    public Connection getConnection() {
        return connection;
    }
}
