package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import entity.Good;

/**
 * Servlet implementation class handleUpdateGood
 */
@WebServlet("/handleUpdateGood")
public class handleUpdateGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleUpdateGood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name=request.getParameter("goodname");
		String keystr=request.getParameter("key");
		GoodsDao GD=new GoodsDao();
		Good good=GD.displayGoodByName(name);
		int ID=good.getGid();
		int key=Integer.parseInt(keystr);
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		switch(key)
		{
		case 1:
			String newprice=request.getParameter("newinfo");
			Boolean ifsuccess1=GD.updateGood(good, 1, newprice);
			if (ifsuccess1)
			{
				Good result1=GD.displayGoodByName(name);
				out.println("<p>update price successfully!<br>");
				out.println("The good information:<br>");
				out.println("ID= "+result1.getGid()+"<br>");
				out.println("name= "+result1.getGname()+"<br>");
				out.println("price= "+result1.getGprice()+"<br>");
				out.println("number= "+result1.getGnum()+"<br>");
				out.println("</p>");
			}
			else {out.println("<p>fail.</p>");}
			break;
		case 2:
			String newnum=request.getParameter("newinfo");
			Boolean ifsuccess2=GD.updateGood(good, 2, newnum);
			if (ifsuccess2)
			{
				Good result2=GD.displayGoodByName(name);
				out.println("<p>update number successfully!<br>");
				out.println("The good information:<br>");
				out.println("ID= "+result2.getGid()+"<br>");
				out.println("name= "+result2.getGname()+"<br>");
				out.println("price= "+result2.getGprice()+"<br>");
				out.println("number= "+result2.getGnum()+"<br>");
				out.println("</p>");
			}
			else {out.println("<p>fail.</p>");}
			break;
		default:
			break;
			}
		out.println("</body></html>");
		}
	}


