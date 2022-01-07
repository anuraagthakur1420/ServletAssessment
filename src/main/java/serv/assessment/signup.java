package serv.assessment;

import java.io.IOException; 
import java.io.PrintWriter; import java.sql.Connection; import java.sql.DriverManager; import java.sql.PreparedStatement;

import javax.servlet.ServletException; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse;

public class signup extends HttpServlet {

private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    System.out.println("test");
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String n=request.getParameter("name");
String p=request.getParameter("pass");
String e=request.getParameter("email"); 
String co=request.getParameter("country");
String c=request.getParameter("city");




try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");

PreparedStatement ps=con.prepareStatement("insert into registeruser values(?,?,?,?,?)");

ps.setString(1,n);
ps.setString(2,p);
ps.setString(3,e);
ps.setString(4,co);
ps.setString(5,c);

int i=ps.executeUpdate();
if(i>0)
out.print("You are successfully registered...");

System.out.println("test");
}catch (Exception e2) {System.out.println(e2);}

out.close();
}

}
