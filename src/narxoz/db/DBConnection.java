package narxoz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
  private static Connection connection;


  static {
    String url = "jdbc:postgresql://localhost:5432/sprint42";
    String user = "postgres";
    String password = "asem20004";
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(url, user, password);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<Items> getItems() {
    ArrayList<Items> items = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Items ORDER by id asc"
      );

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Items item = new Items();
        item.setId(resultSet.getLong("id"));
        item.setName(resultSet.getString("name"));
        item.setDescription(resultSet.getString("description"));
        item.setPrice(resultSet.getDouble("price"));

        items.add(item);
      }
      statement.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return items;
  }


  public static Users getUser(String email){
    Users users = null;
    try {
      PreparedStatement statement = connection.prepareStatement(" "+ "SELECT * FROM users WHERE email = ?");
      statement.setString(1,email);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next()){
        users = new Users();
        users.setId(resultSet.getLong("id"));
        users.setEmail(resultSet.getString("email"));
        users.setPassword(resultSet.getString("password"));
        users.setFullName(resultSet.getString("full_Name"));
      }
      statement.close();
    }catch (Exception e){
      e.printStackTrace();
    }
    return users;
  }

}
