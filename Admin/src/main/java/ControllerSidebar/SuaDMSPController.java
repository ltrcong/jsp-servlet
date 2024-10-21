package ControllerSidebar;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.DMSanPham;
import DAO.DMSanPhamDAO;

@WebServlet("/SuaDMSPController")
public class SuaDMSPController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
    public SuaDMSPController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			String idParam = request.getParameter("id_dm");
			int id_dm = Integer.parseInt(idParam);
			
			List<DMSanPham> list_dmsp = DMSanPhamDAO.LayToanDMSPTheoID(request,id_dm);
			request.setAttribute("list_dmsp", list_dmsp);
		} 
		catch (Exception e) {
		}
		RequestDispatcher rd = request.getRequestDispatcher("SuaDMSanPhamForward");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if(request.getCharacterEncoding()==null) 
		{	
			request.setCharacterEncoding("UTF-8"); 
		}
		String iddmParam = request.getParameter("id_dm");
		int id_dm = Integer.parseInt(iddmParam);
		String ten_dm = request.getParameter("ten_dm");
		
		boolean test = DMSanPhamDAO.SuaDMSanPham(request,id_dm,ten_dm );
		if(test) 
		{
			request.setAttribute("msg_SuaDMSP", "Bạn Sửa Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("SuaDMSanPhamForward");
			rd.forward(request, response);
		} 
		else
		{
			request.setAttribute("msg_SuaDMSP", "Bạn Sửa Không Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("SuaDMSanPhamForward");
			rd.forward(request, response);
		}
	}

}
