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

@WebServlet("/SuaSanPhamController")
public class SuaSanPhamController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
    public SuaSanPhamController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			String idParam = request.getParameter("id_sp");
			int id_sp = Integer.parseInt(idParam);
			
			List<SanPham> list_sp = SanPhamDAO.LayToanSanPhamTheoID(request,id_sp);
			request.setAttribute("list_sp", list_sp);
		} 
		catch (Exception e) {
		}
		RequestDispatcher rd = request.getRequestDispatcher("SuaSanPhamForward");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if(request.getCharacterEncoding()==null) 
		{	
			request.setCharacterEncoding("UTF-8"); 
		}
		
		String idspParam = request.getParameter("id_sp");
		int id_sp = Integer.parseInt(idspParam);
		String iddmParam = request.getParameter("id_dm");
		int id_dm = Integer.parseInt(iddmParam);
		String ten_sp = request.getParameter("ten_sp");
		String gia_sp = request.getParameter("gia_sp");
		String baohanh = request.getParameter("baohanh");
		String phukien = request.getParameter("phukien");
		String tinhtrang = request.getParameter("trangthai");
		String khuyenmai = request.getParameter("khuyenmai");
		String trangthai = request.getParameter("trangthai");
		String dacbietParam = request.getParameter("dacbiet");
		int dacbiet = Integer.parseInt(dacbietParam);
		String chitiet_sp = request.getParameter("chitiet_sp");
		
		
		boolean test = SanPhamDAO.SuaSanPham(request,id_sp,id_dm,ten_sp,gia_sp,baohanh,phukien,
				tinhtrang,khuyenmai,trangthai,dacbiet,chitiet_sp );
		if(test) 
		{
			request.setAttribute("msg_SuaSP", "Bạn Sửa Thành Công");
			request.setAttribute("id_sp", id_sp);
			RequestDispatcher rd = request.getRequestDispatcher("SuaSanPhamForward");
			rd.forward(request, response);
		} 
		else
		{
			request.setAttribute("msg_SuaSP", "Bạn Sửa Không Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("SuaSanPhamForward");
			rd.forward(request, response);
		}
	}

}
