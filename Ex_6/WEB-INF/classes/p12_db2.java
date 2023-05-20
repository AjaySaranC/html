import java.io.*; import java.util.*; import javax.servlet.*;
import javax.servlet.http.*; import java.sql.*;
import java.sql.DriverManager; import java.sql.Connection; import java.sql.SQLException;

public class p12_db2 extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html"); 
    Connection conn = null;
    Statement stmt = null;
    PrintWriter out = response.getWriter(); String pid = request.getParameter("pid");
    try {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/player", "root", "");
        stmt = conn.createStatement(); String sql;
        sql = "SELECT * FROM stats where pid = ?"; 
        PreparedStatement pstmt = conn.prepareStatement(sql); 
        pstmt.setString(1, pid);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String name=rs.getString("name"); 
            Integer tot = rs.getInt("total"); 
            Integer mvisit = rs.getInt("mvisit"); 
            Integer fav = rs.getInt("fav"); 
            out.println("<p> <b>User ID :</b> " + pid + "<br>"); 
            out.println("<b>Name : </b>" + name + "<br><hr style='border: 1px solid'><br>");
            out.println("<b>Total Movies : </b>" + gp + "<br>"); 
            out.println("<b>Movies Watched : </b>" + goals + "<br>"); 
            out.println("<b>Fav : </b>" + assist + "<br>"); 
            }
            out.println("</body></html>");
            stmt.close();
            conn.close();
            } catch (Exception e) {
                System.out.print("Do not connect to DB - Error:" + e);
                }
     }
}