/*
 *                 IFS Research & Development
 *
 *  This program is protected by copyright law and by international
 *  conventions. All licensing, renting, lending or copying (including
 *  for private use), and all other use of the program, which is not
 *  expressively permitted by IFS Research & Development (IFS), is a
 *  violation of the rights of IFS. Such violations will be reported to the
 *  appropriate authorities.
 *
 *  VIOLATIONS OF ANY COPYRIGHT IS PUNISHABLE BY LAW AND CAN LEAD
 *  TO UP TO TWO YEARS OF IMPRISONMENT AND LIABILITY TO PAY DAMAGES.
 */
package dbaccess.jdbc;

import java.sql.*;
import java.util.Properties;

/**
 * @author Ashan
 */
public class Tester {
   // good.
      public static void main(String[] args) throws SQLException {
         String url = "jdbc:derby:zoo";

         Properties p = new Properties();
         p.setProperty("user", "ee");
         p.setProperty("password", "ee");
         try (Connection conn = DriverManager.getConnection(url, p);
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery("select name from animal")) {
            while (rs.next())
               System.out.println(rs.getString(1));
         }
      }
}
