import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String pass = "root";

        String query = "select * from student;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                                                            //load driver
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }



            try {
                Connection con= DriverManager.getConnection(url, user, pass);      //craeet establish connenction
                Statement stmt = con.createStatement();                              //crate a statement
                ResultSet rs =  stmt.executeQuery(query);                             //execute query

                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String salary =rs.getString("salary");
                     System.out.println("id:-"+id);
                    System.out.println("name :-" +name);
                    System.out.println("salary :-"+ salary);
                }
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }


        }
    }


