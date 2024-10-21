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

@WebServlet("/LaySanPhamTheoIDDMController")
public class LaySanPhamTheoIDDMController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
    public LaySanPhamTheoIDDMController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			String idParam = request.getParameter("id_dm");
			int id_dm = Integer.parseInt(idParam);
			
			List<SanPham> list_sp = SanPhamDAO.LayToanBoSanPhamTheoIDDM(request,id_dm);
			request.setAttribute("list_sp", list_sp);
		} 
		catch (Exception e) {
		}
		RequestDispatcher rd = request.getRequestDispatcher("/View/Admin/Sidebar/LayToanBoSanPhamTheoIDDM.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
