import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Main extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    if (req.getRequestURI().endsWith("/db")) {
      showDatabase(req,resp);
    } else {
      showHome(req,resp);
    }
  }

  private void showHome(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.getWriter().print("[" +
            "{" +
            "\"full_name\":\"Afgan Cahyo Saputra\"," +
            "\"gender\":\"1\"," +
            "\"birthdate\":\"2012-02-09\"," +
            "\"marital_status\":\"1\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"73585acd-1784-4fff-ad32-00142084dddc\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\"," +
            "\"family_id\":\"73585acd-1784-4fff-ad32-00142084dddc\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:42.129+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.808+07:00\"," +
            "\"id\":\"87e70ca9-a17c-4026-b930-15a75ca0fde3\"" +
            "}," +
            "{" +
            "\"full_name\":\"Usup\"," +
            "\"gender\":\"1\"," +
            "\"birthdate\":\"1936-11-30\"," +
            "\"marital_status\":\"2\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"1\"," +
            "\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:43.175+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.828+07:00\"," +
            "\"id\":\"638aae27-8dc5-43b4-8741-f573a8612a15\"" +
            "}," +
            "{" +
            "\"full_name\":\"Djumijem\"," +
            "\"gender\":\"2\"," +
            "\"birthdate\":\"1938-12-31\"," +
            "\"marital_status\":\"2\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"2\"," +
            "\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:43.526+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.833+07:00\"," +
            "\"id\":\"79e5e158-1bf3-4947-898f-97b2624d59a8\"" +
            "}," +
            "{" +
            "\"full_name\":\"Semi\"," +
            "\"gender\":\"2\"," +
            "\"birthdate\":\"1970-05-04\"," +
            "\"marital_status\":\"2\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\"," +
            "\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:43.883+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.837+07:00\"," +
            "\"id\":\"739ab421-372d-45a8-84be-7342ca4d41c9\"" +
            "}," +
            "{" +
            "\"full_name\":\"Jumeno\"," +
            "\"gender\":\"1\"," +
            "\"birthdate\":\"1949-12-31\"," +
            "\"marital_status\":\"2\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\"," +
            "\"family_id\":\"6d8ad138-1592-48e6-bda2-ddfd33576aa7\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:44.254+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.853+07:00\"," +
            "\"id\":\"b22a569f-16e2-4256-9871-79b6aa2fa4ed\"" +
            "}," +
            "{" +
            "\"full_name\":\"Ny. Gito Pawiro\"," +
            "\"gender\":\"2\"," +
            "\"birthdate\":\"1938-07-20\"," +
            "\"marital_status\":\"2\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"2\"," +
            "\"family_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:45.782+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.869+07:00\"," +
            "\"id\":\"d19fc5fc-e506-4132-9708-91f127c91bb2\"" +
            "}," +
            "{" +
            "\"full_name\":\"Sukarjo\"," +
            "\"gender\":\"1\"," +
            "\"birthdate\":\"1969-12-03\"," +
            "\"marital_status\":\"1\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\"," +
            "\"family_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:46.115+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.884+07:00\"," +
            "\"id\":\"e8eea9ad-c206-472b-b776-ab6f3ec7862a\"" +
            "}," +
            "{" +
            "\"full_name\":\"Supangat\"," +
            "\"gender\":\"1\"," +
            "\"birthdate\":\"1972-09-21\"," +
            "\"marital_status\":\"1\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"3\"," +
            "\"family_id\":\"0c062f4a-b143-4239-a31e-d631fd15a82f\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:46.472+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.892+07:00\"," +
            "\"id\":\"5da3256e-8cd9-4345-ba7a-ceb856c89bd4\"" +
            "}," +
            "{" +
            "\"full_name\":\"Mulyorejo / Mugi Mulyono\"," +
            "\"gender\":\"1\"," +
            "\"birthdate\":\"1937-12-11\"," +
            "\"marital_status\":\"2\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"1\"," +
            "\"family_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:47.699+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.897+07:00\"," +
            "\"id\":\"e14a0b7e-f2ba-4d9c-924b-2fcfabe2d367\"" +
            "}," +
            "{" +
            "\"full_name\":\"Ny. Wagiyem / Mugimulyono\"," +
            "\"gender\":\"2\"," +
            "\"birthdate\":\"1939-04-08\"," +
            "\"marital_status\":\"2\"," +
            "\"cellphone_number\":null," +
            "\"household_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\"," +
            "\"household_seq\":null," +
            "\"relation_with_household_head\":\"2\"," +
            "\"family_id\":\"45358877-a3f7-44fe-b51b-294384e69d50\"," +
            "\"relation_with_family_head\":null," +
            "\"birthplace\":\"Sleman\"," +
            "\"state\":\"udb_imported\"," +
            "\"created_at\":\"2014-11-27T11:01:48.035+07:00\"," +
            "\"updated_at\":\"2014-11-27T12:05:42.909+07:00\"," +
            "\"id\":\"3dbcea29-fc87-44f9-babc-8c2ebd1377e3\"" +
            "}" +
            "]");
  }

  private void showDatabase(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Connection connection = null;
    try {
      connection = getConnection();

      Statement stmt = connection.createStatement();
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

      String out = "Hello!";
      while (rs.next()) {
          out += "Read from DB: " + rs.getTimestamp("tick") + "";
      }

      resp.getWriter().print(out);
    } catch (Exception e) {
      resp.getWriter().print("There was an error: " + e.getMessage());
    } finally {
      if (connection != null) try{connection.close();} catch(SQLException e){}
    }
  }

  private Connection getConnection() throws URISyntaxException, SQLException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));

    String username = dbUri.getUserInfo().split(":")[0];
    String password = dbUri.getUserInfo().split(":")[1];
    int port = dbUri.getPort();

    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath();

    return DriverManager.getConnection(dbUrl, username, password);
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new Main()),"/*");
    server.start();
    server.join();
  }
}
