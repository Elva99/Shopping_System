package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SalesmanDao;
import entity.Salesman;

/**
 * Servlet implementation class handleSignUp
 */
@WebServlet("/handleSignUp")
public class handleSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newnamestr=request.getParameter("newusername");
		String newpwstr=request.getParameter("newpassword");
		Salesman man=new Salesman(newnamestr,newpwstr);
		SalesmanDao SD=new SalesmanDao();
		Boolean ifSuccess=SD.signUp(man);
		if (!ifSuccess)
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><body><p>fail to sign up. Please try again.<br>");
		}
		response.sendRedirect("signUpSuccess.jsp");
		
		/*
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body><p>You have signed up.<br>");
		out.println("Your username is: "+newnamestr+"<br>");
		out.println("Your password is: "+newpwstr+"<br>");
		out.println("<a href=\"ExitPage.html\"> Exit</a>");
		out.println("<a href=\"signInPage.html\"> Sign in</a>");
		out.println("</p></body></html>");
		*/
		
	}

}
