package serv.assessment;

import java.io.IOException; import java.io.PrintWriter; import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.Statement;

import javax.servlet.ServletException; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    System.out.println("test");
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost/registration";
    response.setContentType("text/html");
    String msg = " ";

    String email = request.getParameter("email");
    String password = request.getParameter("pass");
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","root");  

        String strQuery = "select * from registeruser WHERE email='"
                + email + "' and pass='" + password + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(strQuery);
        if (rs.next()) {
            msg = "HELLO " + email + "! Your login is SUCESSFULL";

        } else {
            msg = "HELLO " + email + "!Your login is UNSUCESSFULL";
        }
        rs.close();
        st.close();
        System.out.println("test :" + msg);
        PrintWriter out = response.getWriter();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}