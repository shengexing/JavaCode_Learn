// 章节22.03.0            创建HttpServlet对象
package ex22_03_0;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSample
 */
@WebServlet("/ServletSample")
public class ServletSample extends HttpServlet {		// 第一步：扩展HttpServlet抽象类
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// 第二步：重写doGet()方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myName = ""; 		// 第三步：获取HTTP请求信息
		Enumeration<?> keys = request.getParameterNames();
		while(keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			if(key.equalsIgnoreCase("myName"))
				myName = request.getParameter(key);
		}
		
		if(myName == "")
			myName = "Hello";
		
		// 第四步：生成HTTP响应
		response.setContentType("text/html");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = response.getWriter();
		out.println("<head><title>Just a basic servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Just a basic servlet</h1>");
		out.println("<p>" + myName + ", this is a very basic servlet that writes an HTML page.");
		out.println("For instruction son runing those sample son your Web Sphere 应用服务器, " + "open the page: ");
		out.println("<pre> http://<em>your.server.name</em>/IBMWebAs/samples/index.aspl </pre>");
		out.println("where <em>your.server.name</em> is the host name of your Web Sphere 应用服务器." + "</p>");
		out.print("</body></html>");
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
