import javax.servlet.*; import javax.servlet.http.*; import java.io.*;

public class hitcount extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html"); PrintWriter out = response.getWriter(); HttpSession session = request.getSession(); String name=request.getParameter("name");
Integer hitCount = (Integer)session.getAttribute("hitCount"); if(hitCount == null) {
hitCount = 0;
}
hitCount++; session.setAttribute("hitCount", hitCount);
out.println("<p>Welcome "+name+"</p><hr>"); out.println("<p>No.of Hits: " + hitCount + "</p>"); out.println("<p>Session Id: " + session.getId() + "</p>");
}
}
