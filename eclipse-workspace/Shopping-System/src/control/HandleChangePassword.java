package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SalesmanDao;
import entity.Salesman;

/**
 * Servlet implementation class HandleChangePassword
 */
@WebServlet("/HandleChangePassword")
public class HandleChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleChangePassword() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if (session==null) {out.println("Error: no session available"); return;}
		String oldpw=request.getParameter("oldpw");
		String username=(String) session.getAttribute("uname");
		String userpassword=(String) session.getAttribute("upassword");
		if (!userpassword.equals(oldpw))
		{
			String error="The old password is not corrert, please enter it again.";
			session.setAttribute("error", error);
			response.sendRedirect("changePassword.jsp");
		}
		else
		{
			String newpw=request.getParameter("newpw");
			SalesmanDao SD=new SalesmanDao();
			Salesman staff=new Salesman(username,userpassword);
			Boolean ifsuccess=SD.updateSalesmanPd(staff, newpw);
			if (ifsuccess)
			{
				out.println("The password is changed.");
			}
			else
			{
				out.println("Fail.");
			}
		}
	}

}
