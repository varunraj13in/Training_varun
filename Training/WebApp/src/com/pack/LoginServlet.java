package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();  

		boolean status = false;

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/registrationDb;create=true",
					"user", "user");

			PreparedStatement ps = con
					.prepareStatement("select * from app.registration where userid=? and password=?");

			ps.setString(1, uname);
			ps.setString(2, upwd);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status == true) {
				session.setAttribute("uname", uname);
	            request.getRequestDispatcher("/page.jsp").forward(request, response);
			}
			else {
				response.setContentType("text/html");  
				pw.println("<script type=\"text/javascript\">");  
				pw.println("alert('Retry Again!');");  
				pw.println("window.location.assign('/WebApp/login.jsp');");  
				pw.println("</script>");
	            
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
