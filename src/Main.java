import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            //1.connection
 Connection conn= DriverManager.getConnection("jdbc:sqlite:/Users/ashish/IdeaProjects/MovieDataBase/Movies.db");
            Statement statement=conn.createStatement();

            //2.table created
            statement.execute("CREATE TABLE IF NOT EXISTS Movies(movie_name TEXT,lead_actor TEXT,lead_actress TEXT,year_of_release TEXT,dir_name TEXT)");

            //3.Values Inserted
            statement.execute("INSERT INTO Movies(movie_name,lead_actor,lead_actress,year_of_release,dir_name) VALUES('Bell Bottom','Akshay kumar','Huma Qureshi','19-Aug-2021','Ranjit M Tewari')");

            statement.execute("INSERT INTO Movies(movie_name,lead_actor,lead_actress,year_of_release,dir_name) VALUES('Roohi','RajKummar Rao','Janhvi Kapoor','11-Mar-2021','Hardik Mehta')");

            statement.execute("INSERT INTO Movies(movie_name,lead_actor,lead_actress,year_of_release,dir_name) VALUES('Mumbai Saga','John Abraham','Kajal Aggarwal','19-Mar-2021','Sanjay Gupta')");

            statement.execute("INSERT INTO Movies(movie_name,lead_actor,lead_actress,year_of_release,dir_name) VALUES('Radhe','Salman khan','Disha Patani','13-May-2021','Prabhu Deva')");

            statement.execute("INSERT INTO Movies(movie_name,lead_actor,lead_actress,year_of_release,dir_name) VALUES('Toofaan','Farhan Akhtar','Mrunal Thakur','16-Jul-2021','Rakeyesh Mehra')");

            //3.Select statement
            statement.execute("SELECT  * from Movies");
            ResultSet results = statement.getResultSet();
            while (results.next()){
                System.out.println(results.getString("movie_name")+" |"+
                        results.getString("lead_actor")+" |"+
                        results.getString("lead_actress")+" |"+
                        results.getString("year_of_release")+" |"+
                        results.getString("dir_name"));
            }
            results.close();

            //4.select movies based on the actor's name.
            statement.execute("SELECT movie_name FROM Movies WHERE lead_actor='Akshay kumar'");
            ResultSet results2=statement.getResultSet();
                System.out.println(results2.getString("movie_name"));
            results.close();

            statement.close();
            conn.close();

        }
        catch (SQLException e)
        {
            System.out.println("Something went wrong"+e.getMessage());
        }
    }
}
