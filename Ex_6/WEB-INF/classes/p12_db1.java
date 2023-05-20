import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class p12_db1 extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root", "");
            if(conn!=null)
            {
             out.println("<h1> Characters Informations</h1>");
            }
            stmt = conn.createStatement();
            String sql;

        sql = "SELECT * FROM charcters";
        ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){

          String pid = rs.getString("pid");
          String name = rs.getString("name");
          String country = rs.getString("country");
          String fmovie = rs.getString("favmovie");
          String fhero = rs.getString("favhero");
          out.println("<hr><p> <b>Charac ID :</b> " + pid + "<br>");
          out.println("<b>Name : </b>" + name + "<br>");
         out.println("<b>Country : </b>" + country + "<br>");
         out.println("<b>Fav Movie : </b>" + fmovie + "<br>");
         out.println("<b>Fav Hero : </b>" + fhero + "<br></p>");
        }
out.println("</body></html>");

rs.close();
stmt.close();
conn.close();
}
catch(Exception e)
{
System.out.print("Do not connect to DB - Error:"+e);
}
}
}
