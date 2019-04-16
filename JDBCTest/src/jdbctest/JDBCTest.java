package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * *
 * Small demo to show the use of jdbc in connection with postresql
 *
 * (C) 2017 TU Chemnitz / Datenverwaltungssysteme (DVS)
 *
 * @author richard vogel, johannes fliege
 *
 */
public class JDBCTest
{

    /**
     * Enter your Data here (Can be like exercise 1)
     */
    public static final String HOST = "your_server";
    public static final int PORT = 0000;
    public static final String DATABASENAME = "your_database_name";
    public static final String USERNAME = "your_username";
    public static final String PASSWORD = "your_password";
    public static final String TABLENAME = "your_table";

    public static void main(String[] args)
    {
        try
        {
            // Load postgreSQL driver
            Class.forName("org.postgresql.Driver");

            String connectionUrl = "jdbc:postgresql://" + JDBCTest.HOST + ":" + JDBCTest.PORT + "/" + JDBCTest.DATABASENAME;

            // 1. Establish connection
            Connection connection = DriverManager.getConnection(connectionUrl, JDBCTest.USERNAME, JDBCTest.PASSWORD);

            // 2. Create statement
            Statement statement = connection.createStatement();

            // 3. Execute statement
            ResultSet result = statement.executeQuery("SELECT * FROM " + JDBCTest.TABLENAME);

            // Read and print results
            while (result.next())
            {
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++)
                    System.out.println(result.getMetaData().getColumnLabel(i) + ": " + result.getString(i) + ";");
                System.out.println();
            }

            // 4. Free ressources 
            result.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException e)
        {
            // Handle exception for not found database driver
            System.out.println("JDBC-Driver postgres driver not found (Please add it to libraries)");
        }
        catch (SQLException e)
        {
            // Catch SQL Errors
            System.out.println("Error while talking to database");
            System.out.println(e.getMessage());
        }
    }
}
