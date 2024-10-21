package ControllerSidebar;

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

@WebServlet("/ChiTietSanPhamController")
public class ChiTietSanPhamController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
  
    public ChiTietSanPhamController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			String idParam = request.getParameter("idsp");
			int id_sp = Integer.parseInt(idParam);
			
			List<SanPham> list_sp = SanPhamDAO.LayToanSanPhamTheoID(request,id_sp);
			request.setAttribute("list_sp", list_sp);
		} 
		catch (Exception e) {
		}
		RequestDispatcher rd = request.getRequestDispatcher("/View/Admin/Sidebar/ChiTietSanPham.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
