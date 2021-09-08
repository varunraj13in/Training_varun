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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String card = request.getParameter("card");
		String balance = request.getParameter("val");
		HttpSession session = request.getSession();
		boolean status = false;
		PrintWriter pw = response.getWriter();

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/registrationDb;create=true",
					"user", "user");

			PreparedStatement ps = con.prepareStatement("insert into app.registration values(?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from app.registration where userid=? ");

			ps.setString(1, user);
			ps2.setString(1, user);
			ResultSet rs = ps2.executeQuery();
			status = rs.next();
			if (status == true) {
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Username exists');");
				pw.println("window.location.assign('/WebApp/index.jsp');");
				pw.println("</script>");
			} else {
				session.setAttribute("uname", user);
				ps.setString(2, password);
				ps.setString(3, card);
				ps.setString(4, balance);

				int i = ps.executeUpdate();
				if (i > 0)
					response.sendRedirect("page.jsp");
			}

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
