// 章节22.05.1            使用Forward转向
package ex22_05_1;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = request.getParameter("destination");
		if("file".equals(destination)) {
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/web.xml");
			d.forward(request, response);
		} else if("jsp".equals(destination)) {
			request.setAttribute("date", new Date());
			
			// attributes are reset between requests.
			RequestDispatcher dispatcher = request.getRequestDispatcher("/forward.jsp");
			dispatcher.forward(request, response);
		} else if("servlet".equals(destination)) {
			RequestDispatcher disp = request.getRequestDispatcher("/servlet/LifeCycleServlet");
			disp.forward(request, response);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("缺少参数。用法：" + request.getRequestURI() + "?destination=jsp或者file或者servlet");
		}
	}

}
