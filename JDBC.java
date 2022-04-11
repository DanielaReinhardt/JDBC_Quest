import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC{
    public static void main(String [] args) throws SQLException{

        String username = "Daniela";
        String password = "dani.0730";
       
        final String DRIVER ="com.mysql.cj.jdbc.Driver"; 
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
            e.printStackTrace();
        }
    
        String URL = "jdbc:mysql://localhost:3306/wild_db_quest";
        Connection connection = DriverManager.getConnection(URL, username, password);


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM persons");
      
        String query = "INSERT INTO persons (firstname, lastname, age) VALUES ('Daniela', 'Reinhardt', '29')";
        Statement statement2 = connection.createStatement();
        statement.execute(query);

        String query2 = "INSERT INTO persons (firstname, lastname, age) VALUES ('Johanna', 'Reinhardt', '9')";
        Statement johanna = connection.createStatement();
        statement.execute(query2);
      

        
        Statement statement3 = connection.createStatement();
        String delete = "DELETE FROM persons WHERE firstname ='Daniela'";
        int rowsAffected = statement3.executeUpdate(delete);
        System.out.println("Rows affected delete: " + rowsAffected);

        Statement statement5 = connection.createStatement();
        String delete2 = "DELETE FROM persons WHERE firstname ='John'";
        int rowsAffected3 = statement5.executeUpdate(delete2);
        System.out.println("Rows affected delete: " + rowsAffected3);

        Statement statement4 = connection.createStatement();
        String update = "UPDATE persons SET lastname='Schneider' WHERE lastname='connor'";
        int rowsAffected2 = statement4.executeUpdate(update);
        System.out.println("Rows affected update: " + rowsAffected2);

       
        int columns = resultSet.getMetaData().getColumnCount();
            for(int i = 1; i<=columns; i++)
            System.out.print(String.format("%-15s", resultSet.getMetaData().getColumnLabel(i)));   
            System.out.println();
            
    
            while(resultSet.next()){
                for(int i=1; i<=columns; i++)
                System.out.print(String.format("%-15s", resultSet.getString(i)));
                System.out.println();
    
            }
                   
            
            resultSet.close();
            statement.close();
            statement2.close();
            johanna.close();
            statement3.close();
            statement4.close();
            statement5.close();
            connection.close();

            

        }

        
        
    }
