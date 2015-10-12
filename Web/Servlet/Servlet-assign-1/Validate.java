package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
    }

    private String validation(String userName, String psw, String rpsw) {
    	String nameRagix = "^[a-z0-9_-]{3,15}$";
    	String pswRagix =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    	Pattern namePattern = Pattern.compile(nameRagix);
    	Pattern pswPattern = Pattern.compile(pswRagix);
    	java.util.regex.Matcher nameMatcher = namePattern.matcher(userName);
    	java.util.regex.Matcher pswMatcher = pswPattern.matcher(psw); 
    	
    	if(!nameMatcher.matches()) {
    		return "Please enter correct user name (username should be 3 to 15 charcherter long and can have a-z or 0-9 or - or _ )";
    	}
    	else if(!pswMatcher.matches()) {
    		return "Please enter correct password (password should be 6 to 20 charecter long and have atleast one (@#$%) and one digit and one lowecase and one upeercase Latter)";
    	}
    	else if(!psw.equals(rpsw)) {
    		return "please enter both passwords same";
    	}
    	else {
    		return "Profile Successfully created";
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String psw = request.getParameter("password");
		String rpsw = request.getParameter("rpassword");
		String output = validation(userName, psw, rpsw);
		
		out.println(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
