package ControllerSidebar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import BEAN.SanPham;
import DAO.SanPhamDAO;

@WebServlet("/ThemSanPhamController")
public class ThemSanPhamController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ThemSanPhamController() 
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

		SanPham sp = new SanPham();
		
		sp.setId_dm(id_dm);
		sp.setTen_sp(ten_sp);
		sp.setGia_sp(gia_sp);
		sp.setBaohanh(baohanh);
		sp.setPhukien(phukien);
		sp.setTinhtrang(tinhtrang);
		sp.setKhuyenmai(khuyenmai);
		sp.setTrangthai(trangthai);
		sp.setDacbiet(dacbiet);
		sp.setChitiet_sp(chitiet_sp);
		
		boolean test = SanPhamDAO.ThemSanPham(request, sp);
		if(test) 
		{
			int id_sp = SanPhamDAO.LayIDSanPham(request, sp);
			request.setAttribute("id_sp", id_sp);
			
			RequestDispatcher rd = request.getRequestDispatcher("UpLoadAnhForward");
			rd.forward(request, response);
		} 
		else
		{
			request.setAttribute("msg_themSP", "Bạn Thêm Không Thành Công");
			RequestDispatcher rd = request.getRequestDispatcher("ThemSanPhamForward");
			rd.forward(request, response);
		}
	}

}
