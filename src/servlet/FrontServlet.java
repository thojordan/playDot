package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.CreRandom;
import cn.QxchisDao;
import cn.QxcnoDao;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int iNum=10;
		//随机5个数
		CreRandom cr = new CreRandom();
		String szEx1 = request.getParameter("exclude1");
		String szEx2 = request.getParameter("exclude2");
		String szIn1 =request.getParameter("include1");
		String szIn2 =request.getParameter("include2");
		ArrayList list = cr.availNum(szEx1,szEx2,szIn1,szIn2);
		
		request.setAttribute("qxcrand", list);
		request.setAttribute("exclude1", szEx1);
		request.setAttribute("exclude2", szEx2);
		request.setAttribute("include1", szIn1);
		request.setAttribute("include2", szIn2);
		//不可能的数据
		String page = null;
        page = request.getParameter("page");
        if(page == null || page=="")
            page = "1";
        QxcnoDao qxcnoDao = new QxcnoDao();
        request.setAttribute("qxcno",qxcnoDao.findByPage(Integer.parseInt(page)));
        request.setAttribute("pagenum",qxcnoDao.userCount()/iNum+1);//总页数
        request.setAttribute("page", page);//当前页
        
        //历史数据
        String hispage = null;
        hispage = request.getParameter("hispage");
        if(hispage == null || hispage=="")
        	hispage = "1";
        QxchisDao qxchisDao = new QxchisDao();
        request.setAttribute("qxchis",qxchisDao.findByPage(Integer.parseInt(hispage)));
        request.setAttribute("hispagenum",qxchisDao.userCount()/iNum+1);//总页数
        request.setAttribute("hispage", hispage);//当前页
        
        request.getRequestDispatcher("Qxc.jsp").forward(request, response);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
