package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Validate
 */

public class Validatation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validatation() {
        super();
    }
    
    private String validation(String userName, String email, String psw, String cpsw) {
    	String nameRagix = "^[a-z0-9_-]{3,15}$";
    	String pswRagix =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{6,20})";
    	Pattern namePattern = Pattern.compile(nameRagix);
    	Pattern pswPattern = Pattern.compile(pswRagix);
    	Matcher nameMatcher = namePattern.matcher(userName);
    	Matcher pswMatcher = pswPattern.matcher(psw); 
    	if(!nameMatcher.matches()) {
    		return "Enter valid user name";
    	}
    	else if(email.length()==0){
    		return "Enter valid email-Id";
    	}
    	else if(!pswMatcher.matches()) {
    		return "Enter valid password";
    	}
    	else if(!psw.equals(cpsw)) {
    		return "Enter same password";
    	}
    	return "validated";
    }
    
    private String inserData(String userName, String email, String psw ){
    	ServletContext context = getServletContext();
    	Connection conn=null;
    	PreparedStatement ps,ps1;
    	ResultSet rs;
    	String query = "select username from user where username = ?";
    	String query1 = "Insert into user (`username`,`password`,`email`) values(?,?,?)";
    	String url=context.getInitParameter("url");
    	String user = context.getInitParameter("user");
    	String password = context.getInitParameter("password");
    	try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn=DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			ps=conn.prepareStatement(query);
			ps.setString(1, userName);
			rs =  ps.executeQuery();
			
			if(rs.next()){
				return "User Name Exists";
			}
			ps1=conn.prepareStatement(query1);
			ps1.setString(1, userName);
			ps1.setString(2, psw);
			ps1.setString(3, email);
			ps1.execute();
    	} catch (SQLException e) {
			e.printStackTrace();
			return "Email Id Exists";
		}
    	return "Profile Created";
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String psw = request.getParameter("password");
		String cpsw = request.getParameter("confirmPassword");
		String result = validation(userName, email, psw, cpsw);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

		if(!result.equals("validated")) {
			request.setAttribute("result", result);
			rd.forward(request, response);
		}
		else {
			String output = inserData(userName, email, psw);
			if(!output.equals("Profile Created")) {
				request.setAttribute("result", output);
				rd.forward(request, response);
			}
			else {
				out.println(output);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
