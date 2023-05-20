
import javax.servlet.*; import javax.servlet.http.*; import java.io.*;

public class hidden extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html"); PrintWriter out = response.getWriter();

HttpSession session = request.getSession();

String sessionid = request.getParameter("sessionid"); String name = request.getParameter("name");
String age = request.getParameter("age");

session.setAttribute("sessionid", sessionid); session.setAttribute("name", name); session.setAttribute("age", age);

out.println("<h1>Session values stored successfully</h1>"); out.println("<p>Session Id : " + sessionid + "</p>"); out.println("<p>Name : " + name + "</p>"); out.println("<p>Age : " + age + "</p>");
}
}
