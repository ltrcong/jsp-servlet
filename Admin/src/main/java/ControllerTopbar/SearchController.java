package ControllerTopbar;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import BEAN.SanPham;
import DAO.SanPhamDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public SearchController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if(request.getCharacterEncoding()==null) 
		{	
			request.setCharacterEncoding("UTF-8"); 
		}
		//Lấy dữ liệu từ form 
		String search = request.getParameter("timkiem");
		
		List<SanPham> list_sp = SanPhamDAO.TimKiem(request,search);
		request.setAttribute("list_sp", list_sp);
		RequestDispatcher rd = request.getRequestDispatcher("/View/Admin/Sidebar/SanPham.jsp");
		rd.forward(request, response);
	}

}
