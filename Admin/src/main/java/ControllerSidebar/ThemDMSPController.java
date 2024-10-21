package ControllerSidebar;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.DMSanPham;
import DAO.DMSanPhamDAO;

@WebServlet("/ThemDMSPController")
public class ThemDMSPController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ThemDMSPController() 
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
		// Lấy dữ liệu từ form
		String tendm = request.getParameter("ten_dm");

		DMSanPham dmsp = new DMSanPham();
		
		dmsp.setTen_dm(tendm);
		
		boolean test = DMSanPhamDAO.ThemDanhMucSanPham(request, dmsp);
		if(test) 
		{
			request.setAttribute("msg_ThemDMSP","Chúc Mừng Bạn Đã Thêm Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("ThemDMSPForward");
			rd.forward(request, response);
		} 
		else
		{
			request.setAttribute("msg_ThemDMSP", "Bạn Thêm Không Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("ThemDMSPForward");
			rd.forward(request, response);
		}
	}

}
