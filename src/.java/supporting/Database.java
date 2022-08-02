import java.sql.*;

/**
 * The Database class will connect the Java IDE with a MySQL local host using a designated username and password, w
 * which can be changed along with the host url depending on the MySQL Connection settings found in the Workbench.
 * The class will allow unique additions to the MySQL database schema.
 */
public class Database {
    private final String URL = "jdbc:mysql://localhost:3306/greetingcardcost";
    private final Connection con = DriverManager.getConnection(URL,"root","password");
    private final Statement st = con.createStatement();;

    public Database() throws SQLException {
    }

    /**
     * This method will insert data into the Greeting table in the {@code GreetingCardCost} MySQL database schema.
     */
    public void greetingInsert(String message, int upper, int lower, int special, int digits) throws SQLException {
        try{
            st.executeUpdate(
                    "INSERT INTO greetingcardcost.greeting(message, uppercase, lowercase, special, digits) " +
                            "VALUES ('" + message + "'," + upper + "," + lower + "," + special + "," + digits + ")");
        }catch (SQLIntegrityConstraintViolationException ignored) {
        }
    }

    /**
     * This method will insert data into the Cost table in the {@code GreetingCardCost} MySQL database schema.
     */
    public void costInsert(String message, double width, double length, double total) {
        try {
            st.executeUpdate("INSERT INTO greetingcardcost.cost(message, width, length, total) " +
                    "VALUES ('" + message + "'," + width + "," + length + "," + total + ")");
        }catch (SQLException ignored) {
        }
    }

    /**
     * This method will insert data into the Card table in the {@code GreetingCardCost} MySQL database schema.
     */
    public void cardInsert( double width, double length) {
        try{
            st.executeUpdate("INSERT INTO greetingcardcost.card(width, length) " +
                    "VALUES (" + width + "," + length + ")");
        }catch (SQLException ignored) {
        }
    }
}
