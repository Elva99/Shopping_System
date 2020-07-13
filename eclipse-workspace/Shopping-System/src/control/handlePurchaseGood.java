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
 * Servlet implementation class handlePurchaseGood
 */
@WebServlet("/handlePurchaseGood")
public class handlePurchaseGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handlePurchaseGood() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String namestr=request.getParameter("nametobuy");
		String numberstr=request.getParameter("numbertobuy");
		GoodsDao GD=new GoodsDao();
		Good good=GD.displayGoodByName(namestr);
		if (good.getGnum()-Integer.parseInt(numberstr)>=0)
		{
			GD.purchaseGood(good, Integer.parseInt(numberstr));
			out.println("<html><body><p>Your order confirmation:<br>");
			out.println("name: "+good.getGname()+"</br>");
			out.println("number: "+numberstr+"</br></p></body></html>");
		}
		
		else
		{
			out.println("<html><body><p>We only have "+good.getGnum()+" "+good.getGname()+"(s) in the store.</p></body></html>");
		}
		
	}

}
