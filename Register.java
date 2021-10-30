package allServe;
import java.sql.*;
import myPack.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			Connection cn=MySqlConnection.getCn();
			HttpSession s=request.getSession(false);
			String uname=(String)s.getAttribute("uname");
			String umail=(String)s.getAttribute("umail");
			PreparedStatement ps=cn.prepareStatement("update regis set uname=?,umail=?");
			ps.setString(1, uname);
			ps.setString(2, umail);
			
			ps.execute();
			out.print("We'll reach you soon!");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
